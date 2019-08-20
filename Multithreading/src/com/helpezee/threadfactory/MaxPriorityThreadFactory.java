package com.helpezee.threadfactory;

import java.util.concurrent.ThreadFactory;

public class MaxPriorityThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	}

}
