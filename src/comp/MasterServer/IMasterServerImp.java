package comp.MasterServer;


import comp.MasterServer.MasterServerArch;

import java.net.InetSocketAddress;

import org.apache.giraph.bsp.CentralizedServiceMaster;
import org.apache.giraph.comm.MasterServer;
import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;

import org.apache.hadoop.util.Progressable;

public interface IMasterServerImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (MasterServerArch arch);
	public MasterServerArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    //To be imported: InetSocketAddress,CentralizedServiceMaster,ImmutableClassesGiraphConfiguration,Progressable
    public MasterServer instantiate (ImmutableClassesGiraphConfiguration conf,CentralizedServiceMaster<?, ?, ?> service,Progressable progressable,Thread.UncaughtExceptionHandler exceptionHandler)  ;        
    public InetSocketAddress getMyAddress ()  ;        
    public void close ()  ;        
}