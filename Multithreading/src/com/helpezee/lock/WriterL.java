package com.helpezee.lock;

import static java.lang.Thread.sleep;

public class WriterL implements Runnable {

	ReentrantReadWriteLockTest object;

    public WriterL(ReentrantReadWriteLockTest object) {
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                object.put("key" + i, "value" + i);
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}