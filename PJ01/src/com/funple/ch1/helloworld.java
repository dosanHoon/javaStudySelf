package com.funple.ch1;

import com.funple.ch1.a.sub;

public class helloworld {
	public void getPrint(String name){
		System.out.println("name " + name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		helloworld hello = new helloworld();
		hello.getPrint("g한승훈");
		
		sub s = new sub();
		String str = s.getText("testtest");
		System.out.println("str = " + str);
	}

}
