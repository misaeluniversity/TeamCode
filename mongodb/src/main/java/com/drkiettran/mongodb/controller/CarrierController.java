package com.drkiettran.mongodb.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Average;
import com.drkiettran.mongodb.model.Carrier;
import com.drkiettran.mongodb.repository.CarrierRepositoryImpl;
import com.mongodb.BasicDBObject;

@RestController
public class CarrierController {
	@Autowired
	CarrierRepositoryImpl repository;

	@RequestMapping(value = "/carriers", method = RequestMethod.GET)
	public Carrier findByTailnum(@Param("Code") String code) {
		return repository.findByCode(code);
	}
	
	
	@RequestMapping(value = "/carriers/carriersAverageArrivalDelay", method = RequestMethod.GET)
	public BasicDBObject findByAverageArrDelay() {
		BasicDBObject result = new BasicDBObject();
		List<BasicDBObject> listResult = new ArrayList<>();
		List<Average> listCarriers = repository.findByAverageArrDelay();
		for (Iterator iterator = listCarriers.iterator(); iterator.hasNext();) {
			Average average = (Average) iterator.next();
			BasicDBObject element = new BasicDBObject();
			element.put("Code", average.getKey());
			element.put("average", average.getValue());
			listResult.add(element);
		}
		result.put("CarrierAverages", listResult);
		return result;
	}
	
	@RequestMapping(value = "/carriers/carriersAverageDepartureDelay", method = RequestMethod.GET)
	public BasicDBObject findByAverageDepDelay() {
		BasicDBObject result = new BasicDBObject();
		List<BasicDBObject> listResult = new ArrayList<>();
		List<Average> listCarriers = repository.findByAverageDepDelay();
		for (Iterator iterator = listCarriers.iterator(); iterator.hasNext();) {
			Average average = (Average) iterator.next();
			BasicDBObject element = new BasicDBObject();
			element.put("Code", average.getKey());
			element.put("average", average.getValue());
			listResult.add(element);
		}
		result.put("CarrierAverages", listResult);
		return result;	}
}
