package com.drkiettran.mongodb.model;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "flights")
public class Flight  {
	
	@Id
	private String id;

	private String TailNum;
	private List<Delay>arrDelay ;
	private List<Delay>depDelay ;

	
	public List<Delay> getDepDelay() {
		return depDelay;
	}

	public void setDepDelay(List<Delay> depDelay) {
		this.depDelay = depDelay;
	}

	public String getTailNum() {
		return TailNum;
	}

	public void setTailNum(String tailNum) {
		TailNum = tailNum;
	}

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

	
	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}



}


