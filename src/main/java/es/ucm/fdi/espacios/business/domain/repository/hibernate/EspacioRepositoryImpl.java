package es.ucm.fdi.espacios.business.domain.repository.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.espacios.business.control.EspacioRepository;
import es.ucm.fdi.espacios.business.domain.Espacio;

@Repository
public class EspacioRepositoryImpl implements EspacioRepository{

	static final Logger logger = LoggerFactory.getLogger(EspacioRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Espacio> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Espacio> espacios = session.createQuery("from Espacio e").list();
		logger.info("Obteniendo " + espacios.size() + " espacios");
		return espacios;
	}

	@Override
	public void save(Espacio espacio) {
		logger.info("Añadiendo espacio siguiente: ");
		logger.info(espacio.toString());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(espacio);		
	}

	@Override
	public Espacio getEspacio(Long espacioID) {
		Session session = sessionFactory.getCurrentSession();
		return (Espacio) session.get(Espacio.class, espacioID);
	}

	@Override
	public void eliminar(Long espacioID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("delete from Espacio e where e.id= :id");
		query.setLong("id", espacioID);
		query.executeUpdate();		
	}

}
