package com.helpezee.multiplebounds;

//<T extends superClassName & Interface>
class Bound<T extends A & B> {

	private T objRef;

	public Bound(T obj) {
		this.objRef = obj;
	}

	public void doRunTest() {
		this.objRef.displayClass();
	}
}