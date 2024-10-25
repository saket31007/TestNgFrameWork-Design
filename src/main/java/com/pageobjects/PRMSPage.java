package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractcomponenents.AbstractComponents;

public class PRMSPage extends AbstractComponents{
	
	WebDriver driver;

	public PRMSPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "History_Of_Present_Illness")

	WebElement patientillness;

	@FindBy(id = "Personal_History")

	WebElement personalHistory;

	@FindBy(id = "Past_Medical_Surgical_History")

	WebElement pastsurgical;

	@FindBy(id = "Family_History")

	WebElement familyHistory;

	@FindBy(id = "Current_And_Recent_Medications")

	WebElement currentandRecentMedication;

	@FindBy(id = "Medical_Allergies")

	WebElement medicalallegies;

	@FindBy(id = "Other_Allergies_Or_Sensitivities")

	WebElement otherallergies;

	@FindBy(id = "Additional_Notes")

	WebElement additionalnotes;

	@FindBy(id = "Physical_Examination")

	WebElement physicalexm;
	
	@FindBy(id = "patient_history_save_btn")

	WebElement patienthistorySavebtn;
	
	@FindBy(id = "FinishConsultationBtn")

	WebElement finishbtn;
	
	@FindBy(xpath = "//button[@data-bb-handler='confirm']")
	
	WebElement finishokbtn;
	
    @FindBy(xpath = "//button[@data-bb-handler= 'ok']")
	
	WebElement savedataokbtn;
    
     @FindBy(id = "printAndSendEmailMdlBtn")
	
	WebElement printAndSendEmailbtn;
    
    
	
	//button[@data-bb-handler= 'ok']
	
	
	//actions to  perform
	
	
		public void finishConsultation() {
			
			finishbtn.click();
			finishokbtn.click();
			printAndSendEmailbtn.click();
			
		}
	

	
	public void fillpatientHistory(String text) {
		
		waitforWebElementToAppear(patientillness);
		patientillness.sendKeys(text);
		pastsurgical.sendKeys(text);
		personalHistory.sendKeys(text);
		familyHistory.sendKeys(text);
		currentandRecentMedication.sendKeys(text);
		medicalallegies.sendKeys(text);
		otherallergies.sendKeys(text);
		additionalnotes.sendKeys(text);
		physicalexm.sendKeys(text);
		patienthistorySavebtn.click();
		savedataokbtn.click();
	}

	
	
	
	
	

}
