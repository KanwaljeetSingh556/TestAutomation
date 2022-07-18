package appliutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ApplicationUtilities {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	
	
	public ApplicationUtilities(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		this.driver = driver;
		actions = new Actions(driver);
		js = (JavascriptExecutor)driver;
	}
	
	public WebElement getElement(String myxpath) {
		if(driver.findElement(By.xpath(myxpath)).isEnabled()) {
			System.out.println("Element is Enabled,xpath" +myxpath);
			return driver.findElement(By.xpath(myxpath));
		}
		else {
			System.out.println("element is not enabled,xpath" +myxpath);
			return null;
		}
	}
	
	public WebElement getElement(String myxpath,String Elementname) {
		if(driver.findElement(By.xpath(myxpath)).isEnabled()) {
			System.out.println("Element is Enabled," +Elementname);
			return driver.findElement(By.xpath(myxpath));
		}
		else {
			System.out.println("element is not enabled,xpath" +Elementname);
			return null;
		}
		
		
	}
	public void actionsWait(int timeInSec) {
		actions.pause(timeInSec * 1000).perform();
	}
	public void scrollToElement(WebElement element) {
		actions.moveToElement(element).perform();
	}
	public void Mousehover(WebElement element) {
		actions.moveToElement(element).perform();
	}
	
	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click", element);
	}
	public void asclick(WebElement element) {
		actions.click(element).perform();
	}
	public void clickEnter() {
		actions.sendKeys(Keys.ENTER).perform();
	}
	public void clickTab() {
		actions.sendKeys(Keys.TAB).perform();
	}
	


	
}
