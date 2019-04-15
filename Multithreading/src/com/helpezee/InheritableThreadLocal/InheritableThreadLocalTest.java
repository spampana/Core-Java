package com.helpezee.InheritableThreadLocal;

class ParentThread extends Thread {
	
	public static InheritableThreadLocal<String> t1 = new InheritableThreadLocal<>();
	
	public static ThreadLocal<String> t2 = new ThreadLocal<>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static InheritableThreadLocal<String> t3 = new InheritableThreadLocal() {
		@Override
		public Object childValue(Object parentValue) {
			return "ChildData for t3";
		}
	};
	
	public void run() {
		t1.set("Parent-value-t1");
		t2.set("Parent-Thread-Local-t2");
		t3.set("Parent value-t3");
		System.out.println("Parent Thread value t1 : " + t1.get());
		System.out.println("Parent Thread value t2 : " + t2.get());
		System.out.println("Parent Thread value t3 : " + t3.get());

		ChildThread c1 = new ChildThread();
		c1.start();
	}
}

class ChildThread extends Thread {
	public void run() {
		System.out.println("Child Thread value-t1 : " + ParentThread.t1.get());
		System.out.println("Child Thread value-t2 : " + ParentThread.t2.get());
		System.out.println("Child Thread value-t3 : " + ParentThread.t3.get());
	}
}

public class InheritableThreadLocalTest {

	public static void main(String[] args) {
		ParentThread p1 = new ParentThread();
		p1.start();
	}

}
