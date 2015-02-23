package es.ucm.fdi.anuncios.business;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import es.ucm.fdi.anuncios.business.control.AvisoRepository;
import es.ucm.fdi.anuncios.business.domain.Aviso;
import es.ucm.fdi.anuncios.business.domain.AvisoBuilder;
import es.ucm.fdi.storage.business.boundary.StorageManager;
import es.ucm.fdi.storage.business.entity.StorageObjectId;

@Transactional("portalTransactionManager")
@Service
public class Avisos {
	
	@Autowired
	AvisoRepository avisoRepository;
	
	@Autowired
	StorageManager storageManager;
	
	@Value("#{avisosPrefs[bucket]}")
	private String bucket;
	
	AvisoRepository getAvisoRepository() {
		return avisoRepository;
	}

	void setAvisoRepository(AvisoRepository avisoRepository) {
		this.avisoRepository = avisoRepository;
	}

	StorageManager getStorageManager() {
		return storageManager;
	}

	void setStorageManager(StorageManager manager) {
		this.storageManager = manager;
	}

	String getBucke() {
		return bucket;
	}

	void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public List<Aviso> getAvisos() {
		return avisoRepository.getAllAvisos();
	}

	public Aviso getAviso(Long avisoID) {
		return avisoRepository.getAviso(avisoID);
	}

	public List<Aviso> getAvisosByCategory(String category) {
		return avisoRepository.getAvisosByCategory(category);
	}

	public void eliminarAviso(Long avisoID) throws IOException {
		Aviso aviso = avisoRepository.getAviso(avisoID);
		String adjunto = aviso.getAdjunto();
		if (adjunto != null) {
			StorageObjectId id = storageManager.getObjectId(adjunto);
			storageManager.removeObject(id);
		}
		avisoRepository.eliminarAviso(aviso);
	}

	public void addAviso(AvisoBuilder builder) throws IOException {
		if (builder.getFechaCreacion() ==  null) {
			builder.setFechaCreacion(DateTime.now());
		}
		Aviso aviso = builder.build();
		avisoRepository.addAviso(aviso);
		MultipartFile file = builder.getAdjunto();
		if (file != null && !file.isEmpty()) {
			String key = getStorageKey(aviso.getId());
			String mimeType = file.getContentType();
			storageManager.putObject(bucket, key, mimeType, file.getInputStream());
			aviso.setAdjunto(storageManager.getUrl(bucket, key).toExternalForm());
		}
	}
	
	private String getStorageKey(Long id) {
		return "attachment/"+Long.toString(id);
	}

	public void actualizaAviso(AvisoBuilder builder) throws IOException {
		Aviso newAviso = builder.build();
		Aviso aviso = avisoRepository.getAviso(newAviso.getId());
		String adjunto = aviso.getAdjunto();
		if (adjunto != null) {
			StorageObjectId id = storageManager.getObjectId(adjunto);
			storageManager.removeObject(id);
			aviso.setAdjunto(null);
		}
		MultipartFile file = builder.getAdjunto();
		if (file != null && !file.isEmpty()) {
			String key = getStorageKey(newAviso.getId());
			String mimeType = file.getContentType();
			storageManager.putObject(bucket, key, mimeType, file.getInputStream());
			newAviso.setAdjunto(storageManager.getUrl(bucket, key).toExternalForm());
		}
		BeanUtils.copyProperties(newAviso, aviso);
		avisoRepository.addAviso(aviso);
	}
}
