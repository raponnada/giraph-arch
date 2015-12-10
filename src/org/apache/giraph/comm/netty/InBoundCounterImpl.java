package org.apache.giraph.comm.netty;



public class InBoundCounterImpl implements IInBoundByteCounterImp
{
	private InBoundCounterArch _arch;
	
	public InboundByteCounter inbound;

    public InBoundCounterImpl (){
    }

	public void setArch(InBoundCounterArch arch){
		_arch = arch;
	}
	public InBoundCounterArch getArch(){
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
  
    
    public void resetAll ()   {
		//TODO Auto-generated method stub
		inbound.resetAll();
    }
    public String getMetrics ()   {
		//TODO Auto-generated method stub
		return inbound.getMetrics();
    }
    public String getMetricsWindow (int minMsecsWindow)   {
		//TODO Auto-generated method stub
		return inbound.getMetricsWindow(minMsecsWindow);
    }

	@Override
	public InboundByteCounter iobj() {
		// TODO Auto-generated method stub
		return inbound = new InboundByteCounter();
	}
}