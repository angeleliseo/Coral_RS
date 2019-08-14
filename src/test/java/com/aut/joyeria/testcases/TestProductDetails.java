package com.aut.joyeria.testcases;
import com.aut.joyeria.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class TestProductDetails extends BaseTest {

	private static WebDriver driver;
	TestProductDetails (){
		super(driver);
	}
	
	@Test(priority = 0)
	public void addOneToCart() throws InterruptedException {
		HomePage home = new HomePage(super.driver);
		Login login = new Login(super.driver);
		ProductDetails pd = new ProductDetails(super.driver);
		
		home.goToHome();
		home.goToLogin();
		login.login("john_due", "P@$$w0rd");
		Assert.assertTrue(login.loginVerificationPass());
		
		pd.setProducto("collar", new MainMenu(super.driver));
		pd.añadirAlCarro(1);
		Assert.assertTrue(pd.addToCartVerify());
		//login.logOff();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void clean() {
		Login login = new Login(super.driver);
		login.logOff();
	}
	@Test(priority = 1)
	public void addDifferentProductToCart() {
		HomePage home = new HomePage(super.driver);
		Login login = new Login(super.driver);
		ProductDetails pd = new ProductDetails(super.driver);
		
		home.goToHome();
		home.goToLogin();
		login.login("john_due", "P@$$w0rd");
		Assert.assertTrue(login.loginVerificationPass());
		
		pd.setProducto("aretes", new MainMenu(super.driver));
		pd.añadirAlCarro(1);
		Assert.assertTrue(pd.addToCartVerify());
	}
	
	@Test (priority = 2)
	public void addMoreThanOneToCart() {
		HomePage home = new HomePage(super.driver);
		Login login = new Login(super.driver);
		ProductDetails pd = new ProductDetails(super.driver);
		
		home.goToHome();
		home.goToLogin();
		login.login("john_due", "P@$$w0rd");
		Assert.assertTrue(login.loginVerificationPass());
		
		pd.setProducto("aretes", new MainMenu(super.driver));
		pd.añadirAlCarro(4);
		Assert.assertTrue(pd.addToCartVerifySeveral());
	}
}
