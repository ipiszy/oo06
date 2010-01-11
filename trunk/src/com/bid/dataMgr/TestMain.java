package com.bid.dataMgr;

public class TestMain {
	public static void main(String[]arg){
		DataBoundary b = new DataBoundary();
		
		// login test
		System.out.print("------------->");
		System.out.println(b.login("sepsky", "sepskypass"));
		System.out.print("------------->");
		System.out.println(b.login("sepsky", "sepskypas"));		
		System.out.print("------------->");
		System.out.println(b.login("sepsk", "sepskypass"));
		
		// browse test
		
		
		// bid test
		
		
		
	}
}
