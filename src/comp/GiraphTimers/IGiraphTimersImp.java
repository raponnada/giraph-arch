package comp.GiraphTimers;


import comp.GiraphTimers.GiraphTimersArch;

import org.apache.giraph.counters.GiraphTimers;

import org.apache.hadoop.mapreduce.Mapper.Context;

public interface IGiraphTimersImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (GiraphTimersArch arch);
	public GiraphTimersArch getArch();
	
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
  
    //To be imported: Context,GiraphTimers
    public void init (Context context)  ;        
    public GiraphTimers getInstance ()  ;        
}