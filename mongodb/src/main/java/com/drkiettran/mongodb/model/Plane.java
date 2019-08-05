package com.drkiettran.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planes")
public class Plane {
	@Id
	private String id;

	private String tailnum;
	private String type;
	private String manufacturer;
	private String issue_date;
	private String model;
	private String status;
	private String aircraft_type;
	private String engine_type;
	private String year;

	public String getTailnum() {
		return tailnum;
	}

	public void setTailnum(String tailnum) {
		this.tailnum = tailnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAircraft_type() {
		return aircraft_type;
	}

	public void setAircraft_type(String aircraft_type) {
		this.aircraft_type = aircraft_type;
	}

	public String getEngine_type() {
		return engine_type;
	}

	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
