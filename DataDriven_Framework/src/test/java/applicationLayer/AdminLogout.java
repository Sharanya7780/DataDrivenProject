package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
	@FindBy(xpath="//a[@id='welcome']")
	WebElement clickWelcome;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement clickLgout;
	public void verifyLogout()throws Throwable
	{
		clickWelcome.click();
		clickLgout.click();
	}
}



