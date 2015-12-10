package edu.umkc.worker;


import edu.umkc.worker.WorkerRequestMapArch;

import org.apache.giraph.comm.netty.handler.WorkerRequestReservedMap;

public interface IWorkerRequestImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (WorkerRequestMapArch arch);
	public WorkerRequestMapArch getArch();
	
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
  
    //To be imported: WorkerRequestReservedMap
    public boolean reserveRequest (WorkerRequestReservedMap wrrm,Integer workerId,long requestId)  ;        
}