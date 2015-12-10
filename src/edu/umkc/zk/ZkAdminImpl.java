package edu.umkc.zk;

import org.apache.giraph.conf.IntConfOption;
import org.apache.giraph.zk.GiraphZooKeeperAdmin;
import org.apache.giraph.zk.ZooKeeperExt;
import org.apache.zookeeper.KeeperException;

public class ZkAdminImpl implements IGiraphZooKeeperAdminImp
{
	public static ZkAdminArch _arch;

    public ZkAdminImpl (){
    }

	public void setArch(ZkAdminArch arch){
		_arch = arch;
	}
	public ZkAdminArch getArch(){
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
	public void deleteExt(ZooKeeperExt zooKeeper, String zkBasePath, int i, boolean b) throws InterruptedException, KeeperException {
		_arch.OUT_Izkadmin.deleteExt(zooKeeper, zkBasePath, i, b);
	}
	
	public ZooKeeperExt createInstance(String zkServerList, int i, int j, int k, GiraphZooKeeperAdmin gzka){
		return _arch.OUT_Izkadmin.createInstance(zkServerList, i, j, k, gzka);
	}
}