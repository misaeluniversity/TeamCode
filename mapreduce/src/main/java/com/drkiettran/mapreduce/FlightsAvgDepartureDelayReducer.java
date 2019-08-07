package com.drkiettran.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class FlightsAvgDepartureDelayReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text token, Iterable<IntWritable> counts, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		int counter = 0;

		for (IntWritable count : counts) {
			sum += count.get();
			counter++;
		}
		sum = sum/counter;
		context.write(token, new IntWritable(sum));
	}
}