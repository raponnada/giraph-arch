package comp.Counters;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.sad.Counters.IGiraphTimers;

import edu.umkc.sad.Counters.Source.GiraphHadoopCounter;
import edu.umkc.sad.Counters.Source.GiraphTimers;

import org.apache.hadoop.mapreduce.Mapper.Context;

public class CountersArch extends AbstractMyxSimpleBrick implements IGiraphTimers
{
    public static final IMyxName msg_IGiraphTimers = MyxUtils.createName("edu.umkc.sad.Counters.IGiraphTimers");


	private ICountersImp _imp;

    public CountersArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ICountersImp getImplementation(){
        try{
			return new CountersImp();    
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
		if (arg0.equals(msg_IGiraphTimers)){
			return this;
		}        
		return null;
	}
  
    //To be imported: Context,GiraphHadoopCounter,GiraphTimers
    public void init (Context context)   {
		_imp.init(context);
    }    
    public GiraphTimers getInstance ()   {
		return _imp.getInstance();
    }    
}