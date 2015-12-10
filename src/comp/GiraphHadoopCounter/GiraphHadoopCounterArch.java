package comp.GiraphHadoopCounter;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.counters.hcounter.IGiraphHadoopCounter;

import org.apache.giraph.counters.GiraphHadoopCounter;

public class GiraphHadoopCounterArch extends AbstractMyxSimpleBrick implements IGiraphHadoopCounter
{
    public static final IMyxName msg_IGiraphHadoopCounter = MyxUtils.createName("edu.umkc.counters.hcounter.IGiraphHadoopCounter");


	private IGiraphHadoopCounterImp _imp;

    public GiraphHadoopCounterArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IGiraphHadoopCounterImp getImplementation(){
        try{
			return new GiraphHadoopCounterImp();    
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
		if (arg0.equals(msg_IGiraphHadoopCounter)){
			return this;
		}        
		return null;
	}
  
    //To be imported: GiraphHadoopCounter
    public GiraphHadoopCounter[] createArrayInstance (int num_count)   {
		return _imp.createArrayInstance(num_count);
    }    
}