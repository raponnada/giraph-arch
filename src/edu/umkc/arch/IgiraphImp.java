package edu.umkc.arch;


import edu.umkc.arch.GiraphArch;

import java.util.List;

import org.apache.giraph.conf.GiraphConstants;
import org.apache.giraph.conf.IntConfOption;

import org.apache.giraph.zk.GiraphZooKeeperAdmin;
import org.apache.giraph.zk.ZooKeeperExt;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;

import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

public interface IgiraphImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (GiraphArch arch);
	public GiraphArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    //To be imported: GiraphConstants,IntConfOption,GiraphZooKeeperAdmin,ZooKeeperExt,CreateMode,KeeperException,ACL,Stat,List,Watcher
    public ZooKeeperExt createInstance (String zkServerList,int session_timeout,int ops_max_attempts,int serverList_Poll,GiraphZooKeeperAdmin gzka)  ;        
    public String createExt (final String path,byte[] data,List<ACL> acl,CreateMode createMode,boolean recursive)  ;        
    public void deleteExt (ZooKeeperExt zooKeeper,final String path,int version,boolean recursive) throws InterruptedException,KeeperException;        
    public Stat exists (String path,boolean watch)  ;        
    public Stat exists (final String path,Watcher watcher)  ;        
    public byte[] getData (final String path,Watcher watcher,Stat stat)  ;        
    public byte[] getData (String path,boolean watch,Stat stat)  ;        
    public List<String> getChildrenExt (final String path,boolean watch,boolean sequenceSorted,boolean fullPath)  ;        
    public void close () throws InterruptedException;        
}