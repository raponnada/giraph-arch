package edu.umkc.arch.script;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.scriptLoaderInterface.ScriptLoaderInterface;

import org.apache.giraph.scripting.ScriptLoader;

public class ScriptArch extends AbstractMyxSimpleBrick implements ScriptLoaderInterface
{
    public static final IMyxName msg_ScriptLoaderInterface = MyxUtils.createName("org.apache.giraph.scriptLoaderInterface.ScriptLoaderInterface");


	private IScriptLoaderComponentImp _imp;

    public ScriptArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IScriptLoaderComponentImp getImplementation(){
        try{
			return new ScriptImpl();    
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
		if (arg0.equals(msg_ScriptLoaderInterface)){
			return this;
		}        
		return null;
	}
  
    //To be imported: ScriptLoader
    public ScriptLoader getScriptLoaderObject ()   {
		return _imp.getScriptLoaderObject();
    }    
}