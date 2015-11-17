package edu.umkc.arch.script;


import org.apache.giraph.scripting.ScriptLoader;

public class ScriptImpl implements IScriptLoaderComponentImp
{
	private ScriptArch _arch;

    public ScriptImpl (){
    }

	public void setArch(ScriptArch arch){
		_arch = arch;
	}
	public ScriptArch getArch(){
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
  
    //To be imported: ScriptLoader
    public ScriptLoader getScriptLoaderObject ()   {
		//TODO Auto-generated method stub
		return new ScriptLoader();
    }
}