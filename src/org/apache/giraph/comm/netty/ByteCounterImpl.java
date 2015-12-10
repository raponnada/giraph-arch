package org.apache.giraph.comm.netty;



public class ByteCounterImpl implements IByteCounterImp
{
	private ByteCounterArch _arch;
	
	//public InboundByteCounter inbound;
	
	//public OutboundByteCounter outbound;

    public ByteCounterImpl (){
    }

	public void setArch(ByteCounterArch arch){
		_arch = arch;
	}
	public ByteCounterArch getArch(){
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
		//inbound = new InboundByteCounter();
		//outbound = new OutboundByteCounter();
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}

	
	@Override
	public void iresetAll() {
		// TODO Auto-generated method stub
		_arch.OUT_IByteCountWrapper.resetAll();
		
	}

	@Override
	public String igetMetrics() {
		// TODO Auto-generated method stub
		return _arch.OUT_IByteCountWrapper.getMetrics();
	}

	@Override
	public String igetMetricsWindow(int minMsecsWindow) {
		// TODO Auto-generated method stub
		return _arch.OUT_IByteCountWrapper.getMetricsWindow(minMsecsWindow);
	}

	@Override
	public void oresetAll() {
		// TODO Auto-generated method stub
		_arch.OUT_OutByteCountWrapper.resetAll();
	}

	@Override
	public String ogetMetrics() {
		// TODO Auto-generated method stub
		return _arch.OUT_OutByteCountWrapper.getMetrics();
	}

	@Override
	public String ogetMetricsWindow(int minMsecsWindow) {
		// TODO Auto-generated method stub
		return _arch.OUT_OutByteCountWrapper.getMetricsWindow(minMsecsWindow);
	}

	@Override
	public InboundByteCounter iobj() {
		// TODO Auto-generated method stub
		System.out.println("IbyteCountWrap"+_arch.OUT_IByteCountWrapper);
		_arch.begin();
		return _arch.OUT_IByteCountWrapper.iobj();
	}

	@Override
	public OutboundByteCounter oobj() {
		// TODO Auto-generated method stub
		return _arch.OUT_OutByteCountWrapper.obj();
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
  

}