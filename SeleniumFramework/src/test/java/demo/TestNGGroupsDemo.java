package demo;

import org.testng.annotations.Test;

public class TestNGGroupsDemo {
	
	
	@Test (groups = {"Sanity"})
	public void Test1() {
		System.out.println("This is Test1");
	}
	
	@Test (groups = {"Sanity","Smoke"})
	public void Test2() {
		System.out.println("This is Test2");
	}
	
	@Test (groups = {"Sanity","Regression"})
	public void Test3() {
		System.out.println("This is Test3");
	}
    
	@Test (groups = {"windows.regression"})
	public void Test4() {
		System.out.println("This is Test4");
	}

	@Test (groups = {"linux.regression"})
	public void Test5() {
		System.out.println("This is Test5");
	}


}

