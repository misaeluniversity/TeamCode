package com.drkiettran.mongodb.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Average;
import com.drkiettran.mongodb.model.Carrier;
import com.mongodb.BasicDBObject;

@Repository
//@RepositoryRestResource(collectionResourceRel = "carriers", path = "carriers")
public interface CarrierRepository extends MongoRepository<Carrier, String> {

	@Query("{Code:'?0'}")
	Carrier findByCode(@Param("Code") String code);
	
	@Query("{}")
	List<Average> findByAverageArrDelay();
	
	@Query("{}")
	List<Average> findByAverageDepDelay();

}
