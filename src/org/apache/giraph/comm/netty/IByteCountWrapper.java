package org.apache.giraph.comm.netty;

public interface IByteCountWrapper {
	
	public InboundByteCounter iobj();
	/**
	   * Reset everything this object keeps track of
	   */
	 public void resetAll();

	  /**
	   * @return A string containing all the metrics
	   */
	  public String getMetrics();

	  /**
	   * Get the metrics if a given window of time has passed.  Return null
	   * otherwise.  If the window is met, reset the metrics.
	   *
	   * @param minMsecsWindow Msecs of the minimum window
	   * @return Metrics or else null if the window wasn't met
	   */
	  public String getMetricsWindow(int minMsecsWindow);
}
