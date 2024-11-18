package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationLayer.AdminLogin;
import applicationLayer.AdminLogout;

public class Base {
public static WebDriver driver;
@BeforeTest
public static void setUp()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	AdminLogin login = PageFactory.initElements(driver, AdminLogin.class);
	login.verifyLogin("Admin", "Qedge123!@#");
}
	
@AfterTest
public static void tearDown() throws Throwable
{
	AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
	logout.verifyLogout();
	driver.quit();
	
}
}
