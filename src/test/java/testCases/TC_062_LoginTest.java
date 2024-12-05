package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_062_LoginTest extends BaseClass {
	
	
	@Test(groups = {"sanity","master"})
	
	public void verify_login()
	{
		logger.info("*****Starting TC_062_loginTest***");
		
		try
		{
		//Homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My account page
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.ismyAccountPageExist();
		
		
		//Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC_062_loginTest***");
		
		
	}

}
