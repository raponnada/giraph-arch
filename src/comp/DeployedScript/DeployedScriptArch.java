package comp.DeployedScript;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.scripting.deployedScript.IDeployedScript;

import org.apache.giraph.graph.Language;

import org.apache.giraph.scripting.DeployType;
import org.apache.giraph.scripting.DeployedScript;

public class DeployedScriptArch extends AbstractMyxSimpleBrick implements IDeployedScript
{
    public static final IMyxName msg_IDeployedScript = MyxUtils.createName("edu.umkc.scripting.deployedScript.IDeployedScript");


	private IDeployedScriptImp _imp;

    public DeployedScriptArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IDeployedScriptImp getImplementation(){
        try{
			return new DeployedScriptImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_IDeployedScript)){
			return this;
		}        
		return null;
	}
  
    //To be imported: DeployType,DeployedScript,Language
    public DeployedScript createInstance (String str,DeployType dtype,Language lang)   {
		return _imp.createInstance(str,dtype,lang);
    }    
}