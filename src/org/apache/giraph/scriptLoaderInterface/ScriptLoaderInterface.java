package org.apache.giraph.scriptLoaderInterface;

import java.io.IOException;
import java.util.List;

import org.apache.giraph.graph.Language;
import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;
import org.apache.giraph.scripting.ScriptLoader;
import org.apache.hadoop.conf.Configuration;


public interface ScriptLoaderInterface {
	
	public ScriptLoader getScriptLoaderObject();
    public void setScriptsToLoad(Configuration conf,String scriptPath, DeployType deployType, Language language);
    public void setScriptsToLoad(Configuration conf,String script1, DeployType deployType1, Language language1,String script2, DeployType deployType2, Language language2); 
    public void setScriptsToLoad(Configuration conf,DeployedScript... scripts);
    public void addScriptToLoad(Configuration conf,String script, DeployType deployType, Language language);
    public void addScriptToLoad(Configuration conf,DeployedScript script);
    public List<DeployedScript> getScriptsToLoad(Configuration conf);
    public void loadScripts(Configuration conf) throws IOException;
    public void loadScript(Configuration conf,DeployedScript deployedScript) throws IOException;
    public List<DeployedScript> getLoadedScripts();

}
