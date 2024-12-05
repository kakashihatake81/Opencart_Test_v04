package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_048_AccountRegTest extends BaseClass {
	
	@Test(groups = {"regression","master"})
	public void verify_account_reg() throws Exception
	{
		logger.info("*****Starting TC048_account_registration_test****");
		
		HomePage hp = new HomePage(driver);
		
		try {
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		hp.clickRegister();
		logger.info("Clicked on register");
		AccountRegistrationPage rpage = new AccountRegistrationPage(driver);
		
		logger.info("Filling user info ");
		rpage.setFirstName(randomString().toUpperCase());
		rpage.setLastName(randomString().toUpperCase());
		rpage.setEmail(randomString()+"@gmail.com");
		//rpage.setTelephone("4564645654");
		rpage.setPassword(randomAlphaNumeric());
		//rpage.setConfirmPassword("john");
		//Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).perform();
		rpage.setPrivacyPolicy();
		//Thread.sleep(3000);
		//Actions actions = new Actions(driver);
		//actions.keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).perform();
		//Thread.sleep(3000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // you will have to manually scroll page if this command isn't working / there is something wrong with opencart website while executing js script, in order to pass the test you'll have to manually scroll down to page then only it'll click 

		rpage.clickContinue();	
		
		
		logger.info("validating confirmation message");
		String cnfmsg = rpage.getConfirmationMsg();
		//Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		
		if (cnfmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			//logger.error("Test failed");
			//logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("*****Finished TC048_account_registration_test****");
	}
}
