package comp.DeployedScript;


import org.apache.giraph.graph.Language;

import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;

public class DeployedScriptImp implements IDeployedScriptImp
{
	private DeployedScriptArch _arch;

    public DeployedScriptImp (){
    }

	public void setArch(DeployedScriptArch arch){
		_arch = arch;
	}
	public DeployedScriptArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    //TODO Auto-generated method stub
	}
	public void begin(){
		//TODO Auto-generated method stub
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    //To be imported: DeployType,DeployedScript,Language
    public DeployedScript createInstance (String str,DeployType dtype,Language lang)   {
		//TODO Auto-generated method stub
		return new DeployedScript(str, dtype, lang) ;
    }
}