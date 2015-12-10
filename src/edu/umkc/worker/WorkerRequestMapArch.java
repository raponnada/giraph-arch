package edu.umkc.worker;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.comm.netty.handler.WorkerRequestReservedMap;

public class WorkerRequestMapArch extends AbstractMyxSimpleBrick implements IWorkerRequestMap
{
    public static final IMyxName msg_IWorkerRequestMap = MyxUtils.createName("edu.umkc.worker.IWorkerRequestMap");


	private IWorkerRequestImp _imp;

    public WorkerRequestMapArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IWorkerRequestImp getImplementation(){
        try{
			return new WorkerRequestMapImpl();    
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
		if (arg0.equals(msg_IWorkerRequestMap)){
			return this;
		}        
		return null;
	}
  
    //To be imported: WorkerRequestReservedMap
    public boolean reserveRequest (WorkerRequestReservedMap wrrm,Integer workerId,long requestId)   {
		return _imp.reserveRequest(wrrm,workerId,requestId);
    }    
}