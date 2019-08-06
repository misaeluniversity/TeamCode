package com.drkiettran.mongodb.model;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "")
public class Average{
	public Average(String s, float f) {
this.key = s;
this.value = f;
}
String key;
float value;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public float getValue() {
	return value;
}
public void setValue(float value) {
	this.value = value;
}
}




