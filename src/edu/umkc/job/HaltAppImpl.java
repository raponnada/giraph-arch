package edu.umkc.job;


import org.apache.giraph.conf.GiraphConfiguration;
import org.apache.giraph.job.HaltApplicationUtils;
import org.apache.hadoop.mapreduce.Job;

public class HaltAppImpl implements IHaltApplicationImp
{
	public static HaltAppArch _arch;

    public HaltAppImpl (){
    }

	public void setArch(HaltAppArch arch){
		_arch = arch;
	}
	public HaltAppArch getArch(){
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
  
    //To be imported: GiraphConfiguration,Job
    public void printHaltInfo (Job submittedJob,GiraphConfiguration conf)   {
    	System.out.println("printHaltImpl user module");
    	HaltApplicationUtils.printHaltInfo(submittedJob, conf);
    }
}