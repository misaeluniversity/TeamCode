package com.drkiettran.mongodb.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.drkiettran.mongodb.model.Carrier;

public class CarrierRepositoryImpl implements CarrierRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarrierRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends Carrier> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Carrier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Carrier> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Carrier> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Carrier findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<Carrier> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Carrier entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Iterable<? extends Carrier> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Carrier> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Carrier> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends Carrier> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Carrier findByCode(String code) {
		LOGGER.info("Code: {}", code);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("Code").is(code));

		Carrier carrier = mongoTemplate.findOne(query, Carrier.class);
		return carrier;
	}

	

}
