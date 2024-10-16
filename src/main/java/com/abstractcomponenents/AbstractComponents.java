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

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class AbstractComponents {
	
	//This class if parent class of page classes and 
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// here I will catch the driver coming from pageobjects classes by super keyword for this we need to do
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void waitforElementToAppear(By findby) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
		
	}
	
	public void waitforWebElementToAppear(WebElement element) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
		
	public String getfirstName() {
		
		Faker fake = new Faker();
		String firstName =fake.name().firstName();
		return firstName;
	}
		
public String getlastName() {
		
		Faker fake = new Faker();
		String lastName =fake.name().lastName();
		return lastName;
	}

public String getAge() {
	
	Faker fake = new Faker();
	String Age =fake.number().digits(2);
	return Age;
}
		
public String getContact() {
	
	Faker fake = new Faker();
	String phone =fake.number().digits(10);
	return phone;
}
		
	
	
	}
	