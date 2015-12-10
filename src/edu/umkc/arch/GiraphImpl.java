package edu.umkc.arch;


import static java.lang.System.out;

import java.io.IOException;
import java.util.List;

import org.apache.giraph.bsp.CentralizedServiceWorker;
import org.apache.giraph.comm.aggregators.GlobalCommValueOutputStream;
import org.apache.giraph.conf.GiraphConfiguration;
import org.apache.giraph.conf.IntConfOption;
import org.apache.giraph.ooc.MemoryEstimator;
import org.apache.giraph.time.Time;
import org.apache.giraph.zk.GiraphZooKeeperAdmin;
import org.apache.giraph.zk.ZooKeeperExt;
import org.apache.hadoop.mapreduce.Job;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;

import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import edu.umkc.sad.GiraphAppRunner_PageRank;

public class GiraphImpl implements IgiraphImp
{
	public static GiraphArch _arch;

    public GiraphImpl (){
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
  
    //To be imported: CreateMode,ACL,Stat,List,Watcher
    public String createExt (final String path,byte[] data,List<ACL> acl,CreateMode createMode,boolean recursive)   {
		return null;
    }
    
	public void deleteExt(ZooKeeperExt zooKeeper, String path, int version, boolean recursive) throws InterruptedException, KeeperException{
	try {    		
	      zooKeeper.deleteExt(path, version, recursive);
	      out.println("[GIRAPH-ZKADMIN] Deleted: " + path);
	      } 
	catch (KeeperException.NotEmptyException e) {
	      List<String> childList = zooKeeper.getChildrenExt(path, false, false, false);
	      for (String child : childList) {
	        String childPath = path + "/" + child;
	        deleteExt(zooKeeper, childPath, -1, false);
	      }
	      zooKeeper.deleteExt(path, -1, false);
	      out.println("[GIRAPH-ZKADMIN] Deleted: " + path);
	    }
	}
    
    public Stat exists (String path,boolean watch)   {
		//TODO Auto-generated method stub
		return null;
    }
    public Stat exists (final String path,Watcher watcher)   {
		//TODO Auto-generated method stub
		return null;
    }
    public byte[] getData (final String path,Watcher watcher,Stat stat)   {
		//TODO Auto-generated method stub
		return null;
    }
    public byte[] getData (String path,boolean watch,Stat stat)   {
		//TODO Auto-generated method stub
		return null;
    }
    public List<String> getChildrenExt (final String path,boolean watch,boolean sequenceSorted,boolean fullPath)   {
		//TODO Auto-generated method stub
		return null;
    }
    public void close () throws InterruptedException {
		//TODO Auto-generated method stub
		
    }

	public ZooKeeperExt createInstance(String zkServerList, int session_timeout, int ops_max_attempts,
			int serverList_Poll, GiraphZooKeeperAdmin gzka) {
		
		try {
			return new ZooKeeperExt(zkServerList,session_timeout,ops_max_attempts,serverList_Poll,gzka);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public GlobalCommValueOutputStream createInsta(boolean writeClass){
		return _arch.OUT_ICommCache.createInsta(writeClass);
	}
	public void printHaltInfo(Job submittedJob,GiraphConfiguration conf){
		_arch.OUT_IHaltApplicationUtil.printHaltInfo(submittedJob, conf);
	}
	
	
	public void init(MemoryEstimator memEst, CentralizedServiceWorker csw){
		_arch.OUT_IMemEst.initialize(memEst, csw);
	}
	public double maxMB(MemoryEstimator memEst){
		return _arch.OUT_IMemEst.maxMemoryMB(memEst);
	}
	public double freeMB(MemoryEstimator memEst){
		return _arch.OUT_IMemEst.freeMemoryMB(memEst);
	}
	
	public Time getTime(){
		System.out.println("Time class implementation");
		return _arch.OUT_ITime.getTime();
	}
}