package com.pageobjects;

import java.net.PasswordAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractcomponenents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	//create constructor 
	
	public LandingPage(WebDriver driver) {
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//WebElement username = driver.findElement(By.id("username"));
	// to construct the driver we need crate init elements at constructor
	//PageFactory model will be used 
	
	

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "submitBtn")
	WebElement loginbtn;
	@FindBy(id = "errmsg")
	WebElement errormsg;
	
	public HomePage loginApplication(String name, String pass) {
		 
      username.sendKeys(name);
      password.sendKeys(pass);
      loginbtn.click();
      HomePage homepage = new HomePage(driver);
      return homepage;
	}
	
	//create another action mathod land of the page
	
	//mathod to return the error msg at the landingpage
	
	public String geterrorToast() {
		waitforWebElementToAppear(errormsg);
		return errormsg.getText();
		
		
	}
	
	public void goTo() {
		 
		
		driver.get("https://s3test2.remedi.co.in/RemediPRMS/pages/common/login.jsp");
	}
	
}
