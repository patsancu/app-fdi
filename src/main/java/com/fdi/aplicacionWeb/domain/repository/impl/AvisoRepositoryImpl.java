package com.fdi.aplicacionWeb.domain.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.domain.repository.AvisoRepository;

@Transactional
@Repository
public class AvisoRepositoryImpl implements AvisoRepository {
	
	static final Logger logger = Logger.getLogger(AvisoRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Aviso> getAllAvisos() {
		Session session = sessionFactory.getCurrentSession(); 
		List<Aviso> avisos =  session.createQuery("from Aviso a").list();
		logger.info("Obteniendo avisos. Hay " + avisos.size() + " avisos");
		return 	avisos;
	}

	public Aviso getAvisoById(String avisoID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Aviso a where a.postInternalId= :postInternalId");
		query.setString("postInternalId", avisoID);
		Aviso aviso = (Aviso)query.uniqueResult();
		logger.info("Obteniendo siguiente aviso:");
		logger.info(aviso);
		return aviso;
	}

	public List<Aviso> getAvisosByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminarAviso(String avisoID){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Aviso a where a.postInternalId= :postInternalId");
		query.setString("postInternalId", avisoID);
		query.executeUpdate();
		logger.info("Se quiere eliminar el aviso con ID: " + avisoID);
		// hibernateUtil.checkData("select * from Aviso"); 
	}

	@Transactional
	public void addAviso(Aviso aviso) {
		logger.info("Añadiendo aviso siguiente: ");
		logger.info(aviso);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(aviso);		
	}

	public void incrementarVisitas(String avisoID) {			
		Session session = sessionFactory.getCurrentSession();
		logger.info("Incrementando visitas del aviso con id:" + avisoID);
		Query query = session.createQuery("UPDATE Aviso a SET a.numeroVisitas = a.numeroVisitas+1 where a.postInternalId= :postInternalId");
		query.setString("postInternalId", avisoID);
		query.executeUpdate();
		
	}

}
