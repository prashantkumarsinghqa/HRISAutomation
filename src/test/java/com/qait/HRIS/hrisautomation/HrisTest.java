package com.qait.HRIS.hrisautomation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class HrisTest {

	LoginPanel appObject;
	public HrisTest() {
		appObject = new LoginPanel();
	}
	
@Test (priority=1)
public void NoPasswordTest() {
	appObject.Fillcredentials("Anasali","");
    Assert.assertTrue(appObject.isPasswordEntryAnnotated());  

} 
 

@Test (priority=2)
public void WrongPasswordTest() {
	  Assert.assertTrue(appObject.WrongPassword("Anasali","Anas321").contains("Invalid Login"));
	  
}
 
@Test(priority=3)
public void CorrectCredentialsTest() {
	 Assert.assertTrue(appObject.CorrectCredentials("Anasali","Anas@321#").isloginpage());

}
@BeforeClass
public void launchBrowserTest() {
	appObject.launchBrowser();
}

@AfterClass
public void closeBrowserTest() throws InterruptedException {
	appObject.closeBrowser();
}
}
