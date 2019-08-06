package com.drkiettran.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "carriers")
public class Carrier {
	@Id
	private String id;
	@Field("Code")
	private String code;
	private String description;
	private List<Delay>arrDelay ;
	private List<Delay>depDelay ;

	public List<Delay> getArrDelay() {
		return arrDelay;
	}

	public void setArrDelay(List<Delay> arrDelay) {
		this.arrDelay = arrDelay;
	}

	public List<Delay> getDepDelay() {
		return depDelay;
	}

	public void setDepDelay(List<Delay> depDelay) {
		this.depDelay = depDelay;
	}

	@Field("long")
	private String longi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

}
