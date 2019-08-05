package com.drkiettran.mongodb.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
import com.drkiettran.mongodb.model.Plane;

public class AirportRepositoryImpl implements AirportRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends Airport> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Airport> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Airport> findAll(Iterable<String> ids) {
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
	public void delete(Airport entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Airport> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Airport> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Airport> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Airport findByIata(String iata) {
		Query query = new Query();
		query.addCriteria(Criteria.where("iata").is(iata));
		return mongoTemplate.findOne(query, Airport.class);
	}

	@Override
	public ArrayList<Airport> findByMostArrDelay () {
		ArrayList<Airport> airportsList = (ArrayList<Airport>) mongoTemplate.findAll(Airport.class);
		Collections.sort(airportsList, new Comparator<Airport>() {

			@Override
			public int compare(Airport o1, Airport o2) {
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
		int sizeList = airportsList.size();
		for (int i=0;i<sizeList;i++) {
			if(airportsList.get(i).getArrDelay() == null) {
				airportsList.remove(i);
				sizeList --;
				i--;
			}
				
		}
			
		return airportsList;
	}

	
	@Override
	public ArrayList<Airport> findByLeastArrDelay() {
		ArrayList<Airport> airportsList = (ArrayList<Airport>) mongoTemplate.findAll(Airport.class);
		Collections.sort(airportsList, new Comparator<Airport>() {

			@Override
			public int compare(Airport o1, Airport o2) {
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
		int sizeList = airportsList.size();
		for (int i=0;i<sizeList;i++) {
			if(airportsList.get(i).getArrDelay() == null) {
				airportsList.remove(i);
				sizeList --;
				i--;
			}
				
		}
			
		return airportsList;
	}

}
