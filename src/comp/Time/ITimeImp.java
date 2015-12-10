package comp.Time;


import comp.Time.TimeArch;

import org.apache.giraph.time.Time;

public interface ITimeImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (TimeArch arch);
	public TimeArch getArch();
	
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
  
    //To be imported: Time
    public Time getTime ()  ;        
}