package es.ucm.fdi.anuncios.business.domain.repository.hibernate;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.anuncios.business.domain.Aviso;
import es.ucm.fdi.anuncios.business.domain.repository.AvisoRepository;

@Repository
public class AvisoRepositoryImpl implements AvisoRepository {

	static final Logger logger = LoggerFactory
			.getLogger(AvisoRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Aviso> getAllAvisos() {
		Session session = sessionFactory.getCurrentSession();
		List<Aviso> avisos = session.createQuery("from Aviso a").list();
		logger.info("Obteniendo avisos. Hay " + avisos.size() + " avisos");
		return avisos;
	}

	@Override
	public Aviso getAviso(Long avisoID) {
		Session session = sessionFactory.getCurrentSession();
		return (Aviso) session.get(Aviso.class, avisoID);
	}

	@Override
	public List<Aviso> getAvisosByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAviso(Long avisoID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("delete from Aviso a where a.id= :id");
		query.setLong("id", avisoID);
		query.executeUpdate();
	}

	@Override
	public void eliminarAviso(Aviso aviso) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(aviso);
	}

	@Override
	public void addAviso(Aviso aviso) {
		logger.info("Añadiendo aviso siguiente: ");
		logger.info(aviso.toString());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(aviso);
	}
}
