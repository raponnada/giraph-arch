package comp.DeployedScript;


import comp.DeployedScript.DeployedScriptArch;

import org.apache.giraph.graph.Language;

import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;

public interface IDeployedScriptImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (DeployedScriptArch arch);
	public DeployedScriptArch getArch();
	
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
  
    //To be imported: DeployType,DeployedScript,Language
    public DeployedScript createInstance (String str,DeployType dtype,Language lang)  ;        
}