package com.helpezee.phaser;

import java.util.concurrent.Phaser;

class LongRunningAction implements Runnable {
    
	private String threadName;
    private Phaser ph;

    LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        //To participate in the coordination, the thread needs to register() itself with the Phaser instance
        //This will increment the number of threads using that specific Phaser.
        ph.register();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + ph.getPhase());
        System.out.println("Thread " + threadName + " before long running action");
        //The thread signals that it arrived at the barrier by calling the arriveAndAwaitAdvance(), which is a blocking method.
        //when the number of arrived parties becomes the same as the number of registered parties, the execution will continue.
        ph.arriveAndAwaitAdvance();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //When the thread finishes its job, we should call the arriveAndDeregister() method to signal that the current thread 
        //should no longer be accounted for in this particular phase.
        ph.arriveAndDeregister();
    }
}
