package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostoxPropertiesUtility.Utilitynew;
//import neoStoxExcelUtility.Utility;

public class NeoStoxHomePage 
{
  
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id="lbl_username") private WebElement userName;
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	
	
	public NeoStoxHomePage(WebDriver driver)  //constructor name
	{
		
		
		
	PageFactory.initElements(driver, this);
	
	}
	
	public void handlePopUp(WebDriver driver) throws InterruptedException 
	{
		
		if(okButton.isDisplayed())
		
		{
			
		Utilitynew.wait(driver, 4000);
		okButton.click();
		Reporter.log("Handeling popup",true);
		Reporter.log("clicking on OK button of Popup", true);
		Utilitynew.wait(driver, 1000);
		closeButton.click();
		Reporter.log("clicking on Close button of Popup", true);
		
		}
		
		else
		
		{
			
		Reporter.log("there is no Popup", true);
		Thread.sleep(3000);
		
		
		}
//		
//	Utility.wait(driver, 6000);
//	okButton.click();
//	Reporter.log("clciking on OK button of Popup", true);
//	
//	Utility.wait(driver, 6000);
//
//	closeButton.click();
//	Reporter.log("clciking on Close button of Popup", true);
//	
	}
	
	
	public String getActualUserName(WebDriver driver) //string to return value so we not gives ->void
	
	{
		
	Utilitynew.wait(driver, 2000);
	
	String actualUserName = userName.getText();
	
	Reporter.log("getting actual user name",true);
	
	String realUserName = actualUserName.substring(3);//subString used for cut 3 Letters
	                                                  //hi shilpa //output is =>shilpa->cut h i and 1 space
	Reporter.log("Actual user name is "+realUserName, true);
	
	return actualUserName;
	
	}
	
	public String getAccBalance(WebDriver driver)
	
	{
		
		
	Utilitynew.wait(driver, 2000);
	
	String accBalance = acBalance.getText();
	
	Reporter.log("getting accBalance ", true);
	
	Reporter.log("Account Balance is "+accBalance,true);
	
	return accBalance;
	
	
	}
	
	public void logOut(WebDriver driver)
	{
		
	Utilitynew.wait(driver, 3000);
	
	userName.click();
	
	Utilitynew.wait(driver, 4000);
	
	logOutButton.click();
	
	Reporter.log("Logging out", true);
	
	}
}
