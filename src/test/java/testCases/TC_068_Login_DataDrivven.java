package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_068_Login_DataDrivven extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups ={"datadriven","master"}) // getting data provider from different class
	public void verify_login_DDT(String email, String pass, String exp)
	{
			
		
			logger.info("******Starting TC_068_login data driven Test****");
		
			try {
			//Homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
				
			//login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pass);
			lp.clickLogin();
				
			//My account page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.ismyAccountPageExist();
			
		/*
		 	Data is valid - login success - test pass - logout 
		 	Data is valid - login failed - test failed 
		 	
		 	Data is invalid - login success test fail - logout 
		 	Data is invalid - login failed - test pass 
		 */
			
			if(exp.equalsIgnoreCase("valid"))
			{
				if(targetPage=true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("invalid"))
			{
				if (targetPage=true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			
			logger.info("******Completed TC_068_login data driven Test****");
				
	}

}
