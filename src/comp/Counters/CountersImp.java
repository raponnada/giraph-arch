package comp.Counters;


import edu.umkc.sad.Counters.Source.GiraphHadoopCounter;
import edu.umkc.sad.Counters.Source.GiraphTimers;

import org.apache.hadoop.mapreduce.Mapper.Context;

public class CountersImp implements ICountersImp
{
	private CountersArch _arch;

    public CountersImp (){
    }

	public void setArch(CountersArch arch){
		_arch = arch;
	}
	public CountersArch getArch(){
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

	@Override
	public void init(Context context) {
		// TODO Auto-generated method stub
		GiraphTimers.init(context);
	}

	@Override
	public GiraphTimers getInstance() {
		// TODO Auto-generated method stub
		return GiraphTimers.getInstance();
	}
   
}