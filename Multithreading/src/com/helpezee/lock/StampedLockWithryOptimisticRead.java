package com.helpezee.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockWithryOptimisticRead {

	public static void main(String[] args) {
		
		StampedLock sl = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Runnable as lambda - optimistic read
        Runnable r1 = ()->{
            long stamp = sl.tryOptimisticRead();
            try{
            	//Validate() method returns true if the lock has not been acquired in write mode since obtaining a given stamp.
                System.out.println("In optimistic lock  before  " + sl.validate(stamp));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Validate() method returns true if the lock has not been acquired in write mode since obtaining a given stamp.
                System.out.println("In optimistic lock  after  " + sl.validate(stamp));
                
            }finally{
                sl.unlock(stamp);
            }
        };
        
        
        // Runnable as lambda - Write lock
        Runnable r2 = ()->{
            System.out.println("about to get write lock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long stamp = sl.writeLock();
            try{
                System.out.println("After getting write lock ");
                
            }finally{
                sl.unlock(stamp);
                System.out.println("Relinquished write lock ");
            }
        };
        
        executor.submit(r2);
        // Optimistic read
        executor.submit(r1);
        executor.submit(r2);
        
        executor.shutdown();
    }
}

