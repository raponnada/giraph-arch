package edu.umkc.comm.aggregators;


import org.apache.giraph.comm.aggregators.GlobalCommValueOutputStream;

import edu.umkc.arch.GiraphArch;

public class CommCacheImpl implements ICommCacheImp
{
	private CommCacheArch _arch;

    public CommCacheImpl (){
    }

	public void setArch(CommCacheArch arch){
		_arch = arch;
	}
	public CommCacheArch getArch(){
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
		System.out.println("Cache implementation");
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

	@Override
	public GlobalCommValueOutputStream createInsta(boolean writeClass) {
		// TODO Auto-generated method stub
		return new GlobalCommValueOutputStream(writeClass);
	}
}