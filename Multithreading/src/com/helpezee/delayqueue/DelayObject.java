package com.helpezee.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {

	private String data;
	//this is a time when the element should be consumed from the queue.
	private long startTime;

	public DelayObject(String data, long delayInMilliseconds) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + delayInMilliseconds;
	}

	@Override
	public int compareTo(Delayed o) {
		 long diff = this.startTime - ((DelayObject) o).startTime;
		 Integer intVal = Math.toIntExact(diff);
		return intVal;
	}

	//getDelay() should return the remaining delay associated with this object in the given time unit.
	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "DelayObject [data=" + data + ", startTime=" + startTime + "]";
	}
}
