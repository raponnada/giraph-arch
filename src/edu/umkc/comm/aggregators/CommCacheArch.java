package edu.umkc.comm.aggregators;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.comm.aggregators.GlobalCommValueOutputStream;

public class CommCacheArch extends AbstractMyxSimpleBrick implements ICommCache
{
    public static final IMyxName msg_ICommCache = MyxUtils.createName("edu.umkc.comm.aggregators.ICommCache");


	private ICommCacheImp _imp;

    public CommCacheArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ICommCacheImp getImplementation(){
        try{
			return new CommCacheImpl();    
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
		if (arg0.equals(msg_ICommCache)){
			return this;
		}        
		return null;
	}
  
    //To be imported: GlobalCommValueOutputStream
    public GlobalCommValueOutputStream createInsta (boolean writeClass)   {
		return _imp.createInsta(writeClass);
    }    
}