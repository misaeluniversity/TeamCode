package com.drkiettran.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Carrier;
import com.drkiettran.mongodb.repository.CarrierRepositoryImpl;

@RestController
public class CarrierController {
	@Autowired
	CarrierRepositoryImpl repository;

	@RequestMapping(value = "/carriers", method = RequestMethod.GET)
	public Carrier findByTailnum(@Param("Code") String code) {
		return repository.findByCode(code);
	}
}
