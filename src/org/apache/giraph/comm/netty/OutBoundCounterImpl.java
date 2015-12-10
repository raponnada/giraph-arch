package org.apache.giraph.comm.netty;



public class OutBoundCounterImpl implements IOutBoundByteCounterImp
{
	private OutBoundCounterArch _arch;
	
	public OutboundByteCounter outbound;
    public OutBoundCounterImpl (){
    }

	public void setArch(OutBoundCounterArch arch){
		_arch = arch;
	}
	public OutBoundCounterArch getArch(){
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
		outbound.resetAll();
    }
    public String getMetrics ()   {
		//TODO Auto-generated method stub
		return outbound.getMetrics();
    }
    public String getMetricsWindow (int minMsecsWindow)   {
		//TODO Auto-generated method stub
		return outbound.getMetricsWindow(minMsecsWindow);
    }

	@Override
	public OutboundByteCounter obj() {
		// TODO Auto-generated method stub
		return outbound = new OutboundByteCounter();
	}
}