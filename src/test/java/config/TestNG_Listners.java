package config;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNG_Listners implements ITestListener {

	

	public void onTestStart(ITestResult result) {

		System.out.println("Initiated-----"+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("TestSuccess");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failure");
		
	}	

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("TestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("start -onTestFailedButWithinSuccessPercentage");
	}

	public void onStart(ITestContext context) {
	
		System.out.println("Test started---"+Thread.currentThread().getStackTrace()[1].getMethodName());
	
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test finished");
	}
	}

