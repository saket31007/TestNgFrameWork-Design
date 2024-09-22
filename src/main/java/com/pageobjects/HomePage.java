package com.pageobjects;

import java.net.PasswordAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractcomponenents.AbstractComponents;

public class HomePage extends AbstractComponents {
	
	WebDriver driver;
	
	//create constructor 
	
	public HomePage(WebDriver driver) {
		
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	

	@FindBy(xpath = "(//img[@class= 'img-rounded'])[1]")
	WebElement userimage;
	
	//action items validation should be taken care at testclass -- Assertions
	public boolean displayUserImageicon() {
		
		boolean iconavailable =userimage.isDisplayed();
		
		return iconavailable;
		
		
	}
	
	
	
 
 
}
