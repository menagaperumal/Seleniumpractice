package day52_listeners_extent_reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class Listeners_utility implements ITestListener {

	  
	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getName());
	    
	  }
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName());
	  }
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName());
	   
	  }
	public void onStart(ITestContext context) {
		System.out.println(context.getName());
		
	   	  }

	  
	  public void onFinish(ITestContext context) {
		  System.out.println(context.getName());
	    
	  }

}
