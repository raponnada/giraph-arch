package edu.umkc.zk;


import edu.umkc.zk.ZkAdminArch;

public interface IGiraphZooKeeperAdminImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ZkAdminArch arch);
	public ZkAdminArch getArch();
	
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
}