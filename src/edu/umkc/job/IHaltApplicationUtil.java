package edu.umkc.job;

import org.apache.giraph.conf.GiraphConfiguration;
import org.apache.hadoop.mapreduce.Job;

public interface IHaltApplicationUtil {
	
	public void printHaltInfo(Job submittedJob, GiraphConfiguration conf);

}
