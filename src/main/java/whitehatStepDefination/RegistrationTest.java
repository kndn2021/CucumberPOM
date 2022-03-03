package whitehatStepDefination;

import java.io.IOException;

import org.junit.Assert;
import org.testng.ITestResult;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import whitehatBase.WhitehatBase;
import whitehatPage.RegistrationPage;
import whitehatUtility.Utility;

public class RegistrationTest extends WhitehatBase {

	RegistrationPage regiPage;
	Utility util;
	
	public RegistrationTest() throws IOException 
	{
		super();
	}

	@Given("^application is initialized$")
	public void application_is_initialized() throws IOException
	{
		WhitehatBase.driverSetup();
		regiPage = new RegistrationPage();
		util = new Utility();
	}

	@When("^open website$")
	public void open_website()
	{
		driver.get(pro.getProperty("url"));
	}

	@Then("^logo gets verified$")
	public void logo_gets_verified() throws IOException
	{
		boolean logoFlag= regiPage.getLogo();

		Assert.assertTrue(logoFlag);
		util.takeSS(driver, "Logo");
		System.out.println("The status of logo : " +logoFlag);
	}

	@Then("^title gets verified$")
	public void title_gets_verified() throws IOException
	{
		String title = regiPage.getTitle();
		Assert.assertEquals("WhiteHat Junior", title);
		util.takeSS(driver, "Title");
		System.out.println(title);
	}
	
	@Then("^enter \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" details$")
	public void enter_details(String emailId, String parentName, String mobileNumber, String childName) throws IOException
	{
		regiPage.enterDetails(emailId, parentName, mobileNumber, childName);
		util.takeSS(driver, "details");
	}

	@Then("^application getting closed$")
	public void application_getting_closed(ITestResult result) throws IOException
	{
		util.reportGeneration(result);
		regiPage.closedApp();
		
	}

}
