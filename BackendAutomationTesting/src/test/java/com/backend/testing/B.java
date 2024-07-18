package com.backend.testing;

public class B {
	
	public static B a() {
		System.out.println("executed mtd a");
		return new B();
	}

	
	public static B b() {
		System.out.println("executed mtd b");
		return new B();
	}
	
	public static C c() {
		System.out.println("executed mtd c");
		return new C();
	}
}
