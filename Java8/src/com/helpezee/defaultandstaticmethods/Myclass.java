package com.helpezee.defaultandstaticmethods;

public class Myclass implements Interface1, Interface2 {

	@Override
	public void method2() {
		System.out.println("Methnod2  from Myclass");
	}

	@Override
	public void method1(String str) {
		System.out.println("Method1  from Myclass");
	}


	//MyClass won't compile without having it's own log() implementation
		@Override
		public void log(String str){
			System.out.println("MyClass logging::"+str);
			Interface1.print("abc");
		}
}
