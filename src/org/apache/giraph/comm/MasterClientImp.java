package org.apache.giraph.comm;

import java.lang.Thread.UncaughtExceptionHandler;

import org.apache.giraph.bsp.CentralizedServiceMaster;
import org.apache.giraph.comm.netty.NettyMasterClient;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;
import org.apache.hadoop.mapreduce.Mapper;

public class MasterClientImp implements IMasterClientImp
{
	private MasterClientArch _arch;
	
	public MasterClient masterClient;

    public MasterClientImp (){
    }

	public void setArch(MasterClientArch arch){
		_arch = arch;
	}
	public MasterClientArch getArch(){
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
  
    
    public void openConnections ()   {
    	masterClient.openConnections();
		
    }
    public void flush ()   {
    	masterClient.flush();
		
    }
    
    public void closeConnections ()   {
		masterClient.closeConnections();
    }

	@Override
	public MasterClient initialize(Mapper<?, ?, ?, ?>.Context context,
			ImmutableClassesGiraphConfiguration configuration, CentralizedServiceMaster<?, ?, ?> service,
			UncaughtExceptionHandler exceptionHandler) {
		masterClient = new NettyMasterClient(context, configuration, service,
                exceptionHandler);

		return masterClient;
	}
}