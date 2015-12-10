package comp.GiraphHadoopCounter;

import org.apache.giraph.counters.GiraphHadoopCounter;

public class GiraphHadoopCounterImp implements IGiraphHadoopCounterImp
{
	private GiraphHadoopCounterArch _arch;

    public GiraphHadoopCounterImp (){
    }

	public void setArch(GiraphHadoopCounterArch arch){
		_arch = arch;
	}
	public GiraphHadoopCounterArch getArch(){
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
	public GiraphHadoopCounter[] createArrayInstance(int num_count) {
		// TODO Auto-generated method stub
		return new GiraphHadoopCounter[num_count];
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
}