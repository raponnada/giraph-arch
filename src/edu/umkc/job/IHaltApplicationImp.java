package edu.umkc.job;


import edu.umkc.job.HaltAppArch;

import org.apache.giraph.conf.GiraphConfiguration;

import org.apache.hadoop.mapreduce.Job;

public interface IHaltApplicationImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (HaltAppArch arch);
	public HaltAppArch getArch();
	
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
  
    //To be imported: GiraphConfiguration,Job
    public void printHaltInfo (Job submittedJob,GiraphConfiguration conf)  ;        
}