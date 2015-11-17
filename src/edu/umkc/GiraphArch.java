package edu.umkc;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.sad.Counters.IGiraphTimers;

import edu.umkc.sad.Time.ITime;

public class GiraphArch extends AbstractMyxSimpleBrick
{
    public static final IMyxName msg_IGiraphTimers = MyxUtils.createName("edu.umkc.sad.Counters.IGiraphTimers");
    public static final IMyxName msg_ITime = MyxUtils.createName("edu.umkc.sad.Time.ITime");

    public IGiraphTimers OUT_IGiraphTimers;
    public ITime OUT_ITime;

	private IGiraphImp _imp;

    public GiraphArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IGiraphImp getImplementation(){
        try{
			return new GiraphImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_IGiraphTimers = (IGiraphTimers) MyxUtils.getFirstRequiredServiceObject(this,msg_IGiraphTimers);
        if (OUT_IGiraphTimers == null){
 			System.err.println("Error: Interface edu.umkc.sad.Counters.IGiraphTimers returned null");
			return;       
        }
        OUT_ITime = (ITime) MyxUtils.getFirstRequiredServiceObject(this,msg_ITime);
        if (OUT_ITime == null){
 			System.err.println("Error: Interface edu.umkc.sad.Time.ITime returned null");
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
		return null;
	}
}