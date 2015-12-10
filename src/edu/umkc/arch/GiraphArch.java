package edu.umkc.arch;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.comm.aggregators.ICommCache;

import edu.umkc.counters.IGiraphTimers;

import edu.umkc.job.IHaltApplicationUtil;

import edu.umkc.ooc.IMemEst;

import edu.umkc.scripting.deployedScript.IDeployedScript;

import edu.umkc.time.ITime;

import edu.umkc.worker.IWorkerRequestMap;

import edu.umkc.zk.Izkadmin;

import java.util.List;

import org.apache.giraph.comm.IMasterClient;
import org.apache.giraph.comm.IMasterServer;

import org.apache.giraph.comm.netty.IByteCounter;

import org.apache.giraph.conf.GiraphConstants;
import org.apache.giraph.conf.IntConfOption;

import org.apache.giraph.zk.GiraphZooKeeperAdmin;
import org.apache.giraph.zk.ZooKeeperExt;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;

import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

public class GiraphArch extends AbstractMyxSimpleBrick implements Izkadmin
{
    public static final IMyxName msg_Izkadmin = MyxUtils.createName("edu.umkc.zk.Izkadmin");
    public static final IMyxName msg_IHaltApplicationUtil = MyxUtils.createName("edu.umkc.job.IHaltApplicationUtil");
    public static final IMyxName msg_ICommCache = MyxUtils.createName("edu.umkc.comm.aggregators.ICommCache");
    public static final IMyxName msg_IMemEst = MyxUtils.createName("edu.umkc.ooc.IMemEst");
    public static final IMyxName msg_ITime = MyxUtils.createName("edu.umkc.time.ITime");
    public static final IMyxName msg_IWorkerRequestMap = MyxUtils.createName("edu.umkc.worker.IWorkerRequestMap");
    public static final IMyxName msg_IGiraphTimers = MyxUtils.createName("edu.umkc.counters.IGiraphTimers");
    public static final IMyxName msg_IDeployedScript = MyxUtils.createName("edu.umkc.scripting.deployedScript.IDeployedScript");
    public static final IMyxName msg_IMasterClient = MyxUtils.createName("org.apache.giraph.comm.IMasterClient");
    public static final IMyxName msg_IMasterServer = MyxUtils.createName("org.apache.giraph.comm.IMasterServer");
    public static final IMyxName msg_IByteCounter = MyxUtils.createName("org.apache.giraph.comm.netty.IByteCounter");

    public IHaltApplicationUtil OUT_IHaltApplicationUtil;
    public ICommCache OUT_ICommCache;
    public IMemEst OUT_IMemEst;
    public ITime OUT_ITime;
    public IWorkerRequestMap OUT_IWorkerRequestMap;
    public IGiraphTimers OUT_IGiraphTimers;
    public IDeployedScript OUT_IDeployedScript;
    public IMasterClient OUT_IMasterClient;
    public IMasterServer OUT_IMasterServer;
    public IByteCounter OUT_IByteCounter;

	private IgiraphImp _imp;

    public GiraphArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IgiraphImp getImplementation(){
        try{
			return new GiraphImpl();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_IHaltApplicationUtil = (IHaltApplicationUtil) MyxUtils.getFirstRequiredServiceObject(this,msg_IHaltApplicationUtil);
        if (OUT_IHaltApplicationUtil == null){
 			System.err.println("Error: Interface edu.umkc.job.IHaltApplicationUtil returned null");
			return;       
        }
        OUT_ICommCache = (ICommCache) MyxUtils.getFirstRequiredServiceObject(this,msg_ICommCache);
        if (OUT_ICommCache == null){
 			System.err.println("Error: Interface edu.umkc.comm.aggregators.ICommCache returned null");
			return;       
        }
        OUT_IMemEst = (IMemEst) MyxUtils.getFirstRequiredServiceObject(this,msg_IMemEst);
        if (OUT_IMemEst == null){
 			System.err.println("Error: Interface edu.umkc.ooc.IMemEst returned null");
			return;       
        }
        OUT_ITime = (ITime) MyxUtils.getFirstRequiredServiceObject(this,msg_ITime);
        if (OUT_ITime == null){
 			System.err.println("Error: Interface edu.umkc.time.ITime returned null");
			return;       
        }
        OUT_IWorkerRequestMap = (IWorkerRequestMap) MyxUtils.getFirstRequiredServiceObject(this,msg_IWorkerRequestMap);
        if (OUT_IWorkerRequestMap == null){
 			System.err.println("Error: Interface edu.umkc.worker.IWorkerRequestMap returned null");
			return;       
        }
        OUT_IGiraphTimers = (IGiraphTimers) MyxUtils.getFirstRequiredServiceObject(this,msg_IGiraphTimers);
        if (OUT_IGiraphTimers == null){
 			System.err.println("Error: Interface edu.umkc.counters.IGiraphTimers returned null");
			return;       
        }
        OUT_IDeployedScript = (IDeployedScript) MyxUtils.getFirstRequiredServiceObject(this,msg_IDeployedScript);
        if (OUT_IDeployedScript == null){
 			System.err.println("Error: Interface edu.umkc.scripting.deployedScript.IDeployedScript returned null");
			return;       
        }
        OUT_IMasterClient = (IMasterClient) MyxUtils.getFirstRequiredServiceObject(this,msg_IMasterClient);
        if (OUT_IMasterClient == null){
 			System.err.println("Error: Interface org.apache.giraph.comm.IMasterClient returned null");
			return;       
        }
        OUT_IMasterServer = (IMasterServer) MyxUtils.getFirstRequiredServiceObject(this,msg_IMasterServer);
        if (OUT_IMasterServer == null){
 			System.err.println("Error: Interface org.apache.giraph.comm.IMasterServer returned null");
			return;       
        }
        OUT_IByteCounter = (IByteCounter) MyxUtils.getFirstRequiredServiceObject(this,msg_IByteCounter);
        if (OUT_IByteCounter == null){
 			System.err.println("Error: Interface org.apache.giraph.comm.netty.IByteCounter returned null");
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
		if (arg0.equals(msg_Izkadmin)){
			return this;
		}        
		return null;
	}
  
    //To be imported: GiraphConstants,IntConfOption,GiraphZooKeeperAdmin,ZooKeeperExt,CreateMode,KeeperException,ACL,Stat,List,Watcher
    public ZooKeeperExt createInstance (String zkServerList,int session_timeout,int ops_max_attempts,int serverList_Poll,GiraphZooKeeperAdmin gzka)   {
		return _imp.createInstance(zkServerList,session_timeout,ops_max_attempts,serverList_Poll,gzka);
    }    
    public String createExt (final String path,byte[] data,List<ACL> acl,CreateMode createMode,boolean recursive)   {
		return _imp.createExt(path,data,acl,createMode,recursive);
    }    
    public void deleteExt (ZooKeeperExt zooKeeper,final String path,int version,boolean recursive) throws InterruptedException,KeeperException {
		_imp.deleteExt(zooKeeper,path,version,recursive);
    }    
    public Stat exists (String path,boolean watch)   {
		return _imp.exists(path,watch);
    }    
    public Stat exists (final String path,Watcher watcher)   {
		return _imp.exists(path,watcher);
    }    
    public byte[] getData (final String path,Watcher watcher,Stat stat)   {
		return _imp.getData(path,watcher,stat);
    }    
    public byte[] getData (String path,boolean watch,Stat stat)   {
		return _imp.getData(path,watch,stat);
    }    
    public List<String> getChildrenExt (final String path,boolean watch,boolean sequenceSorted,boolean fullPath)   {
		return _imp.getChildrenExt(path,watch,sequenceSorted,fullPath);
    }    
    public void close () throws InterruptedException {
		_imp.close();
    }    
}