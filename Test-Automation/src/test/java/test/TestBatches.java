package test;


import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.junit.After;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import appliutilities.DriverSetUp;



public class TestBatches
{
	TestCases test;
	public static ExtentReports extent;
	public static ExtentTest  parent;
	String root;
	
//	@Parameters("BrowserName")
//	@BeforeTest
	public TestBatches() 
	{
		
		DriverSetUp ds = new DriverSetUp();
		WebDriver driver = ds.getLocalDriver();
		 test = new TestCases(driver);
	
			int ran = new Random().nextInt(9999);
			try {
				 root = new File(".").getCanonicalPath();
				 System.out.println("my root directory"+root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 extent = new ExtentReports(root+"\\Reports\\Test-Automation-"+ran+".html");
	     parent = extent.startTest("SMOKE");
		
		
	}
	
	
@Test
	public void TestBatch1() 

	{

		test.PostiveLoginAndVerify();
		test.NegativePasswordandVerify();
		test.LaunchAppleAndGetDetails();
		
		
	}
	
	@Test
	public void TestBatch2()
	{
		test.PostiveLoginAndVerify();
		test.NegativeUsernameAndVerify();
		test.LaunchAppleAndGetDetails();
	}
	
	@Test
	public void TestBatch3()
	{
		test.PostiveLoginAndVerify();
		test.NegativeUsernameAndVerify();
		test.NegativePasswordandVerify();
		test.LaunchAppleAndGetDetails();
	}
	
	
	
	@AfterTest
	public void quitm()
	{
		extent.endTest(parent);
		
		extent.flush();
	}
	
	
	

}
