package edu.umkc;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;

public class GiraphArch extends AbstractMyxSimpleBrick
{


	private IGiraphSingleImp _imp;

    public GiraphArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IGiraphSingleImp getImplementation(){
        try{
			return new GiraphImp();    
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
		return null;
	}
}