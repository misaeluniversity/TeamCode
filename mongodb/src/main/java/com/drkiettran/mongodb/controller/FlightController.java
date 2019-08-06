package com.drkiettran.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Flight;
import com.drkiettran.mongodb.repository.AirportRepositoryImpl;
import com.drkiettran.mongodb.repository.FlightRepositoryImpl;

@RestController
public class FlightController {
	@Autowired
	FlightRepositoryImpl repository;

	
	@RequestMapping(value = "/flights/flightsLeastArrivalDelay", method = RequestMethod.GET)
	public List<Flight> findByLeastArrDelay() {
		return repository.findByLeastArrDelay();
	}
	
	@RequestMapping(value = "/flights/flightsMostArrivalDelay", method = RequestMethod.GET)
	public List<Flight> findByMostArrDelay() {
		return repository.findByMostArrDelay();
	}
	@RequestMapping(value = "/flights/flightsLeastDepartureDelay", method = RequestMethod.GET)
	public List<Flight> findByLeastDepDelay() {
		return repository.findByLeastDepDelay();
	}
	
	@RequestMapping(value = "/flights/flightsMostDepartureDelay", method = RequestMethod.GET)
	public List<Flight> findByMostDepDelay() {
		return repository.findByMostDepDelay();
	}

}
