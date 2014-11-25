package com.fdi.aplicacionWeb.domain.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.domain.repository.AvisoRepository;
import com.fdi.aplicacionWeb.util.SessionUtil;

@Repository
public class AvisoRepositoryImpl implements AvisoRepository {

	public List<Aviso> getAllAvisos() {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Aviso> products = (List<Aviso>)  session.createQuery("from Aviso a").list();
		tx.commit();
		session.close();
		return products;
	}

	public Aviso getAvisoById(String avisotID) {
		// TODO Auto-generated method stub
		return null;
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
		Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from Aviso a where a.postInternalId= :postInternalId");
        query.setString("postInternalId", avisoID);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        // hibernateUtil.checkData("select * from Aviso"); 
	}

	public void addAviso(Aviso aviso) {
		System.out.println("AvisoRepositoryImpl");
		System.out.println(aviso);
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(aviso);
		tx.commit();
		session.close();
	}

}
