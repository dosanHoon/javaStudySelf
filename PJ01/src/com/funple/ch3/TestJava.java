package com.funple.ch3;

public class TestJava {

	public static void main(String[] args) {
		TestBean tb = new TestBean();
		System.out.println("tb int1 = " + tb.getInt1());
		System.out.println("tb str2 = " + tb.getStr1());
		
		
		int i = TestBean.int1;
		i = 123;
		//tb.setInt1(5);
		//tb.setStr1("q이하");
		System.out.println(i);
		System.out.println("tb int1 = " + tb.getInt1());
		
		TestBean.int1 = 456;
		
		System.out.println(i);
		System.out.println("tb int1 = " + tb.getInt1());
	}
	
	public static void method2 (){
		System.out.println("test");
	}

}
