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
	
	@FindBy(xpath = "//a[@data-toggle = 'tab' and @href ='#LocalConsultationTab']")
	WebElement walkinlist;
	
	@FindBy(xpath = "//button[@onclick= 'resetagebox()']")
	WebElement Registrationbutton;
	
	@FindBy(xpath = "//button[@onclick = 'goForDiagnostic()']")
	WebElement Diagnosticbtn;
	
	@FindBy(id = "ser_patId")
	WebElement patientIDinput;
	
	@FindBy(xpath = "//button[@data-bb-handler='confirm']")
	WebElement confirmPatientOK;
	
	@FindBy(xpath = "//button[@data-bb-handler='cancel']")
	WebElement cancel;
	
	
	
	
	//actions and common mathods 
	
	public void goToWalkinList() {
		
		walkinlist.click();
	} 
	
	//action items validation should be taken care at testclass -- Assertions
	public boolean displayUserImageicon() {
		
		boolean iconavailable =userimage.isDisplayed();
		
		return iconavailable;
		
		
	}
	
	public RegistartionPage goTopatientRegistration() {
		Registrationbutton.click();
		return new RegistartionPage(driver);
		
	}

	
	
	
	public PRMSPage goToDiagnostic(String PatientID) {
		patientIDinput.sendKeys(PatientID);
		Diagnosticbtn.click();
		confirmPatientOK.click();
		
		return new PRMSPage(driver);
	}
	
	
	
	
	
 
 
}
