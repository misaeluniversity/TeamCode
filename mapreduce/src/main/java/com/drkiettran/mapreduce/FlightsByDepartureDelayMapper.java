package com.drkiettran.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import au.com.bytecode.opencsv.CSVParser;

/*
 * Extracted from Hadoop for Dummies (2014)
 */
public class FlightsByDepartureDelayMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (key.get() > 0) {
			
			String[] lines = new CSVParser().parseLine(value.toString());
			if(!"NA".equals(lines[15]))
				context.write(new Text(lines[9]), new IntWritable(Integer.parseInt(lines[15]))); // the 8th index is that for the name of airline
																	// carrier
		}
	}
}