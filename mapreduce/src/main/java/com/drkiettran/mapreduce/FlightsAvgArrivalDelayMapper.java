package com.drkiettran.mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import au.com.bytecode.opencsv.CSVParser;

public class FlightsAvgArrivalDelayMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] lines = new CSVParser().parseLine(value.toString());
			if(!"NA".equals(lines[14]))
				context.write(new Text(lines[9]), new IntWritable(Integer.parseInt(lines[14])));
																	
		}
	}
}
