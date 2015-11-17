package edu.umkc.sad.Time;


import edu.umkc.sad.Time.TimeArch;

import java.util.Date;

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
  
    //To be imported: Date
    public long getMilliseconds ()  ;        
    public long getMicroseconds ()  ;        
    public long getNanoseconds ()  ;        
    public int getSeconds ()  ;        
    public Date getCurrentDate ()  ;        
    public ITimeImp get1 ()  ;        
    public void sleep (long milliseconds) throws InterruptedException;        
}