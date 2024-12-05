package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super (driver);
	}
	
	
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement LnkMyAccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement LnkRegister;

@FindBy(linkText = "Login")
WebElement lnkLogin;


public void clickMyAccount()
{
	LnkMyAccount.click();
}

public void clickRegister()
{
	LnkRegister.click();
}

public void clickLogin()
{
	lnkLogin.click();
}

}
