package com.drkiettran.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Plane;
import com.drkiettran.mongodb.repository.PlaneRepositoryImpl;

@RestController
//@RequestMapping("/planes")
public class PlaneController {
	@Autowired
	PlaneRepositoryImpl repository;

	@RequestMapping(value = "/planes", method = RequestMethod.GET)
	public Plane findByTailnum(@Param("tailnum") String tailnum) {
		return repository.findByTailnum(tailnum);
	}
}
