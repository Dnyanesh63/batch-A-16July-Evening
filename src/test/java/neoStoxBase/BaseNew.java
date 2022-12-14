package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neostoxPropertiesUtility.Utilitynew;

public class BaseNew 
{

	
	protected static WebDriver driver;
	
	public void launchBrowser() throws InterruptedException, IOException
	{
	   System.setProperty("webdriver.chrome.driver","D:\\16 July evening Batch\\chromedriver.exe");
	 
      driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(Utilitynew.readDataFrompropertyFile("url"));
	  Reporter.log("Launching browser", true);
	  Thread.sleep(2000);
	
	}
}
