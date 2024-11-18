package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	//define repository
		@FindBy(name="txtUsername")
		WebElement Objuser;
		@FindBy(xpath="//input[@id='txtPassword']")
		WebElement Objpass;
		@FindBy(id="btnLogin")
		WebElement ObjLogin;
		
		//write method for login
		public void verifyLogin(String username,String password)
		{
			Objuser.sendKeys(username);
			Objpass.sendKeys(password);
			ObjLogin.click();
		}
		
}
