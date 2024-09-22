package com.abstractcomponenents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	//This class if parent class of page classes and 
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// here I will catch the driver coming from pageobjects classes by super keyword for this we need to do
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle = 'tab' and @href ='#LocalConsultationTab']")
	WebElement walkinlist;
	
	//actions and common mathods 
	
	public void goToWalkin() {
		
		walkinlist.click();
	} 

	public void waitforElementToAppear(By findby) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
		
	}
	
	public void waitforWebElementToAppear(WebElement element) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
		
		
		
	}
	