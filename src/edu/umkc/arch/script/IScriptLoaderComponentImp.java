package edu.umkc.arch.script;


import edu.umkc.arch.script.ScriptArch;

import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;
import org.apache.giraph.scripting.ScriptLoader;
import org.apache.giraph.graph.Language;
import org.apache.hadoop.conf.Configuration;

import java.io.IOException;
import java.util.List;

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
    public void setScriptsToLoad(Configuration conf,String scriptPath, DeployType deployType, Language language);
    public void setScriptsToLoad(Configuration conf,String script1, DeployType deployType1, Language language1,String script2, DeployType deployType2, Language language2); 
    public void setScriptsToLoad(Configuration conf,DeployedScript... scripts);
    public void addScriptToLoad(Configuration conf,String script, DeployType deployType, Language language);
    public void addScriptToLoad(Configuration conf,DeployedScript script);
    public List<DeployedScript> getScriptsToLoad(Configuration conf);
    public void loadScripts(Configuration conf) throws IOException;
    public void loadScript(Configuration conf,DeployedScript deployedScript) throws IOException;
    public  List<DeployedScript> getLoadedScripts();
    
    
    
    
}