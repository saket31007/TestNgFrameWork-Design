package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.abstractcomponenents.AbstractComponents;

public class PRMSPage extends AbstractComponents{
	
	WebDriver driver;

	public PRMSPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
