package com.drkiettran.mongodb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

	
	@Query("{}")
	ArrayList<Flight> findByArrDelay();

}
