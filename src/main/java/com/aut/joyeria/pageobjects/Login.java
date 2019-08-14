package com.aut.joyeria.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	private By txtUser;
	private By txtPass;
	private By btnLogin;
	private By lnkOlvidePass;
	private By chkRecordarme;
	private By loginResultPass;
	private By loginResultFail;
	private By lnkLogOff;
	private WebDriver driver;
	
	
	public Login(WebDriver driver){
		this.driver = driver;
		txtUser = By.id("username");
		txtPass = By.id("password");
		btnLogin = By.name("login");
		lnkOlvidePass = By.xpath("//*[@id=\"blog\"]/div/div[4]/article/div[2]/div[1]/div/form/p[4]/a");
		loginResultPass = By.xpath("//*[@id=\"blog\"]/div/div[4]/article/div[2]/div[1]/div/div/p[1]/strong");
		loginResultFail = By.xpath("//*[@id=\"blog\"]/div/div[4]/article/div[2]/div[1]/div/ul/li/strong");		
		chkRecordarme = By.id("rememberme");
		lnkLogOff = By.xpath("//*[@id=\"blog\"]/div/div[4]/article/div[2]/div[1]/div/nav/ul/li[6]/a");
	}

	public void login(String user, String password) {
		driver.findElement(txtUser).sendKeys(user);
		driver.findElement(txtPass).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
	public void login(String user, String password, boolean rememberme) {
		driver.findElement(txtUser).sendKeys(user);
		driver.findElement(txtPass).sendKeys(password);
		driver.findElement(chkRecordarme).click();
		driver.findElement(btnLogin).click();		
	}
	
	public void olvidePassword() {
		driver.findElement(lnkOlvidePass).click();
	}
	
	public boolean loginVerificationPass() {
		try{
		if(driver.findElement(loginResultPass).getText().contains("John Due"))
			return true;
		else
			return false;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean loginVerificationFail() {
		if(driver.findElement(loginResultFail).getText().contains("Error"))
			return false;
		else
			return true;
	}
	
	public void logOff() {
	//	if (loginVerificationPass()) {
			//driver.findElement(By.xpath("//*[@id=\"blog\"]/div/div[1]/div[1]/a")).click();
			driver.navigate().to("http://companymx.com/coral/mi-cuenta/customer-logout/");
			//driver.findElement(lnkLogOff).click();
		//}
	}
}
