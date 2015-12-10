package comp.MasterServer;


import java.net.InetSocketAddress;

import org.apache.giraph.bsp.CentralizedServiceMaster;
import org.apache.giraph.comm.MasterServer;
import org.apache.giraph.comm.netty.NettyMasterServer;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;

import org.apache.hadoop.util.Progressable;

public class MasterServerImp implements IMasterServerImp
{
	private MasterServerArch _arch;
	
	public MasterServer masterServer;

    public MasterServerImp (){
    }

	public void setArch(MasterServerArch arch){
		_arch = arch;
	}
	public MasterServerArch getArch(){
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
  
    //To be imported: InetSocketAddress,CentralizedServiceMaster,ImmutableClassesGiraphConfiguration,Progressable
	public MasterServer instantiate (ImmutableClassesGiraphConfiguration conf,CentralizedServiceMaster<?, ?, ?> service,Progressable progressable,Thread.UncaughtExceptionHandler exceptionHandler)   {
		//TODO Auto-generated method stub
    	masterServer = new NettyMasterServer(conf, service, progressable, exceptionHandler);
		return masterServer;
    }
    public InetSocketAddress getMyAddress ()   {
		//TODO Auto-generated method stub
		return masterServer.getMyAddress();
    }
    public void close ()   {
		//TODO Auto-generated method stub
    	masterServer.close();
    }
}