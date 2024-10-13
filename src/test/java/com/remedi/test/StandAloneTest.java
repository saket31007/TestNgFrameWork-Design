package com.remedi.test;
import java.util.UUID;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageobjects.HomePage;
import com.pageobjects.LandingPage;
import com.pageobjects.PRMSPage;
import com.pageobjects.RegistartionPage;
import com.test.components.BaseTest;

public class StandAloneTest extends BaseTest {
	
	
	@Test(dataProvider = "getData", groups = "smoketest") // we can also add multiple groups as per requirement simply
															// put , and add after smoketest
	public void submitTest(HashMap<String, String> input) throws Throwable {
//		
		// LandingPage landingpage = launchApplication(); //to remove this line will
		// define LandingPage in BaseTest class at global level

		
		HomePage homepage = landingpage.loginApplication(input.get("username"), input.get("password")); //passing login to homepage object to cntinue using the driver
		//landingpage.loginApplication("demo143", "123456");
		

//		boolean match = homepage.displayUserImageicon();
//		System.out.println(match);
//		Assert.assertTrue(match, "display icon is not showing");
//		

		// reaching to walkinlist

		// homepage.goToWalkin(); //here we can continue using homepage using homepage object refrence // walkin mathod should be created at homepage not at
		// abrtract components because its not common for all

		// assertions to the list

		// driver.close();// handle from AfterMethod

	}
	
	@Test(groups ="sanity")
	public void PrivacyLinkTest() {
		
		landingpage.goToPrivacyPolicy();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(landingpage.privacyText());
		
		Assert.assertEquals(landingpage.privacyText(), pro.getProperty("PrivacyHeader"));
	}
	
	@Test
	
	public String patient_Registeration() {
		
		// Login and navigate to HomePage
        HomePage homepage = landingpage.loginApplication("lalaa", "123456");
        
        // Navigate to the RegistrationPage from HomePage
        RegistartionPage register = homepage.goTopatientRegistration();
	
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		register.setfname(homepage.getfirstName());
		register.setlname("Smith");
		register.setyear("25");
		register.setday("1");
		register.setmonth("1");
		register.setmobileNumber("1234567890");
		register.selectmalegender();
		register.checkConsentbox();
		register.clickOnRegisterbtn();
		//register.clickOkAfterRegister();
		
		
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	System.out.println(register.getRegistrationtoast());
	
     System.out.println(register.extractPatientIDResponse());
        
     return register.extractPatientIDResponse();
	}
	
	
	@Test
	public void caseSheetFilling() throws InterruptedException {
		
		//HomePage homepage = landingpage.loginApplication("lalaa", "123456");
		
		// Login and navigate to HomePage
        HomePage homepage = landingpage.loginApplication("lalaa", "123456");
        
        // Navigate to the RegistrationPage from HomePage
        RegistartionPage register = homepage.goTopatientRegistration();
        register.getRegisteredPatientID();
        Thread.sleep(2000);
		register.clickOkAfterRegister();
		
		PRMSPage page = homepage.goToDiagnostic(register.extractPatientIDResponse());
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJasonDataToMap(
				System.getProperty("user.dir")+"\\src\\test\\java\\com\\datafiles\\LandingPage.json");

		return new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) } };

	}
	
	
	// Basic two dimentional array to fetch the data
//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"demo123", "123456"}, {"demo143", "123456"}, {"test2admin","123456"}};
//		
//	}

//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put("username", "demo123");
//	map.put("password", "123456");
//	
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("username", "demo143");
//	map1.put("password", "123456");
//	
//	HashMap<String, String> map2 = new HashMap<String, String>();
//	map2.put("username", "test2admin");
//	map2.put("password", "123456");



}