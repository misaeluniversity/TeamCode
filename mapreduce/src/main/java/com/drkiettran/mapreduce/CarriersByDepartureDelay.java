package com.drkiettran.mapreduce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * 
 * Extracted from Hadoop for Dummies (2014)
 *
 */
public class CarriersByDepartureDelay {
	public static void main(String[] args) throws Exception {
		Job job = Job.getInstance();
		job.setJarByClass(CarriersByDepartureDelay.class);
		job.setJobName("CarriersByDepartureDelay");

		TextInputFormat.addInputPath(job, new Path(args[0]));
		job.setInputFormatClass(TextInputFormat.class);

		job.setMapperClass(CarriersByDepartureDelayMapper.class);
		job.setReducerClass(CarriersByDepartureDelayReducer.class);

		TextOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.waitForCompletion(true);
		resultToMongo(args[1], Integer.parseInt(args[2]));
		}
		/**
		 * Reading result file store as part-r-0000
		 * 
		 * @param resultFile
		 * @throws IOException
		 */
		private static void resultToMongo(String resultFile, int year ) throws IOException {
			String partFile = String.format("hdfs:%s/part-r-00000", resultFile);
			Path pt = new Path(partFile);// Location of file in HDFS
			FileSystem fs = FileSystem.get(new Configuration());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(pt)));
			String line;
			line = br.readLine();
			MongoClient mongoClient = new MongoClient("localhost",27017);
			DB database = mongoClient.getDB("airline");
			
			if(!(database.getCollection("carriers").count()>0))
				database.createCollection("carriers", new BasicDBObject());
			
			DBCollection collection = database.getCollection("carriers");
			
			while (line != null) {
				BasicDBObject searchQ = new BasicDBObject();
				String code = line.split("	")[0];
				int time = Integer.parseInt(line.split("	")[1]);
				searchQ.put("Code",code);		
				DBCursor cursor = collection.find(searchQ);

				if(!(cursor.count()>0))
					collection.insert(searchQ);
				
				cursor = collection.find(searchQ);
				
				boolean exist = false;
				while (cursor.hasNext()) {
					if(cursor.next().containsField("depDelay"))
						exist = true;				
				}
				if(exist) {
					BasicDBObject data = new BasicDBObject();
					data.put("time",time);
					data.put("year",year);
					collection.update(searchQ, new BasicDBObject("$push",new BasicDBObject("depDelay",data)));
				}else {
					java.util.List<BasicDBObject> datadelay = new ArrayList<>();
					BasicDBObject data = new BasicDBObject();
					data.put("time", time);
					data.put("year",year);
					datadelay.add(data);
					collection.update(searchQ, new BasicDBObject("$set",new BasicDBObject("depDelay",datadelay)));
				}
				//System.out.println(line);
				line = br.readLine();
			}
			br.close();
			fs.close();
		}
}
