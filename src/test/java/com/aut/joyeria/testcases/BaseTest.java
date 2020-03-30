package com.aut.joyeria.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.WebClient;

public class BaseTest {

	protected WebClient driver;
	
	public BaseTest(WebClient driver) {
		this.driver = driver;
	}
	@BeforeClass
	public void setup() {		
		driver = new WebClient();
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
