package com.drkiettran.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

import au.com.bytecode.opencsv.CSVParser;

public class AirportsDepartureDelayMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] lines = new CSVParser().parseLine(value.toString());
			
			if(!"NA".equals(lines[15]))
				context.write(new Text(lines[16]), new IntWritable(Integer.parseInt(lines[15])));

		}
	}
}
