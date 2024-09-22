package com.remedi.test;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;
import com.test.components.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"NegativeScenario"})
	public void blankusername_blankpassword(){
		
		landingpage.loginApplication("", "");
		Assert.assertEquals("Please Provide Username", landingpage.geterrorToast());
		
	
	}
	
	@Test
	public void validUsername_blankpassword(){
		
		landingpage.loginApplication("demo143", "");
		Assert.assertEquals("Please Provide Password", landingpage.geterrorToast());
	}

	@Test 
	public void blankUsername_validpassword(){
		
		landingpage.loginApplication("", "123456");
		Assert.assertEquals("Please Provide Username", landingpage.geterrorToast()); // mistakenly i have wtitten reverse that why reprt showibg wron
	}
	
	@Test

public void validUsername_invalidPassword(){
		
		landingpage.loginApplication("demo143", "Saket@123.");
		Assert.assertEquals("Invalid Username or Password Retry", landingpage.geterrorToast());
	}
	
	@Test
public void invalidUsername_validPassword(){
		
		landingpage.loginApplication("demo312", "123456");
		Assert.assertEquals("Invalid Username or Password Retry", landingpage.geterrorToast());
	}

	}
