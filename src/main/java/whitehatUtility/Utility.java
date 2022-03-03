package whitehatUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class Utility {

	public static int Page_Load_Time_Out =30;
	public static int Implicit_Time_Out =30;
	
	public void takeSS(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot tc = (TakesScreenshot)driver;
		File file = tc.getScreenshotAs(OutputType.FILE);
		Files.move(file, new File("C:\\Users\\Bhushan\\eclipse-workspace\\CucumberPOM\\screenshot\\"  +name +".png"));
	}
	
	public void reportGeneration(ITestResult result) throws IOException 
	{
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("C:\\Users\\Bhushan\\eclipse-workspace\\CucumberPOM\\reports\\CucumberReport.html");
		ExtentReports report = new ExtentReports();
		ExtentTest test;
		report.attachReporter(htmlReport);
		
		test = report.createTest("Cucumber white hat report");
		
		if(ITestResult.SUCCESS == result.getStatus())
		{
			test.log(Status.PASS, MarkupHelper.createLabel("Test case is Passed", ExtentColor.GREEN));
		}
		
		else if(ITestResult.FAILURE == result.getStatus())
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("Test case is Failed", ExtentColor.RED));
			test.fail(result.getThrowable());	
		}
		else if(ITestResult.SKIP == result.getStatus())
		{
			test.log(Status.SKIP, MarkupHelper.createLabel("Test case is SKIP", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		report.flush();
	}
}
