package edu.umkc.sad.Time;


import java.util.Date;

public class SystemTime implements ITimeImp
{
	 private static final SystemTime SINGLE_TIME = new SystemTime();
	  /** Microseconds per millisecond */
	  public long US_PER_MS = 1000;
	  /** Nanoseconds per microsecond */
	  public long NS_PER_US = 1000;
	  /** Nanoseconds per millisecond */
	  public long NS_PER_MS = US_PER_MS * NS_PER_US;
	  /** Milliseconds per second */
	  public long MS_PER_SECOND = 1000;
	  /** Milliseconds per second (as float) */
	  public float MS_PER_SECOND_AS_FLOAT = MS_PER_SECOND * 1f;
	  /** Microseconds per second */
	  public long US_PER_SECOND = US_PER_MS * MS_PER_SECOND;
	  /** Microseconds per second (as float) */
	  public float US_PER_SECOND_AS_FLOAT = US_PER_SECOND * 1f;
	  /** Nanoseconds per second */
	  public long NS_PER_SECOND = NS_PER_US * US_PER_SECOND;
	  /** Nanoseconds per second (as float) */
	  public float NS_PER_SECOND_AS_FLOAT = NS_PER_SECOND * 1f;
	  /** Seconds per hour */
	  public long SECONDS_PER_HOUR = 60 * 60;
	  /** Seconds per day */
	  public long SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;
	  /** Milliseconds per hour */
	  public long MS_PER_HOUR = SECONDS_PER_HOUR * MS_PER_SECOND;
	  /** Milliseconds per day */
	  public long MS_PER_DAY = SECONDS_PER_DAY * MS_PER_SECOND;
	  
	private TimeArch _arch;

    public SystemTime (){
    }

	public void setArch(TimeArch arch){
		_arch = arch;
	}
	public TimeArch getArch(){
		return _arch;
	}
	 public static ITimeImp get() {
		    return SINGLE_TIME;
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
	@Override
	  public long getMilliseconds() {
	    return System.currentTimeMillis();
	  }

	  @Override
	  public long getMicroseconds() {
	    return getNanoseconds() / NS_PER_US;
	  }

	  @Override
	  public long getNanoseconds() {
	    return System.nanoTime();
	  }

	  @Override
	  public int getSeconds() {
	    return (int) (getMilliseconds() / MS_PER_SECOND);
	  }

	  @Override
	  public Date getCurrentDate() {
	    return new Date();
	  }

	  @Override
	  public void sleep(long milliseconds) throws InterruptedException {
	    Thread.sleep(milliseconds);
	  }

	@Override
	public ITimeImp get1() {
		// TODO Auto-generated method stub
		return SINGLE_TIME;
	}
	  
    
}