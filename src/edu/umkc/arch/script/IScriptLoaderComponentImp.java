package edu.umkc.arch.script;


import edu.umkc.arch.script.ScriptArch;

import org.apache.giraph.scripting.ScriptLoader;

public interface IScriptLoaderComponentImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ScriptArch arch);
	public ScriptArch getArch();
	
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
  
    //To be imported: ScriptLoader
    public ScriptLoader getScriptLoaderObject ()  ;        
    
}