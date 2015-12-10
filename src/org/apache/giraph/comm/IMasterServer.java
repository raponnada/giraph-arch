package org.apache.giraph.comm;

import java.net.InetSocketAddress;

import org.apache.giraph.bsp.CentralizedServiceMaster;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;
import org.apache.hadoop.util.Progressable;

public interface IMasterServer {
	  
	
	  public MasterServer instantiate(ImmutableClassesGiraphConfiguration conf,
			      CentralizedServiceMaster<?, ?, ?> service,
			      Progressable progressable,
			      Thread.UncaughtExceptionHandler exceptionHandler);
		/**
	   * Get server address
	   *
	   * @return Address used by this server
	   */
	  public InetSocketAddress getMyAddress();

	  /**
	   * Shuts down.
	   */
	  public void close();
}
