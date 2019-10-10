package com.cg.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cg.entity.Flight;

@Repository
public class FlightRepoImpl implements FlightRepo {

	@PersistenceContext(name = "MyJPA")
	private EntityManager mgr;
	
	public int save(Flight flight) {
		mgr.persist(flight);
		return flight.getFl_id();
	}

	public Flight fetch(int id) {
		Flight f1 = (Flight)mgr.find(Flight.class, id);
		return f1;
	}

	public List<Flight> list() {
		return mgr.createQuery("from flight").getResultList();
	}

	public List<Flight> findByCarrier(String carrier) {
		return mgr.createNamedQuery("bycarrier").setParameter("car", carrier).getResultList();
	}

}
