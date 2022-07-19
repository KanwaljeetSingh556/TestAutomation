package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import appliutilities.DriverSetUp;
import gUtilities.ReadProperties;
import junit.framework.Assert;

public class Apple 
{
	WebDriver driver;
	ReadProperties rd;
	BasePageObject bp;
	Actions ac;
	public Apple(WebDriver driver) 
	{

		this.driver = driver;
		rd = new ReadProperties("Test-Data/Apple.properties");
		 bp = new BasePageObject(driver);
		 driver.manage().window().maximize();
		 ac = new Actions(driver);
		
	}
	
	@Before
	public boolean LaunchAppleAndSearch() 
	{
		bp.openUrl(rd.readData("URL"));
		bp.click(By.cssSelector("a#ac-gn-link-search"));
		bp.find(By.cssSelector("input#ac-gn-searchform-input")).sendKeys(rd.readData("search"),Keys.ENTER);
		String ExpectedTittle = "iphone 12 - Apple (IN)";
		Assert.assertEquals(ExpectedTittle,driver.getTitle());
		System.out.println("Assert Complete");
		return true;
		
		
	}
	@Test
	public boolean getDetails() 
	{
		String ExpectedTittle = "iPhone 12 and iPhone 12 mini Key Features - Apple (IN)";
		bp.click(By.linkText("iPhone 12 and iPhone 12 mini"));
		WebElement head = bp.find(By.xpath("//h2[.='Blast past fast.']"));
		if(head.isDisplayed()) 
		{
			Assert.assertEquals(ExpectedTittle,driver.getTitle());
		String source = driver.getPageSource();
		//System.out.println(source);
	//	driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ac.moveToElement(bp.find(By.xpath("//a[contains(@class,'hero-button')]"))).perform();
		ac.moveToElement(bp.find(By.xpath("//a[@data-analytics-title='buy - iphone 12']"))).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bp.click(By.xpath("//a[@data-analytics-title='buy - iphone 12']"));
		
		
			
		}
		
		String ExpectedTittle2 = "Buy iPhone 12 and iPhone 12 mini Unlocked - Apple (IN)";
		Assert.assertEquals(ExpectedTittle2,driver.getTitle());
		System.out.println("Assertion  Completed");
		return true;
		
		
		
    }

}
