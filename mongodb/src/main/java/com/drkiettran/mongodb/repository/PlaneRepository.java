package com.drkiettran.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.drkiettran.mongodb.model.Plane;

@Repository
//@RepositoryRestResource(collectionResourceRel = "planes", path = "planes")
public interface PlaneRepository extends MongoRepository<Plane, String> {

	@Query("{tailnum:'?0'}")
	Plane findByTailnum(@Param("tailnum") String tailnum);

}
