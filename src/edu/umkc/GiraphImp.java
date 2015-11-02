package edu.umkc;

import edu.umkc.sad.GiraphAppRunner_PageRank;

public class GiraphImp implements IGiraphSingleImp
{
	private GiraphArch _arch;

    public GiraphImp (){
    }

	public void setArch(GiraphArch arch){
		_arch = arch;
	}
	public GiraphArch getArch(){
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
		try {
			GiraphAppRunner_PageRank.main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}