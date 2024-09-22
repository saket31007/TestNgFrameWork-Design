package com.test.components;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener, IAnnotationTransformer{
	ExtentTest test;             //holds the test entry 
	ExtentReports extent =ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());  
		extentTest.set(test); //setting unquie thread ID //(error validation)->test
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test passed");
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch ( Exception e1) {
			
			e1.printStackTrace();
		} 
		
		//take Screenshot
		//attch it to screenshot
		//screenshotcode is present at basetest
		String filepath = null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(), driver);
			System.out.println(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		//test.addScreenCaptureFromPath(filepath);
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
		
		
	}
	
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
		  }

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
