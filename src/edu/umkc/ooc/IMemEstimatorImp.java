package edu.umkc.ooc;


import edu.umkc.ooc.MemEstArch;

import org.apache.giraph.bsp.CentralizedServiceWorker;

import org.apache.giraph.ooc.MemoryEstimator;

public interface IMemEstimatorImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (MemEstArch arch);
	public MemEstArch getArch();
	
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
  
    //To be imported: CentralizedServiceWorker,MemoryEstimator
    public void initialize (MemoryEstimator memEst,CentralizedServiceWorker serviceWorker)  ;        
    public double freeMemoryMB (MemoryEstimator memEst)  ;        
    public double maxMemoryMB (MemoryEstimator memEst)  ;        
}