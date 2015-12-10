package edu.umkc.zk;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class ZkAdminArch extends AbstractMyxSimpleBrick
{
    public static final IMyxName msg_Izkadmin = MyxUtils.createName("edu.umkc.zk.Izkadmin");

    public Izkadmin OUT_Izkadmin;

	private IGiraphZooKeeperAdminImp _imp;

    public ZkAdminArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IGiraphZooKeeperAdminImp getImplementation(){
        try{
			return new ZkAdminImpl();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_Izkadmin = (Izkadmin) MyxUtils.getFirstRequiredServiceObject(this,msg_Izkadmin);
        if (OUT_Izkadmin == null){
 			System.err.println("Error: Interface edu.umkc.zk.Izkadmin returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		return null;
	}
}