package edu.umkc.counters.hcounter;

import org.apache.giraph.counters.GiraphHadoopCounter;

public interface IGiraphHadoopCounter {
	public GiraphHadoopCounter[] createArrayInstance(int num_count);

}
