package neostoxListener_TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.BaseNew;
import neoStoxPomClasses.NeoStoxHomePage;
import neoStoxPomClasses.NeoStoxLoginPage;
//import neoStoxExcelUtility.Utility;
//import neoStoxPOMclasses.NeoStoxHomePage;
//import neoStoxPOMclasses.NeoStoxLoginPage;
//import neoStoxPOMclasses.NeoStoxPasswordPage;
//import neoStoxPOMclasses.NeoStoxSignInPage;
//import neostoxPropertiesUtility.Utilitynew;
import neoStoxPomClasses.NeoStoxPasswordPage;
import neoStoxPomClasses.NeoStoxSignInPage;
import neostoxPropertiesUtility.Utilitynew;

@Listeners(neostoxlistener.Listener.class) //listnerpackagename plus Listener->class name and .class (extension)

public class ValidateNeoStoxAccBalanceANDUserName2Using_properties extends BaseNew
{
	
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	
	@BeforeClass
	public void launchNeoStox() throws InterruptedException, IOException
	
	{
		
	  launchBrowser();//form base class
	  login= new NeoStoxLoginPage(driver);
	  password= new NeoStoxPasswordPage(driver);
	  home= new NeoStoxHomePage(driver);
	  signIn= new NeoStoxSignInPage(driver);
	
	}
	
	@BeforeMethod
	public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	
	{
		
		
	  signIn.clickOnSignInButton(driver);
	  Thread.sleep(6000);
	  login.sendMobileNum(driver, Utilitynew.readDataFrompropertyFile("mobileNum"));
	  login.clickOnSignInButton(driver);
	  Utilitynew.wait(driver, 9000);
	  password.enterPassword(driver,Utilitynew.readDataFrompropertyFile("password"));
	  Thread.sleep(9000);
	  password.clickOnSubmitButton(driver);
	  Thread.sleep(9000);
	  home.handlePopUp(driver);
	
	}
	
	@Test
	public void validateAccBalance() throws EncryptedDocumentException, IOException
	
	{
		
	Assert.assertNotNull(home.getAccBalance(driver),"TC failed Unable to fetch account Balance");
	                          //Utilitynew.screenshot(driver, "ACCBalance");
	
	  Assert.fail();  //TC fail 
	
	} 
	
	@Test(priority = -1)
	public void validateUserID() throws EncryptedDocumentException, IOException
	
	{
		
	  Assert.assertEquals(home.getActualUserName(driver), Utilitynew.readDataFrompropertyFile("userName"),"TC is failed Actual and expected User Name are not matching");
                               // Utilitynew.screenshot(driver, home.getActualUserName(driver));//i dont want to screenshot this TC
	
	}
	
	@AfterMethod
	public void logOutFromNeoStox()
	
	{
		
	home.logOut(driver);
	
	}
	@AfterClass
	public void closeBrowser()
	
	{
		
	Reporter.log("closing browser", true);
	//driver.close();
	
	}
	
 }
