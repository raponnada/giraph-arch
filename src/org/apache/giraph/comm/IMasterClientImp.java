package org.apache.giraph.comm;


import org.apache.giraph.bsp.CentralizedServiceMaster;

import org.apache.giraph.comm.MasterClientArch;

import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;

import org.apache.hadoop.mapreduce.Mapper;

public interface IMasterClientImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (MasterClientArch arch);
	public MasterClientArch getArch();
	
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
  
    //To be imported: CentralizedServiceMaster,ImmutableClassesGiraphConfiguration,Mapper
    public void openConnections ()  ;        
    public void flush ()  ;        
    public MasterClient initialize (Mapper<?, ?, ?, ?>.Context context,ImmutableClassesGiraphConfiguration configuration,CentralizedServiceMaster<?, ?, ?> service,Thread.UncaughtExceptionHandler exceptionHandler)  ;        
    public void closeConnections ()  ;        
}