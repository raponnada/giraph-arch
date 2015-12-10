package org.apache.giraph.comm.netty;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class ByteCounterArch extends AbstractMyxSimpleBrick implements IByteCounter
{
    public static final IMyxName msg_IByteCounter = MyxUtils.createName("org.apache.giraph.comm.netty.IByteCounter");
    public static final IMyxName msg_OutByteCountWrapper = MyxUtils.createName("org.apache.giraph.comm.netty.OutByteCountWrapper");
    public static final IMyxName msg_IByteCountWrapper = MyxUtils.createName("org.apache.giraph.comm.netty.IByteCountWrapper");

    public OutByteCountWrapper OUT_OutByteCountWrapper;
    public IByteCountWrapper OUT_IByteCountWrapper;

	private IByteCounterImp _imp;

    public ByteCounterArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IByteCounterImp getImplementation(){
        try{
			return new ByteCounterImpl();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_OutByteCountWrapper = (OutByteCountWrapper) MyxUtils.getFirstRequiredServiceObject(this,msg_OutByteCountWrapper);
        if (OUT_OutByteCountWrapper == null){
 			System.err.println("Error: Interface org.apache.giraph.comm.netty.OutByteCountWrapper returned null");
			return;       
        }
        OUT_IByteCountWrapper = (IByteCountWrapper) MyxUtils.getFirstRequiredServiceObject(this,msg_IByteCountWrapper);
        if (OUT_IByteCountWrapper == null){
 			System.err.println("Error: Interface org.apache.giraph.comm.netty.IByteCountWrapper returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_IByteCounter)){
			return this;
		}        
		return null;
	}
  
    
    public InboundByteCounter iobj ()   {
		return _imp.iobj();
    }    
    public void iresetAll ()   {
		_imp.iresetAll();
    }    
    public String igetMetrics ()   {
		return _imp.igetMetrics();
    }    
    public String igetMetricsWindow (int minMsecsWindow)   {
		return _imp.igetMetricsWindow(minMsecsWindow);
    }    
    public OutboundByteCounter oobj ()   {
		return _imp.oobj();
    }    
    public void oresetAll ()   {
		_imp.oresetAll();
    }    
    public String ogetMetrics ()   {
		return _imp.ogetMetrics();
    }    
    public String ogetMetricsWindow (int minMsecsWindow)   {
		return _imp.ogetMetricsWindow(minMsecsWindow);
    }    
}