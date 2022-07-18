
	package test;

	import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Apple;
import pages.NegativePasswordTest;
	import pages.NegativeUsernameTest;
	import pages.PositiveLoginTest;

	

	public class TestCases
	{
		WebDriver driver;
		PositiveLoginTest ps;
		NegativeUsernameTest  nu;
		NegativePasswordTest np;
		ExtentTest child ;
		Apple ap;
		
		public void logReport(boolean flag,String stepName) 
		{
			if(flag) {
				child.log(LogStatus.PASS, stepName,"success");
			}
			else 
			{
				child.log(LogStatus.FAIL,child.addScreenCapture(TakeErrorScreenshot(stepName)) ,stepName);
				
				
			}
			
		}
		String screenshotFilePath;
		
		public String TakeErrorScreenshot(String fName) {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				screenshotFilePath = new File(".").getCanonicalPath()+"\\Screenshots\\"+fName+ new Random().nextInt(999)+"png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				FileUtils.copyFile(scrFile,new File(screenshotFilePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scrFile = null;
			return screenshotFilePath;
			
					
		}
		
		public TestCases(WebDriver driver)
		{
			this.driver = driver;
			ps = new PositiveLoginTest(driver);
			nu = new NegativeUsernameTest(driver);
			np = new NegativePasswordTest(driver);
			 ap = new Apple(driver);
		}
		
		
		public void PostiveLoginAndVerify()
		{
			child = TestBatches.extent.startTest("PostiveLoginAndVerify");
			TestBatches.parent.appendChild(child);
			System.out.println("Test Case: PostiveLoginAndVerify ");
		   logReport(ps.PositiveLogin(),"Positivelogin");
			logReport(ps.VerifyPositiveLogin(),"verifyPositiveLogin");
			
			
		}
		
		
		public void NegativePasswordandVerify() 
		{
			child = TestBatches.extent.startTest("NegativePasswordandVerify");
			TestBatches.parent.appendChild(child);
			logReport(np.NegativePasswordLogin(),"NegativePasswordLogin");
			logReport(np.VerifyNegativePasswordLogin(),"VerifyNegativePasswordLogin");
			
		}
		
		public void NegativeUsernameAndVerify() 
		{
			child = TestBatches.extent.startTest("NegativeUsernameAndVerify");
			TestBatches.parent.appendChild(child);
			logReport(nu.NegativeUsernameLogin(),"NegativeUsernameLogin");
			logReport(nu.VerifyNegativeusernameLogin(),"VerifyNegativeusernameLogin");
			
		}
		
		public void LaunchAppleAndGetDetails()
		{
			child = TestBatches.extent.startTest("LaunchAppleAndGetDetails");
			TestBatches.parent.appendChild(child);
			logReport(ap.LaunchAppleAndSearch(),"LaunchAppleAndSearch");
			logReport(ap.getDetails(),"getDetails");
			
			
		}


		

		
		
		
		

	}



