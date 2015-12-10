package edu.umkc.counters;

import org.apache.hadoop.mapreduce.Mapper.Context;

import org.apache.giraph.counters.GiraphTimers;

public interface IGiraphTimers {

    public void init(Context context);
    public GiraphTimers getInstance(); 	
}
