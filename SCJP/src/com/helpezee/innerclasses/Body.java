package com.helpezee.innerclasses;

public class Body {
	
	String name = "Body";

	public static void main(String[] args) {
		System.out.println(new Body().new Heart().getPName());
	}

	class Heart {
		String name = "Heart";

		String getPName() {
			System.out.println(Body.this);
			System.out.println(this);
		return Body.this.name;
		}

	}

}
