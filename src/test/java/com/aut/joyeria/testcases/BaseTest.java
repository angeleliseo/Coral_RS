package com.aut.joyeria.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;
	
	public BaseTest(WebDriver driver) {
		this.driver = driver;
	}
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\My Sandbox Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
