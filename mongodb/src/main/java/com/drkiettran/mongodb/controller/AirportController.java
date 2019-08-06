package com.drkiettran.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.repository.AirportRepositoryImpl;

@RestController
public class AirportController {
	@Autowired
	AirportRepositoryImpl repository;

	@RequestMapping(value = "/airports", method = RequestMethod.GET)
	public Airport findByTailnum(@Param("iata") String iata) {
		return repository.findByIata(iata);
	}
	
	@RequestMapping(value = "/airports/airportsLeastArrivalDelay", method = RequestMethod.GET)
	public List<Airport> findByLeastArrDelay() {
		return repository.findByLeastArrDelay();
	}
	
	@RequestMapping(value = "/airports/airportsMostArrivalDelay", method = RequestMethod.GET)
	public List<Airport> findByMostArrDelay() {
		return repository.findByMostArrDelay();
	}
	
	@RequestMapping(value = "/airports/airportsMostDepartureDelay", method = RequestMethod.GET)
	public List<Airport> findByMostDepDelay() {
		return repository.findByMostDepDelay();
	}
	
	@RequestMapping(value = "/airports/airportsLeastDepartureDelay", method = RequestMethod.GET)
	public List<Airport> findByLeastDepDelay() {
		return repository.findByLeastDepDelay();
	}
}
