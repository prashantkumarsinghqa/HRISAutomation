package com.qait.HRIS.hrisautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPanel{
	static WebDriver driver;

	private WebElement GetUsernameEntry() 
	{
		return LoginPanel.driver.findElement(By.cssSelector("input[id='txtUserName']"));
	}
	private WebElement GetPasswordEntry()
	{
		return LoginPanel.driver.findElement(By.cssSelector("input[id='txtPassword']"));
	}
	private WebElement GetErrorMessage() {
		driver.findElement(By.cssSelector(".alert-error"));
    return null;	 
	}
	public void Fillcredentials(String username,String password)
	{
		System.out.println(username);
		System.out.println(password);
		
		GetUsernameEntry().sendKeys(username);
		GetPasswordEntry().sendKeys(password);
		driver.findElement(By.cssSelector("input[name='Submit']")).click();
	}
	
	public String NoPassword(String username ,String password) {
	    Fillcredentials(username,password);
		return driver.findElement(By.cssSelector("input[name='txtPassword']")).getAttribute("class");

	}
	public String WrongPassword(String username ,String password)
	{
		Fillcredentials(username,password);
		return GetErrorMessage().getText();
	}

	public TestTimesheet CorrectCredentials(String username, String password) {
		Fillcredentials(username,password);
		return new TestTimesheet(driver);
	}
	public Boolean isPasswordEntryAnnotated(){
	    return GetPasswordEntry().getAttribute("style").contains("red");
	}
	public void launchBrowser() {
		System.out.println("Driver in -->");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prashantkumarsingh\\eclipse-workspace\\hrisautomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		

	    if(driver.findElement(By.cssSelector("a[href='#panel4']")).isSelected())
	    {
	    driver.findElement(By.cssSelector("a[href='#panel1']")).click();	
	    }
	    else
	    {
	    	driver.findElement(By.cssSelector("a[href='#panel1']")).click();
	    }
	    }
	public void closeBrowser() throws InterruptedException {
		driver.quit();
		Thread.sleep(10000);		
	}
	   
	}
	
	