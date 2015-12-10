package org.apache.giraph.comm;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.bsp.CentralizedServiceMaster;

import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;

import org.apache.hadoop.mapreduce.Mapper;

public class MasterClientArch extends AbstractMyxSimpleBrick implements IMasterClient
{
    public static final IMyxName msg_IMasterClient = MyxUtils.createName("org.apache.giraph.comm.IMasterClient");


	private IMasterClientImp _imp;

    public MasterClientArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IMasterClientImp getImplementation(){
        try{
			return new MasterClientImp();    
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
		if (arg0.equals(msg_IMasterClient)){
			return this;
		}        
		return null;
	}
  
    //To be imported: CentralizedServiceMaster,ImmutableClassesGiraphConfiguration,Mapper
    public void openConnections ()   {
		_imp.openConnections();
    }    
    public void flush ()   {
		_imp.flush();
    }    
    public MasterClient initialize (Mapper<?, ?, ?, ?>.Context context,ImmutableClassesGiraphConfiguration configuration,CentralizedServiceMaster<?, ?, ?> service,Thread.UncaughtExceptionHandler exceptionHandler)   {
		return _imp.initialize(context,configuration,service,exceptionHandler);
    }    
    public void closeConnections ()   {
		_imp.closeConnections();
    }    
}