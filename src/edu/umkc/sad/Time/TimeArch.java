package edu.umkc.sad.Time;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import java.util.Date;

public class TimeArch extends AbstractMyxSimpleBrick implements ITime
{
    public static final IMyxName msg_ITime = MyxUtils.createName("edu.umkc.sad.Time.ITime");


	private ITimeImp _imp;

    public TimeArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ITimeImp getImplementation(){
        try{
			return new SystemTime();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_ITime)){
			return this;
		}        
		return null;
	}
  
    //To be imported: Date
    public long getMilliseconds ()   {
		return _imp.getMilliseconds();
    }    
    public long getMicroseconds ()   {
		return _imp.getMicroseconds();
    }    
    public long getNanoseconds ()   {
		return _imp.getNanoseconds();
    }    
    public int getSeconds ()   {
		return _imp.getSeconds();
    }    
    public Date getCurrentDate ()   {
		return _imp.getCurrentDate();
    }    
    public ITimeImp get1 ()   {
		return _imp.get1();
    }    
    public void sleep (long milliseconds) throws InterruptedException {
		_imp.sleep(milliseconds);
    }    
}