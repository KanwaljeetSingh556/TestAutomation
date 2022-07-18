package pages;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import appliutilities.DriverSetUp;
import gUtilities.ReadProperties;
import junit.framework.Assert;

public class PositiveLoginTest
{
	WebDriver driver;
	ReadProperties read;
	BasePageObject bs;
	static By usernameLocator = By.id("username");
	static By passwordLocator = By.id("password");
	static By submitButtonLocator = By.id("submit");
	static By errorMessageLocator = By.id("error");


	
	public PositiveLoginTest(WebDriver driver)
	
	{
		this.driver = driver;
		
		
	    read = new ReadProperties("Test-Data/PositiveLogin.properties");
		 bs = new BasePageObject(driver);
	 driver.manage().window().maximize();
	}
	
	



	@Before
	public boolean PositiveLogin()
	{
	bs.openUrl(read.readData("URL"));
	bs.find(usernameLocator).sendKeys(read.readData("username"));
	bs.find(passwordLocator).sendKeys(read.readData("password"));
	bs.find(submitButtonLocator).click();	
	return true;
	}
	
	@Test
	public boolean VerifyPositiveLogin() 
	{
		WebElement LogoutLocator = bs.find(By.linkText("Log out"));
		 WebElement verify  =  bs.find(By.xpath("//strong")); 
		
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	        String tittle = driver.getTitle();
	       Assert.assertEquals(tittle, "Logged In Successfully | Practice Test Automation");
	       boolean yes =  LogoutLocator.isDisplayed();
	       Assert.assertEquals(yes, true);
	      String actualText = verify.getText();
	      
	      Assert.assertEquals(actualText, "Congratulations student. You successfully logged in!");
	      System.out.println("AssertionComplete");
	      
	      bs.click(By.linkText("Log out"));
	      
	      return true;
	      
	      
	       
       
	   	
		
	}

}
