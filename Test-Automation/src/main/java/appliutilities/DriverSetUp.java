package appliutilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import gUtilities.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
    
	ReadProperties config;
	WebDriver driver;
	DesiredCapabilities capabilities;

	public DriverSetUp(){
		
		config = new ReadProperties("Test-Data/PositiveLogin.properties");
		 capabilities = new DesiredCapabilities();
		
		
	}

	public WebDriver getDriver()
	{
		if(config.readData("ExecutionType").equalsIgnoreCase("LOCAL")){
			getLocalDriver();
			
		}
		else if(config.readData("ExecutionType").equalsIgnoreCase("Remote")) {
			getRemoteDriver();
			
		}
		else {
			System.out.println("given execution is not supported"+config.readData("ExecutionType").toUpperCase());
				
		}
		return driver;
	}
	URL url;

	public WebDriver getRemoteDriver() {
		MutableCapabilities sauseOptions = new MutableCapabilities();
		try {
			url = new URL(config.readData("SAUSELABURL"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, config.readData("Browser"));
		capabilities.setCapability(CapabilityType.VERSION, config.readData("BrowserVersion"));
		capabilities.setCapability("name", config.readData("ApplicationName"));
		capabilities.setCapability("screen-resolution", config.readData("ScreenResolution"));
		capabilities.setCapability(CapabilityType.PLATFORM, config.readData("OS"));
		capabilities.setCapability("accessKey", config.readData("SauseLabsAccessKey"));
		capabilities.setCapability("username", config.readData("SauseLabsUserName"));
		sauseOptions.setCapability("name", config.readData("Sausename"));




		


		driver = new RemoteWebDriver(url,capabilities);
		return driver;
	}
	
    
	
   //  @Parameters("Browser")
	public WebDriver getLocalDriver() {
		if(config.readData("Browser").equalsIgnoreCase("CHROME")){
			  WebDriverManager.chromedriver().setup();
			     driver = new ChromeDriver();
			
		}
		else if(config.readData("Browser").equalsIgnoreCase("MSEDGE")) {
			
			System.setProperty("webdriver.msedge.driver", "C:\\driver\\edge.exe");

			driver = new EdgeDriver();
					
		}
		
		else {
			if(config.readData("Browser").equalsIgnoreCase("CHROME")){
				System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

				driver = new ChromeDriver();
				
			}
			
			
		}
		return driver;
	}
     
     
 	public WebDriver getLocalDriver2(String Browser) {
 		if(Browser.equalsIgnoreCase("CHROME")){
 			  WebDriverManager.chromedriver().setup();
 			     driver = new ChromeDriver();
 			
 		}
 		else if(Browser.equalsIgnoreCase("MSEDGE")) {
 			
            WebDriverManager.edgedriver().setup();
 			driver = new EdgeDriver();
 					
 		}
 		
 		else {
 			if(Browser.equalsIgnoreCase("CHROME")){
 				System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

 				driver = new ChromeDriver();
 				
 			}
 			
 			
 		}
 		return driver;
 	}
	
	public WebDriver GridDriver()
	{
		
		capabilities.setBrowserName("chrome");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
		
	}
	
	public WebDriver GridFactory() 
	{
		
		
		if(config.readData("Browser").equalsIgnoreCase("CHROME")){
			
			capabilities.setBrowserName("chrome");
		}
		else if(config.readData("Browser").equalsIgnoreCase("MSEDGE")) {
			
			capabilities.setBrowserName("msedge");
					
		}
		
		else {
			if(config.readData("Browser").equalsIgnoreCase("CHROME")){
				capabilities.setBrowserName("chrome");
				
			}
			
			
		}
		
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return driver;
		
	}
	
	public WebDriver PlatForm()
	{

		if(config.readData("Platform").equalsIgnoreCase("WIN10")){
			
			capabilities.setPlatform(Platform.WIN10);
			capabilities.setBrowserName("chrome");
		}
		else if(config.readData("Browser").equalsIgnoreCase("MAC")) {
			
			capabilities.setPlatform(Platform.MAC);
			capabilities.setBrowserName("msedge");
			
					
		}
		
		else {
			if(config.readData("Browser").equalsIgnoreCase("CHROME")){
				capabilities.setPlatform(Platform.WIN10);
				capabilities.setBrowserName("chrome");
				
				
			}
			
			
		}
		
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return driver;
		
	}
	
	
	

}
