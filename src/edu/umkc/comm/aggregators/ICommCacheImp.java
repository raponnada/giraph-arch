package edu.umkc.comm.aggregators;


import edu.umkc.comm.aggregators.CommCacheArch;

import org.apache.giraph.comm.aggregators.GlobalCommValueOutputStream;

public interface ICommCacheImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (CommCacheArch arch);
	public CommCacheArch getArch();
	
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
  
    //To be imported: GlobalCommValueOutputStream
    public GlobalCommValueOutputStream createInsta (boolean writeClass)  ;        
}