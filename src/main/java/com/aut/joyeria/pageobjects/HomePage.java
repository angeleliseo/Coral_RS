package com.aut.joyeria.pageobjects;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;

public class HomePage {

	private String baseURL;
	private WebClient driver;
	public HomePage(WebClient driver) {
		this.driver = driver;
		baseURL = "http://companymx.com/coral/";
	}
	
	public void goToHome() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		driver.getPage(baseURL);
	}
	
	public MainMenu goToLogin() {
		MainMenu menu = new MainMenu(this.driver);
		menu.clickLogin();
		return menu;
	}
}
