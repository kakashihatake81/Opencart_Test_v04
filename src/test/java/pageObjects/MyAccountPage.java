package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")	// my account page heading
	WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public void clickLogout()
	{
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).perform();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
	}
	
	public boolean ismyAccountPageExist()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
