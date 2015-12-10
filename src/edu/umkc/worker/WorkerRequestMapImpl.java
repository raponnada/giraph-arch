package edu.umkc.worker;

import org.apache.giraph.comm.netty.handler.WorkerRequestReservedMap;

public class WorkerRequestMapImpl implements IWorkerRequestImp
{
	private WorkerRequestMapArch _arch;

    public WorkerRequestMapImpl (){
    }

	public void setArch(WorkerRequestMapArch arch){
		_arch = arch;
	}
	public WorkerRequestMapArch getArch(){
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
  
    
    public boolean reserveRequest (Integer workerId,long requestId)   {
		
		return false;
    }

	@Override
	public boolean reserveRequest(WorkerRequestReservedMap wrrm, Integer workerId, long requestId) {
		// TODO Auto-generated method stub
		return wrrm.reserveRequest(workerId, requestId);
	}
}