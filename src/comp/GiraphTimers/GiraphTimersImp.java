package comp.GiraphTimers;


import org.apache.giraph.counters.GiraphTimers;

import org.apache.hadoop.mapreduce.Mapper.Context;

public class GiraphTimersImp implements IGiraphTimersImp
{
	public static GiraphTimersArch _arch;

    public GiraphTimersImp (){
    }

	public void setArch(GiraphTimersArch arch){
		_arch = arch;
	}
	public GiraphTimersArch getArch(){
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
  
    //To be imported: Context,GiraphTimers
    public void init (Context context)   {
    	GiraphTimers.init(context);
    }
    public GiraphTimers getInstance ()   {
		//TODO Auto-generated method stub
		return GiraphTimers.getInstance();
    }
}