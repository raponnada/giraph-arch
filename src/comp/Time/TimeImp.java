package comp.Time;


import org.apache.giraph.time.SystemTime;
import org.apache.giraph.time.Time;

public class TimeImp implements ITimeImp
{
	private TimeArch _arch;

    public TimeImp (){
    }

	public void setArch(TimeArch arch){
		_arch = arch;
	}
	public TimeArch getArch(){
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
  
    //To be imported: Time
    public Time getTime ()   {
    	System.out.println("Time implementation");
		return SystemTime.get();
    }
}