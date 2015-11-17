package edu.umkc.arch.script;


import org.apache.giraph.scripting.ScriptLoader;
import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;
import org.apache.giraph.conf.JsonStringConfOption;
import org.apache.giraph.graph.Language;
import org.apache.giraph.jython.JythonUtils;
import org.apache.hadoop.conf.Configuration;
import org.codehaus.jackson.type.TypeReference;
import org.apache.hadoop.fs.Path;
import com.google.common.base.Optional;

import com.google.common.collect.Lists;
import com.google.common.io.Closeables;

import java.io.BufferedInputStream;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import static org.apache.giraph.utils.DistributedCacheUtils.getLocalCacheFile;

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
	
	private static final List<DeployedScript> LOADED_SCRIPTS =Lists.newArrayList();

		  /** Logger */
    private static final Logger LOG = Logger.getLogger(ScriptLoader.class);
    
    public static final JsonStringConfOption SCRIPTS_TO_LOAD =
    	      new JsonStringConfOption("giraph.scripts.to.load",
    	          "Scripts to load on workers");

	/*
  	  Implementation primitives required by the architecture
	*/
  
    //To be imported: ScriptLoader
    public ScriptLoader getScriptLoaderObject ()   {
		//TODO Auto-generated method stub
		return null;
    }
    
    // Unimplemented methods //
    public void setScriptsToLoad(Configuration conf,String scriptPath, DeployType deployType, Language language) {
    	    DeployedScript deployedScript = new DeployedScript(scriptPath,
    	        deployType, language);
    	    setScriptsToLoad(conf, deployedScript);
    	  }

    	  /**
    	   * Deploy pair of scripts
    	   *
    	   * @param conf {@link Configuration}
    	   * @param script1 Path to script
    	   * @param deployType1 type of deployment
    	   * @param language1 programming language
    	   * @param script2 Path to script
    	   * @param deployType2 type of deployment
    	   * @param language2 programming language
    	   */
    	  public void setScriptsToLoad(Configuration conf,
    	      String script1, DeployType deployType1, Language language1,
    	      String script2, DeployType deployType2, Language language2) {
    	    DeployedScript deployedScript1 = new DeployedScript(script1,
    	        deployType1, language1);
    	    DeployedScript deployedScript2 = new DeployedScript(script2,
    	        deployType2, language2);
    	    setScriptsToLoad(conf, deployedScript1, deployedScript2);
    	  }

    	  /**
    	   * Deploy scripts
    	   *
    	   * @param conf Configuration
    	   * @param scripts the scripts to deploy
    	   */
    	  public void setScriptsToLoad(Configuration conf,
    	      DeployedScript... scripts) {
    	    List<DeployedScript> scriptsToLoad = Lists.newArrayList(scripts);
    	    SCRIPTS_TO_LOAD.set(conf, scriptsToLoad);
    	  }

    	  /**
    	   * Add a script to load on workers
    	   *
    	   * @param conf {@link Configuration}
    	   * @param script  Path to script
    	   * @param deployType type of deployment
    	   * @param language programming language
    	   */
    	  public void addScriptToLoad(Configuration conf,
    	      String script, DeployType deployType, Language language) {
    	    addScriptToLoad(conf, new DeployedScript(script, deployType, language));
    	  }

    	  /**
    	   * Add a script to load on workers
    	   *
    	   * @param conf {@link Configuration}
    	   * @param script the script to load
    	   */
    	  public void addScriptToLoad(Configuration conf,
    	      DeployedScript script) {
    	    List<DeployedScript> scriptsToLoad = getScriptsToLoad(conf);
    	    if (scriptsToLoad == null) {
    	      scriptsToLoad = Lists.<DeployedScript>newArrayList();
    	    }
    	    scriptsToLoad.add(script);
    	    SCRIPTS_TO_LOAD.set(conf, scriptsToLoad);
    	  }

    	  /**
    	   * Get the list of scripts to load on workers
    	   *
    	   * @param conf {@link Configuration}
    	   * @return list of {@link DeployedScript}s
    	   */
    	  public List<DeployedScript> getScriptsToLoad(Configuration conf) {
    	    TypeReference<List<DeployedScript>> jsonType =
    	        new TypeReference<List<DeployedScript>>() { };
    	    return SCRIPTS_TO_LOAD.get(conf, jsonType);
    	  }

    	  /**
    	   * Load all the scripts deployed in Configuration
    	   *
    	   * @param conf Configuration
    	   */
    	  public void loadScripts(Configuration conf) throws IOException {
    	    List<DeployedScript> deployedScripts = getScriptsToLoad(conf);
    	    if (deployedScripts == null) {
    	      return;
    	    }
    	    for (DeployedScript deployedScript : deployedScripts) {
    	      loadScript(conf, deployedScript);
    	    }
    	  }

    	  /**
    	   * Load a single deployed script
    	   *
    	   * @param conf Configuration
    	   * @param deployedScript the deployed script
    	   */
    	  public void loadScript(Configuration conf,
    	      DeployedScript deployedScript) throws IOException {
    	    InputStream stream = openScriptInputStream(conf, deployedScript);
    	    switch (deployedScript.getLanguage()) {
    	    case JYTHON:
    	      loadJythonScript(stream);
    	      break;
    	    default:
    	      LOG.fatal("Don't know how to load script " + deployedScript);
    	      throw new IllegalStateException("Don't know how to load script " +
    	          deployedScript);
    	    }

    	    LOADED_SCRIPTS.add(deployedScript);
    	    Closeables.close(stream, true);
    	  }
    
    	  private static void loadJythonScript(InputStream stream) {
    		    JythonUtils.getInterpreter().execfile(stream);
    		  }

    		  /**
    		   * Get list of scripts already loaded.
    		   *
    		   * @return list of loaded scripts
    		   */
    		  public  List<DeployedScript> getLoadedScripts() {
    		    return LOADED_SCRIPTS;
    		  }

    		  /**
    		   * Get an {@link java.io.InputStream} for the deployed script.
    		   *
    		   * @param conf Configuration
    		   * @param deployedScript the deployed script
    		   * @return {@link java.io.InputStream} for reading script
    		   */
    		  private static InputStream openScriptInputStream(Configuration conf,
    		      DeployedScript deployedScript) {
    		    DeployType deployType = deployedScript.getDeployType();
    		    String path = deployedScript.getPath();

    		    InputStream stream;
    		    switch (deployType) {
    		    case RESOURCE:
    		      if (LOG.isInfoEnabled()) {
    		        LOG.info("getScriptStream: Reading script from resource at " +
    		            deployedScript.getPath());
    		      }
    		      stream = ScriptLoader.class.getClassLoader().getResourceAsStream(path);
    		      if (stream == null) {
    		        throw new IllegalStateException("getScriptStream: Failed to " +
    		            "open script from resource at " + path);
    		      }
    		      break;
    		    case DISTRIBUTED_CACHE:
    		      if (LOG.isInfoEnabled()) {
    		        LOG.info("getScriptStream: Reading script from DistributedCache at " +
    		            path);
    		      }
    		      Optional<Path> localPath = getLocalCacheFile(conf, path);
    		      if (!localPath.isPresent()) {
    		        throw new IllegalStateException("getScriptStream: Failed to " +
    		            "find script in local DistributedCache matching " + path);
    		      }
    		      String pathStr = localPath.get().toString();
    		      try {
    		        stream = new BufferedInputStream(new FileInputStream(pathStr));
    		      } catch (IOException e) {
    		        throw new IllegalStateException("getScriptStream: Failed open " +
    		            "script from DistributedCache at " + localPath);
    		      }
    		      break;
    		    default:
    		      throw new IllegalArgumentException("getScriptStream: Unknown " +
    		          "script deployment type: " + deployType);
    		    }
    		    return stream;
    		  }
    
}