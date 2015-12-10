package edu.umkc.ooc;

import org.apache.giraph.bsp.CentralizedServiceWorker;
import org.apache.giraph.ooc.MemoryEstimator;

public interface IMemEst{
	  
	  public void initialize(MemoryEstimator memEst, CentralizedServiceWorker serviceWorker);

	  /**
	   * @return amount of free memory in MB
	   */
	  public double freeMemoryMB(MemoryEstimator memEst);

	  /**
	   * @return amount of available memory in MB
	   */
	  public double maxMemoryMB(MemoryEstimator memEst);
}
