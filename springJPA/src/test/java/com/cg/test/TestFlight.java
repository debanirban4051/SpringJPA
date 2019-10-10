package com.cg.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.entity.Flight;
import com.cg.service.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestFlight {

	@Autowired
	private FlightService service;
	
	@Test
	public void testAddFlight() {
		Flight f1 = new Flight();
		f1.setCarrier("Indigo");
		f1.setSource("Mumbai");
		f1.setDestination("Kolkata");
		f1.setDistance(1155);
		service.addFlight(f1);
	}
	@Test
	public void testGetFlight() {
		Flight f2=service.getFlight(1);
		System.out.println(f2);
	}
	
	@Test
	public void testGetList() {
		List<Flight> flights=service.getList();
	}
}