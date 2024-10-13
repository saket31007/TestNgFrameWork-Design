package com.test.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pageobjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;
    public Properties pro;
	public WebDriver initializeDriver() throws IOException {
		// properties class
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\GlobalData.properties";
	    pro = new Properties(); // initialize the object for reading property file
		FileInputStream fis = new FileInputStream(path);
		pro.load(fis); // expected inputStream
		String browsername =  System.getProperty("browser")!= null ? System.getProperty("browser") : pro.getProperty("browser"); //used turnary operator for mvn build for passing global parameter

		if (browsername.contains("chrome")) {
			
		ChromeOptions options = new ChromeOptions();
		 
		 if(browsername.contains("headless")) {
		 options.addArguments("headless");
		 }
		 
			driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900)); // open in full screenmode with headlessmode if flackyness the test
		} else if (browsername.equals("firefox")) {

			// firefox invocation code
			 WebDriverManager.firefoxdriver().setup();
		     driver = new FirefoxDriver();

		}

		else if (browsername.equals("edge")) {
			
			//WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();

			// edge invocation code

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;
	}

	public List<HashMap<String, String>> getJasonDataToMap(String filepath) throws IOException {

		String jsonContant = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		// String to HashMap Jackson Databind--dependecy for maven add to maven

		List<HashMap<String, String>> data = mapper.readValue(jsonContant,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"\\reports"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		System.out.println(System.getProperty("user.dir") +"\\reports\\"+testCaseName+".png");
		return System.getProperty("user.dir") +"\\reports\\"+testCaseName+".png";
		
	}

	// run before anymethod this will take care of driver initialization and
	// lanching the application
	@BeforeMethod(alwaysRun = true)
    
	public LandingPage launchApplication() throws IOException {

		// called the mathod initialize driver where the creation of driver is done to
		// pass same driver in the landing page
		initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo(); //pro.getProperty can we used to get the file from config properties
		// to get issue resolved we have the return the landing page object so we can
		// use in the testcase
		return landingpage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.close();
	}

}
