package edu.umkc.job;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.conf.GiraphConfiguration;

import org.apache.hadoop.mapreduce.Job;

public class HaltAppArch extends AbstractMyxSimpleBrick implements IHaltApplicationUtil
{
    public static final IMyxName msg_IHaltApplicationUtil = MyxUtils.createName("edu.umkc.job.IHaltApplicationUtil");


	private IHaltApplicationImp _imp;

    public HaltAppArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IHaltApplicationImp getImplementation(){
        try{
			return new HaltAppImpl();    
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
		if (arg0.equals(msg_IHaltApplicationUtil)){
			return this;
		}        
		return null;
	}
  
    //To be imported: GiraphConfiguration,Job
    public void printHaltInfo (Job submittedJob,GiraphConfiguration conf)   {
		_imp.printHaltInfo(submittedJob,conf);
    }    
}