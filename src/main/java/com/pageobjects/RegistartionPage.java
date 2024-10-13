package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractcomponenents.AbstractComponents;

public class RegistartionPage extends AbstractComponents {
    WebDriver driver; //set to class level so that other mathods can use same driver
    //created constructor
	public RegistartionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   //Initialize elements
	//all mandatory 
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(id = "insertyear")
	WebElement year;
	
	@FindBy(id = "insertmonth")
	WebElement month;
	
	@FindBy(id = "insertday") 
	WebElement day;
	
	@FindBy(id = "male_radio")
	WebElement maleradiobtn;
	
	@FindBy(id = "mobile")
	WebElement mobilenumber;
	
	@FindBy(id = "consentcheck")
	WebElement consentcheckbox;
	
	@FindBy(id = "regPatientBtn")
	WebElement registerbtn;
	
	@FindBy(xpath = "//div[@class = 'bootbox-body']")
	WebElement registertoast;
	
	@FindBy(xpath = "//button[@type = 'button' and text() = 'OK']")
	WebElement Okbtn;
	
	////button[@type = 'button' and text() = 'OK']
	
	//Actions register patient 
	
		public void setfname(String fname) {
			
			firstName.sendKeys(fname);
			
		}
		
        public void setlname(String lname) {
			
			lastName.sendKeys(lname);
			
		}
        
         public void setyear(String YYear) {
			
			year.sendKeys(YYear);
			
		}
         
         public void setmonth(String Month) {
 			
 			month.sendKeys(Month);
 			
 		}
         
         public void setday(String Day) {
 			
 			day.sendKeys(Day);
 			
 			
 		}
         
         public void setmobileNumber(String mobile) {
  			
        	 mobilenumber.sendKeys(mobile);
  			
  			
  		}
         
         
         public void checkConsentbox() {
        	 
        	 consentcheckbox.click();
        	 
         }
         
         
           public void clickOnRegisterbtn() {
        	 
        	   registerbtn.click();
        	 
         }
           
           public void selectmalegender() {
          	 
        	   maleradiobtn.click();
        	 
         }
           
           public String getRegistrationtoast() {
        	   waitforWebElementToAppear(registertoast);
        	   
        	   return registertoast.getText();
           }
           
           public String extractPatientIDResponse() {
        	   
        	   String Patientresp = getRegistrationtoast();
        	   
        	    String[] patientID=Patientresp.split("Patient ID is");
        	    
        	    String id = patientID[1].trim();
        	    
        	   return id;
        	   
        	   
        	   
        	   
           }
           
           public void clickOkAfterRegister() {
        	   
        	   Okbtn.click();
           }
           
           
         
         
         
           public String getRegisteredPatientID(){
       		
        	   setfname(getfirstName());
       		   setlname("Smith");
       		   setyear("25");
       		   setday("1");
       		   setmonth("1");
       		   setmobileNumber("1234567890");
       		   selectmalegender();
       		   checkConsentbox();
       		   clickOnRegisterbtn();
       		return extractPatientIDResponse();
       	}
       		
         
	
	
	
	
	
	
	
	
	
	
}
