package com.drkiettran.mongodb.model;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "airports")
//@TypeAlias("arrDelay")
public class Airport  {
	@Id
	private String id;

	private String iata;
	private String airport;
	private String city;
	private String state;
	private String country;
	private String lat;
	@Field("arrDelay")
	private List<Delay>arrDelay ;
	


	public List<Delay> getArrDelay() {
		return arrDelay;
	}

	public void setArrDelay(List<Delay> arrDelay) {
		this.arrDelay = arrDelay;
	}


	@Field("long")
	private String longi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}



}


