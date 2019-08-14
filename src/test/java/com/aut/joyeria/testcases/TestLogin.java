package com.aut.joyeria.testcases;
import com.aut.joyeria.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
/*
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.MainMenu;
*/

public class TestLogin extends BaseTest {
	private static WebDriver driver;
	TestLogin(){
		super(driver);
	}
	
	@Test (priority = 0)
	public void testLoginSuccessCase() throws InterruptedException {		
		HomePage home = new HomePage(super.driver);
		MainMenu menu = new MainMenu(super.driver);
		Login login = new Login(super.driver);
		home.goToHome();
		menu = home.goToLogin();
		menu.clickLogin();
		login.login("john_due", "P@$$w0rd");
		Assert.assertTrue(login.loginVerificationPass());	
		Thread.sleep(5000);
	}
	@AfterMethod
	public void clean() {
		Login login = new Login(super.driver);
		login.logOff();
	}
	@Test(priority = 1)
	public void testLoginEmpty() {
		HomePage home = new HomePage(super.driver);
		MainMenu menu = new MainMenu(super.driver);
		Login login = new Login(super.driver);
		home.goToHome();
		menu = home.goToLogin();
		menu.clickLogin();
		login.login("", "");
		Assert.assertFalse(login.loginVerificationFail());		
	}
	@Test(priority = 2)
	public void testLoginBadAccount() {
		HomePage home = new HomePage(super.driver);
		MainMenu menu = new MainMenu(super.driver);
		Login login = new Login(super.driver);
		home.goToHome();
		menu = home.goToLogin();
		menu.clickLogin();
		login.login("john_due", "fail");
		Assert.assertFalse(login.loginVerificationPass());
	}
}
