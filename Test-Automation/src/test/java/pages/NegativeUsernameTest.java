package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import appliutilities.DriverSetUp;
import gUtilities.ReadProperties;
import junit.framework.Assert;

public class NegativeUsernameTest
{
	WebDriver driver;
	ReadProperties read;
	BasePageObject bs;
	Actions ac;
	public NegativeUsernameTest(WebDriver driver) 
	{
		this.driver = driver;
		
		    read = new ReadProperties("Test-Data/NegativeUsername.properties");
			 bs = new BasePageObject(driver);
			 driver.manage().window().maximize();
			  ac = new Actions(driver);
		
	}
	


	@Before
	public boolean NegativeUsernameLogin()
	{
		
	bs.openUrl(read.readData("URL"));
	bs.find(PositiveLoginTest.usernameLocator).sendKeys(read.readData("username"));
	bs.find(PositiveLoginTest.passwordLocator).sendKeys(read.readData("password"));
	bs.find(PositiveLoginTest.submitButtonLocator).click();	
	ac.moveToElement(bs.find(PositiveLoginTest.errorMessageLocator)).perform();
	return true;
	
	}
	
	@Test
	public boolean VerifyNegativeusernameLogin() 
	{
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement error = bs.find(PositiveLoginTest.errorMessageLocator);
		String expectedText = error.getText();
		Assert.assertEquals(expectedText, "Your username is invalid!");
		System.out.println("assertion complete");
		return true;
		
		
	}

}
