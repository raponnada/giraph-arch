package org.apache.giraph.comm.netty;


import org.apache.giraph.comm.netty.ByteCounterArch;

public interface IByteCounterImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ByteCounterArch arch);
	public ByteCounterArch getArch();
	
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
    public void iresetAll ()  ;        
    public String igetMetrics ()  ;        
    public String igetMetricsWindow (int minMsecsWindow)  ;        
    public OutboundByteCounter oobj ()  ;        
    public void oresetAll ()  ;        
    public String ogetMetrics ()  ;        
    public String ogetMetricsWindow (int minMsecsWindow)  ;        
}