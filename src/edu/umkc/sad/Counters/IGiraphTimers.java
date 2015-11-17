package edu.umkc.sad.Counters;

import org.apache.hadoop.mapreduce.Mapper.Context;

import edu.umkc.sad.Counters.Source.GiraphHadoopCounter;
import edu.umkc.sad.Counters.Source.GiraphTimers;

public interface IGiraphTimers {

    public void init(Context context);
    public GiraphTimers getInstance(); 	
}
