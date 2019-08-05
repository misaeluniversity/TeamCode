package com.drkiettran.mongodb.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Flight;
import com.drkiettran.mongodb.model.Plane;

public class FlightRepositoryImpl implements FlightRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
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
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Flight> findByLeastArrDelay() {
		ArrayList<Flight> flightsList = (ArrayList<Flight>) mongoTemplate.findAll(Flight.class);
		Collections.sort(flightsList, new Comparator<Flight>() {

			@Override
			public int compare(Flight o1, Flight o2) {
				if(o1.getArrDelay() == null && o2.getArrDelay() == null )
					return 0;
				else if (o1.getArrDelay() == null)
					return -1;
				else if (o2.getArrDelay() == null)
					return 1;
				int timeDelay1 = 0;
				int timeDelay2 = 0;
				for (int i =0;i< o1.getArrDelay().size();i++) {
					timeDelay1 = timeDelay1 + o1.getArrDelay().get(i).getTime();
				}
				for (int i =0;i< o2.getArrDelay().size();i++) {
					timeDelay2 = timeDelay2 + o2.getArrDelay().get(i).getTime();
				}
				if (timeDelay1 == timeDelay2) {
					return 0;
				}
				return timeDelay1 < timeDelay2 ? -1 : 1;
			}
		});
		return flightsList;
	}

	@Override
	public ArrayList<Flight> findByMostArrDelay() {
		ArrayList<Flight> flightsList = (ArrayList<Flight>) mongoTemplate.findAll(Flight.class);
		Collections.sort(flightsList, new Comparator<Flight>() {

			@Override
			public int compare(Flight o1, Flight o2) {
				if(o1.getArrDelay() == null && o2.getArrDelay() == null )
					return 0;
				else if (o1.getArrDelay() == null)
					return 1;
				else if (o2.getArrDelay() == null)
					return -1;
				int timeDelay1 = 0;
				int timeDelay2 = 0;
				for (int i =0;i< o1.getArrDelay().size();i++) {
					timeDelay1 = timeDelay1 + o1.getArrDelay().get(i).getTime();
				}
				for (int i =0;i< o2.getArrDelay().size();i++) {
					timeDelay2 = timeDelay2 + o2.getArrDelay().get(i).getTime();
				}
				if (timeDelay1 == timeDelay2) {
					return 0;
				}
				return timeDelay1 < timeDelay2 ? 1 : -1;
			}
		});
		return flightsList;
	}



	@Override
	public <S extends Flight> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Flight> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Flight> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Page<Flight> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Flight findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Iterable<Flight> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(Flight entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Iterable<? extends Flight> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends Flight> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Flight> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public <S extends Flight> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
