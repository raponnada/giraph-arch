package edu.umkc.comm.aggregators;

import org.apache.giraph.comm.aggregators.GlobalCommValueOutputStream;

public interface ICommCache {
	
	public GlobalCommValueOutputStream createInsta(boolean writeClass);

}
