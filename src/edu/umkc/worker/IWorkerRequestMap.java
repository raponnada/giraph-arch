package edu.umkc.worker;

import org.apache.giraph.comm.netty.handler.WorkerRequestReservedMap;

public interface IWorkerRequestMap {
	public boolean reserveRequest(WorkerRequestReservedMap wrrm ,Integer workerId, long requestId);
}
