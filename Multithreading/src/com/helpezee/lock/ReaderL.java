package com.helpezee.lock;

public class ReaderL implements Runnable {

	ReentrantReadWriteLockTest object;

   public ReaderL(ReentrantReadWriteLockTest object) {
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            object.get("key" + i);
        }
    }
}