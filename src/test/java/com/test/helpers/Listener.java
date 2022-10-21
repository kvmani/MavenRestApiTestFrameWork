package com.test.helpers;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listener extends UserServiceHelper implements ITestListener{
	public void onTestFailure(ITestResult result) {
		report.logTestFailed("Testcase Failed for  "+result.getName());
	}
	public void onTestSucess(ITestResult result) {
		report.logTestFailed("Testcase passed for "+result.getName());
	}
}


