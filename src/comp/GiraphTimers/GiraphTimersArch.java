package comp.GiraphTimers;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.counters.IGiraphTimers;

import edu.umkc.counters.hcounter.IGiraphHadoopCounter;

import org.apache.giraph.counters.GiraphTimers;

import org.apache.hadoop.mapreduce.Mapper.Context;

public class GiraphTimersArch extends AbstractMyxSimpleBrick implements IGiraphTimers
{
    public static final IMyxName msg_IGiraphTimers = MyxUtils.createName("edu.umkc.counters.IGiraphTimers");
    public static final IMyxName msg_IGiraphHadoopCounter = MyxUtils.createName("edu.umkc.counters.hcounter.IGiraphHadoopCounter");

    public IGiraphHadoopCounter OUT_IGiraphHadoopCounter;

	private IGiraphTimersImp _imp;

    public GiraphTimersArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IGiraphTimersImp getImplementation(){
        try{
			return new GiraphTimersImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_IGiraphHadoopCounter = (IGiraphHadoopCounter) MyxUtils.getFirstRequiredServiceObject(this,msg_IGiraphHadoopCounter);
        if (OUT_IGiraphHadoopCounter == null){
 			System.err.println("Error: Interface edu.umkc.counters.hcounter.IGiraphHadoopCounter returned null");
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
		if (arg0.equals(msg_IGiraphTimers)){
			return this;
		}        
		return null;
	}
  
    //To be imported: Context,GiraphTimers
    public void init (Context context)   {
		_imp.init(context);
    }    
    public GiraphTimers getInstance ()   {
		return _imp.getInstance();
    }    
}