package com.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
   
	static ExtentReports extent; 
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		//ExtentReports //ExtentSparkReporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); //expecting the path to create the html file and do config
		reporter.config().setDocumentTitle("ReMeDi");
		reporter.config().setReportName("ReMeDi Test Report");
		
		// now we have to attach the report to the main class
	    extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Saket Barmate");
		
		return extent;
		
	}
}
