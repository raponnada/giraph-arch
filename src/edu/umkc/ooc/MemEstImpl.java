package edu.umkc.ooc;

import org.apache.giraph.bsp.CentralizedServiceWorker;
import org.apache.giraph.ooc.MemoryEstimator;

public class MemEstImpl implements IMemEstimatorImp
{
	private MemEstArch _arch;

    public MemEstImpl (){
    }

	public void setArch(MemEstArch arch){
		_arch = arch;
	}
	public MemEstArch getArch(){
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
	public void initialize(MemoryEstimator memEst, CentralizedServiceWorker serviceWorker) {
		// TODO Auto-generated method stub
		memEst.initialize(serviceWorker);
	}

	@Override
	public double freeMemoryMB(MemoryEstimator memEst) {
		// TODO Auto-generated method stub
		return memEst.freeMemoryMB();
	}

	@Override
	public double maxMemoryMB(MemoryEstimator memEst) {
		// TODO Auto-generated method stub
		return memEst.maxMemoryMB();
	}

	

	/*
  	  Implementation primitives required by the architecture
	*/
}