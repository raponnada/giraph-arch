package edu.umkc.ooc;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.bsp.CentralizedServiceWorker;

import org.apache.giraph.ooc.MemoryEstimator;

public class MemEstArch extends AbstractMyxSimpleBrick implements IMemEst
{
    public static final IMyxName msg_IMemEst = MyxUtils.createName("edu.umkc.ooc.IMemEst");


	private IMemEstimatorImp _imp;

    public MemEstArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IMemEstimatorImp getImplementation(){
        try{
			return new MemEstImpl();    
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
		if (arg0.equals(msg_IMemEst)){
			return this;
		}        
		return null;
	}
  
    //To be imported: CentralizedServiceWorker,MemoryEstimator
    public void initialize (MemoryEstimator memEst,CentralizedServiceWorker serviceWorker)   {
		_imp.initialize(memEst,serviceWorker);
    }    
    public double freeMemoryMB (MemoryEstimator memEst)   {
		return _imp.freeMemoryMB(memEst);
    }    
    public double maxMemoryMB (MemoryEstimator memEst)   {
		return _imp.maxMemoryMB(memEst);
    }    
}