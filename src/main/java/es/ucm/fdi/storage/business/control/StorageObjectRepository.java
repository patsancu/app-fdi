package es.ucm.fdi.storage.business.control;

import org.springframework.data.repository.CrudRepository;

import es.ucm.fdi.storage.business.entity.StorageObject;
import es.ucm.fdi.storage.business.entity.StorageObjectId;

public interface StorageObjectRepository extends CrudRepository<StorageObject, StorageObjectId>{
//	
//
//	@Autowired
//	private SessionFactory sf;
//
//	public void save(StorageObject object) {
//		Session session = sf.getCurrentSession();		
//		session.saveOrUpdate(object);
//	}
//
//	public StorageObject getById(StorageObjectId storageObjectId) {
//		Session session = sf.getCurrentSession();
//		return (StorageObject) session.get(StorageObject.class, storageObjectId);
//	}
//
//	public void delete(StorageObject object) {
//		Session session = sf.getCurrentSession();
//		session.delete(object);
//	}
}
