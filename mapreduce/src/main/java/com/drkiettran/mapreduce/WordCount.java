package com.drkiettran.mapreduce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Let's see if we could wordcount to work. This is a classic program that is
 * used for concept of mapreduce programming.
 * 
 * https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html
 * 
 */
public class WordCount {

	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
		private static final Logger LOGGER = LoggerFactory.getLogger(TokenizerMapper.class);
		private final static IntWritable one = new IntWritable(1);
		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			StringTokenizer itr = new StringTokenizer(value.toString());
			Text word = new Text();
			Text lastWord = new Text("");
			Text twoWords = new Text();
			while (itr.hasMoreTokens()) {
				word.set(itr.nextToken());
				twoWords.set(lastWord.copyBytes());
				twoWords.append(" ".getBytes(), 0, 1);
				twoWords.append(word.copyBytes(), 0, word.getLength());
				context.write(twoWords, one);
				lastWord.set(word.copyBytes());
			}
		}
	}

	public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		public void reduce(Text key, Iterable<IntWritable> values, Context context)
				throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}
			result.set(sum);
			context.write(key, result);
		}
	}

	/**
	 * Reading result file store as part-r-0000
	 * 
	 * @param resultFile
	 * @throws IOException
	 */
	private static void printResult(String resultFile) throws IOException {
		String partFile = String.format("hdfs:%s/part-r-00000", resultFile);
		Path pt = new Path(partFile);// Location of file in HDFS
		FileSystem fs = FileSystem.get(new Configuration());
		BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(pt)));
		String line;
		line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
		fs.close();
	}

	/**
	 * Reading result file store as part-r-0000
	 * 
	 * @param resultFile
	 * @throws IOException
	 */
	private static void searchPhrase(String resultFile, String phrase) throws IOException {
		String partFile = String.format("hdfs:%s/part-r-00000", resultFile);
		Path pt = new Path(partFile);// Location of file in HDFS
		FileSystem fs = FileSystem.get(new Configuration());
		BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(pt)));
		String line;
		line = br.readLine();
		String lineRecord = "";
		boolean checkPhrase = false;
		while (line != null) {
			if (line.contains(phrase)) {
				checkPhrase = true;
				lineRecord = line;
			}
			line = br.readLine();
		}
		if (checkPhrase) {
			System.out.println("\n\nThe Phrase "+phrase+" exist");
			System.out.println(lineRecord+"\n\n");
		}
		
		br.close();
		fs.close();
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "word count");
		job.setJarByClass(WordCount.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		int result = job.waitForCompletion(true) ? 0 : 1;
		// printResult(args[1]);
		searchPhrase(args[1],args[2]);
		System.exit(result);
	}
}