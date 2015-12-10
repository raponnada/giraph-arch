package org.apache.giraph.comm.netty;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class InBoundCounterArch extends AbstractMyxSimpleBrick implements IByteCountWrapper
{
    public static final IMyxName msg_IByteCountWrapper = MyxUtils.createName("org.apache.giraph.comm.netty.IByteCountWrapper");


	private IInBoundByteCounterImp _imp;

    public InBoundCounterArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IInBoundByteCounterImp getImplementation(){
        try{
			return new InBoundCounterImpl();    
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
		if (arg0.equals(msg_IByteCountWrapper)){
			return this;
		}        
		return null;
	}
  
    
    public InboundByteCounter iobj ()   {
		return _imp.iobj();
    }    
    public void resetAll ()   {
		_imp.resetAll();
    }    
    public String getMetrics ()   {
		return _imp.getMetrics();
    }    
    public String getMetricsWindow (int minMsecsWindow)   {
		return _imp.getMetricsWindow(minMsecsWindow);
    }    
}