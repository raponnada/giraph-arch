package comp.MasterServer;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import java.net.InetSocketAddress;

import org.apache.giraph.bsp.CentralizedServiceMaster;

import org.apache.giraph.comm.IMasterServer;
import org.apache.giraph.comm.MasterServer;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;

import org.apache.hadoop.util.Progressable;

public class MasterServerArch extends AbstractMyxSimpleBrick implements IMasterServer
{
    public static final IMyxName msg_IMasterServer = MyxUtils.createName("org.apache.giraph.comm.IMasterServer");


	private IMasterServerImp _imp;

    public MasterServerArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IMasterServerImp getImplementation(){
        try{
			return new MasterServerImp();    
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
		if (arg0.equals(msg_IMasterServer)){
			return this;
		}        
		return null;
	}
  
    //To be imported: InetSocketAddress,CentralizedServiceMaster,ImmutableClassesGiraphConfiguration,Progressable
    public MasterServer instantiate (ImmutableClassesGiraphConfiguration conf,CentralizedServiceMaster<?, ?, ?> service,Progressable progressable,Thread.UncaughtExceptionHandler exceptionHandler)   {
		return _imp.instantiate(conf,service,progressable,exceptionHandler);
    }    
    public InetSocketAddress getMyAddress ()   {
		return _imp.getMyAddress();
    }    
    public void close ()   {
		_imp.close();
    }    
}