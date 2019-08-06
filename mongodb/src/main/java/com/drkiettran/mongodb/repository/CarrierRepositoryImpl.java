package com.drkiettran.mongodb.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
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
import com.drkiettran.mongodb.model.Average;
import com.drkiettran.mongodb.model.Carrier;
import com.mongodb.BasicDBObject;

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




	@Override
	public List<Average> findByAverageDepDelay () {
		ArrayList<Carrier> carriersList = (ArrayList<Carrier>) mongoTemplate.findAll(Carrier.class);
		Collections.sort(carriersList, new Comparator<Carrier>() {

			@Override
			public int compare(Carrier o1, Carrier o2) {
				if(o1.getDepDelay() == null && o2.getDepDelay() == null )
					return 0;
				else if (o1.getDepDelay() == null)
					return 1;
				else if (o2.getDepDelay() == null)
					return -1;
				int timeDelay1 = 0;
				int timeDelay2 = 0;
				for (int i =0;i< o1.getDepDelay().size();i++) {
					timeDelay1 = timeDelay1 + o1.getDepDelay().get(i).getTime();
				}
				for (int i =0;i< o2.getDepDelay().size();i++) {
					timeDelay2 = timeDelay2 + o2.getDepDelay().get(i).getTime();
				}
				if (timeDelay1 == timeDelay2) {
					return 0;
				}
				return timeDelay1 < timeDelay2 ? 1 : -1;
			}
		});
		List<Average> listCarrier = new ArrayList<Average>();
		
		int sizeList = carriersList.size();
		for (int i=0;i<sizeList;i++) {
			if(carriersList.get(i).getDepDelay() == null) {
				carriersList.remove(i);
				sizeList --;
				i--;
			}else {
				float timeAverage = 0;
				for(int j =0;j<carriersList.get(i).getDepDelay().size();j++) {
					timeAverage = timeAverage + carriersList.get(i).getDepDelay().get(j).getTime();
				}
				timeAverage = timeAverage/carriersList.get(i).getDepDelay().size();
				listCarrier.add(new Average( carriersList.get(i).getCode(),timeAverage));
			}
				
		}
		return listCarrier;
	}


	@Override
	public List<Average> findByAverageArrDelay () {
		ArrayList<Carrier> carriersList = (ArrayList<Carrier>) mongoTemplate.findAll(Carrier.class);
		Collections.sort(carriersList, new Comparator<Carrier>() {

			@Override
			public int compare(Carrier o1, Carrier o2) {
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
		List<Average> listCarrier = new ArrayList<Average>();
		
		int sizeList = carriersList.size();
		for (int i=0;i<sizeList;i++) {
			if(carriersList.get(i).getArrDelay() == null) {
				carriersList.remove(i);
				sizeList --;
				i--;
			}else {
				float timeAverage = 0;
				for(int j =0;j<carriersList.get(i).getArrDelay().size();j++) {
					timeAverage = timeAverage + carriersList.get(i).getArrDelay().get(j).getTime();
				}
				timeAverage = timeAverage/carriersList.get(i).getArrDelay().size();
				
				listCarrier.add(new Average(carriersList.get(i).getCode(), timeAverage));
			}
				
		}
		
		
		return listCarrier;
	}
	
	
}
