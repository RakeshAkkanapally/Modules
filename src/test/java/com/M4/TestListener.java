package com.M4;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements IInvokedMethodListener{
	
	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		Reporter.log("Method started: " + method.getTestMethod().getMethodName());		
	}
	
	
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if(method.getTestResult().isSuccess()==true)
			Reporter.log("Test Method Passed");	
		else
			Reporter.log("Test Method Failed");

}
}