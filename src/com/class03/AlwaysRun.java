package com.class03;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlwaysRun {
	
	@BeforeClass(alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	@AfterMethod(alwaysRun=true)
	public void afterMethos() {
		System.out.println("I am after method");
	}
	@Test
	public void testMethod() {
		System.out.println("I am test");
	}
	

}
