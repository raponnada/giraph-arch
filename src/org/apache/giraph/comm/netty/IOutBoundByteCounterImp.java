package org.apache.giraph.comm.netty;


import org.apache.giraph.comm.netty.OutBoundCounterArch;

public interface IOutBoundByteCounterImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (OutBoundCounterArch arch);
	public OutBoundCounterArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public OutboundByteCounter obj ()  ;        
    public void resetAll ()  ;        
    public String getMetrics ()  ;        
    public String getMetricsWindow (int minMsecsWindow)  ;        
}