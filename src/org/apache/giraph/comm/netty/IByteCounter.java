package org.apache.giraph.comm.netty;

public interface IByteCounter {
	
	public InboundByteCounter iobj();
	public void iresetAll();
    public String igetMetrics();
    public String igetMetricsWindow(int minMsecsWindow);
    
    public OutboundByteCounter oobj();
    public void oresetAll();
    public String ogetMetrics();
    public String ogetMetricsWindow(int minMsecsWindow);
}
