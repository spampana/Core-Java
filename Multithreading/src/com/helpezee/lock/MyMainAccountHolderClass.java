package com.helpezee.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyMainAccountHolderClass {

	public static void main(String[] args) {
		
		Lock lock=new ReentrantLock();
//		Lock lock1=new ReentrantLock();
		Account a001=new Account(lock);
//		Account a002=new Account(lock1);
		
		Thread bibhu=new Thread(a001,"Bibhu");
		Thread krishna=new Thread(a001,"Krishna");

		bibhu.start();
		krishna.start();
	}

}
