package es.ucm.fdi.espacios.business.domain.repository.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.espacios.business.control.ReservaRepository;
import es.ucm.fdi.espacios.business.domain.Reserva;


@Repository
public class ReservaRepositoryImpl implements ReservaRepository{

	static final Logger logger = LoggerFactory
			.getLogger(ReservaRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public List<Reserva> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Reserva> reservas = session.createQuery("from Reserva r").list();
		logger.info("Obteniendo " + reservas.size() + " reservas");
		return reservas;
	}

	@Override
	public void save(Reserva reserva) {
		logger.info("Añadiendo reserva siguiente: ");
		logger.info(reserva.toString());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(reserva);
		
	}


	@Override
	public Reserva getReserva(Long reservaID) {
		Session session = sessionFactory.getCurrentSession();
		return (Reserva) session.get(Reserva.class, reservaID);
	}


	@Override
	public void eliminar(Reserva reserva) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(reserva);		
	}

}
