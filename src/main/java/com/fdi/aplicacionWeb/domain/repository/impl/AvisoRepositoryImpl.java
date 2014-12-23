package com.fdi.aplicacionWeb.domain.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.domain.repository.AvisoRepository;
import com.fdi.aplicacionWeb.util.SessionUtil;

@Transactional
@Repository
public class AvisoRepositoryImpl implements AvisoRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Aviso> getAllAvisos() {
		//		Session session = SessionUtil.getSession();
		//			Transaction tx = session.beginTransaction();
		//			List<Aviso> products = (List<Aviso>)  session.createQuery("from Aviso a").list();
		//		tx.commit();
		//		session.close();
		//		return products;
		Session session = sessionFactory.getCurrentSession(); 
		List<Aviso> avisos =  session.createQuery("from Aviso a").list();
		System.out.println(avisos);
		System.out.println("--------------------------------------------");
		return 	avisos;
	}

	public Aviso getAvisoById(String avisoID) {
//		Session session = SessionUtil.getSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery("from Aviso a where a.postInternalId =:postInternalId");
//		query.setString("postInternalId", avisoID);
//		Aviso aviso = (Aviso)query.uniqueResult();
//		tx.commit();
//		session.close();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Aviso a where a.postInternalId= :postInternalId");
		query.setString("postInternalId", avisoID);
		Aviso aviso = (Aviso)query.uniqueResult();
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
		// hibernateUtil.checkData("select * from Aviso"); 
	}

	@Transactional
	public void addAviso(Aviso aviso) {
		System.out.println("-------------------");
		System.out.println(aviso);
		System.out.println("-------------------");

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(aviso);		
	}

	public void incrementarVisitas(String avisoID) {
		//		Session session = SessionUtil.getSession();
		//        Transaction tx = session.beginTransaction();
		//        Query query = session.createQuery("UPDATE Aviso a SET a.numeroVisitas = a.numeroVisitas+1 where a.postInternalId= :postInternalId");
		//        query.setString("postInternalId", avisoID);
		//        int rowCount = query.executeUpdate();
		//        System.out.println("Rows affected: " + rowCount);
		//        tx.commit();
		//        session.close();				
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE Aviso a SET a.numeroVisitas = a.numeroVisitas+1 where a.postInternalId= :postInternalId");
		query.setString("postInternalId", avisoID);
		query.executeUpdate();
	}

}
