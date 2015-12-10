package comp.GiraphHadoopCounter;


import comp.GiraphHadoopCounter.GiraphHadoopCounterArch;

import org.apache.giraph.counters.GiraphHadoopCounter;

public interface IGiraphHadoopCounterImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (GiraphHadoopCounterArch arch);
	public GiraphHadoopCounterArch getArch();
	
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
  
    //To be imported: GiraphHadoopCounter
    public GiraphHadoopCounter[] createArrayInstance (int num_count)  ;        
}