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
	private List<ArrDelay>arrDelay ;
	
	public String getTailNum() {
		return TailNum;
	}

	public void setTailNum(String tailNum) {
		TailNum = tailNum;
	}

	public List<ArrDelay> getArrDelay() {
		return arrDelay;
	}

	public void setArrDelay(List<ArrDelay> arrDelay) {
		this.arrDelay = arrDelay;
	}
	
	public class ArrDelay{
		
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		int year;
		int time;
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


