package com.drkiettran.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Flight;
import com.drkiettran.mongodb.repository.AirportRepositoryImpl;
import com.drkiettran.mongodb.repository.FlightRepositoryImpl;
import com.mongodb.BasicDBObject;

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

	@RequestMapping(value = "/flights/findAverageByArrDelayBefore2001", method = RequestMethod.GET)
	public BasicDBObject findAverageByArrDelayBefore2001() {
		return new BasicDBObject("average",repository.findAverageByArrDelayBefore2001());
	}
	
	@RequestMapping(value = "/flights/findByAverageDepDelayBefore2001", method = RequestMethod.GET)
	public BasicDBObject findByAverageDepDelayBefore2001() {
		return new BasicDBObject("average",repository.findByAverageDepDelayBefore2001());
	}

	@RequestMapping(value = "/flights/findAverageByArrDelayAfter2001", method = RequestMethod.GET)
	public BasicDBObject findAverageByArrDelayAfter2001() {
		return new BasicDBObject("average",repository.findAverageByArrDelayAfter2001());
	}
	
	@RequestMapping(value = "/flights/findByAverageDepDelayAfer2001", method = RequestMethod.GET)
	public BasicDBObject findByAverageDepDelayAfer2001() {
		return new BasicDBObject("average",repository.findByAverageDepDelayAfer2001());
	}
	


}
