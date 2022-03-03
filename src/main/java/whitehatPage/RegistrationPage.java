package whitehatPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import whitehatBase.WhitehatBase;

public class RegistrationPage extends WhitehatBase {
	

	@FindBy(className = "pr-2")
	WebElement logo;
	
	@FindBy(xpath = "//input[@id='email' and @name='email']")
	WebElement emailID;
	
	@FindBy(css =  "input[id='parentName'][name='parentName']")
	WebElement parentName;
	
	@FindBy(name = "mobile")
	WebElement mobileNumber;
	
	@FindBy(id = "studentName")
	WebElement studentName ;
	
	@FindBy(name = "isLaptop")
	WebElement isLaptop ;
	
	public RegistrationPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean getLogo()
	{
		boolean flag = logo.isDisplayed();
		return flag;
	
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void enterDetails(String email, String pName, String mobNumber, String cldName)
	{	
		emailID.sendKeys(email);
		parentName.sendKeys(pName);
		mobileNumber.sendKeys(mobNumber);
		studentName.sendKeys(cldName);
		isLaptop.click();
		
		driver.findElement(By.className("jss176")).click();
		
	}
	
	public void closedApp()
	{
		driver.quit();
	}
	
}
