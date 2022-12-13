package neostoxlistener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.BaseNew;
import neostoxPropertiesUtility.Utilitynew;

public class Listener extends BaseNew implements ITestListener
	{
	
	 public void onTestSuccess(ITestResult result)
	 {
		 String methodName = result.getName();
         Reporter.log("TC "+methodName+" is completed successfuly",true);
			
		}


 public void onTestFailure(ITestResult result)
	
     {
	   Reporter.log("TC "+result.getName()+ " is failed",true);
	   
	 try
	 
	 {
		   
		Utilitynew.screenshot(driver,result.getName());
		
	   }
	 
  catch (IOException e) 
	 
	{
	  
		   e.printStackTrace();
		// TODO: handle exception
		   
	}
	  
	}

	public void onTestSkipped(ITestResult result)
	{
		
	  Reporter.log("TC "+result.getName()+" is skipped please check",true);
	
	
	}

}
