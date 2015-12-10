package org.apache.giraph.comm.netty;


import org.apache.giraph.comm.netty.InBoundCounterArch;

public interface IInBoundByteCounterImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (InBoundCounterArch arch);
	public InBoundCounterArch getArch();
	
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
  
    
    public InboundByteCounter iobj ()  ;        
    public void resetAll ()  ;        
    public String getMetrics ()  ;        
    public String getMetricsWindow (int minMsecsWindow)  ;        
}