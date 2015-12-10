package edu.umkc.scripting.deployedScript;
 
import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;
import org.apache.giraph.graph.Language;

public interface IDeployedScript {

	public DeployedScript createInstance(String str, DeployType dtype, Language lang);
	
}
