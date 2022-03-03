package whitehatBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import whitehatUtility.Utility;

public class WhitehatBase {

	public static WebDriver driver;
	public static Properties pro;
	public static FileInputStream profileInput;

	public WhitehatBase() throws IOException
	{
		pro = new Properties();
		profileInput = new FileInputStream("C:\\Users\\Bhushan\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\whitehatUtility\\whitehat.properties");
		pro.load(profileInput);
	}

	public static void driverSetup()
	{
		String proData = pro.getProperty("browser");
		
		if(proData.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(proData.equalsIgnoreCase("IE"))
		{
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");
			System.setProperty("webdriver.ie.driver", "C:\\Automation\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("No browser found as requested...");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utility.Page_Load_Time_Out, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_Time_Out, TimeUnit.SECONDS);

	}
	
	
}
