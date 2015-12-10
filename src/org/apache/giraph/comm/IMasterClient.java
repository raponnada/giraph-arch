package org.apache.giraph.comm;

import org.apache.giraph.bsp.CentralizedServiceMaster;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;
import org.apache.hadoop.mapreduce.Mapper;

public interface IMasterClient {
	
	/**
	   * Make sure that all the connections to workers have been established.
	   */
	  public void openConnections();

	  public void flush();
	  
	  public MasterClient initialize(Mapper<?, ?, ?, ?>.Context context,
              ImmutableClassesGiraphConfiguration configuration,
              CentralizedServiceMaster<?, ?, ?> service,
              Thread.UncaughtExceptionHandler exceptionHandler);

	  /**
	   * Closes all connections.
	   */
	  public void closeConnections();
}
