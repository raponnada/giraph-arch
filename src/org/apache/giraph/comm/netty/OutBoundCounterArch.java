package org.apache.giraph.comm.netty;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class OutBoundCounterArch extends AbstractMyxSimpleBrick implements OutByteCountWrapper
{
    public static final IMyxName msg_OutByteCountWrapper = MyxUtils.createName("org.apache.giraph.comm.netty.OutByteCountWrapper");


	private IOutBoundByteCounterImp _imp;

    public OutBoundCounterArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IOutBoundByteCounterImp getImplementation(){
        try{
			return new OutBoundCounterImpl();    
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
		if (arg0.equals(msg_OutByteCountWrapper)){
			return this;
		}        
		return null;
	}
  
    
    public OutboundByteCounter obj ()   {
		return _imp.obj();
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