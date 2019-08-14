package com.aut.joyeria.pageobjects;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private String baseURL;
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		baseURL = "http://companymx.com/coral/";
	}
	
	public void goToHome() {
		driver.get(baseURL);
	}
	
	public MainMenu goToLogin() {
		MainMenu menu = new MainMenu(this.driver);
		menu.clickLogin();
		return menu;
	}
}
