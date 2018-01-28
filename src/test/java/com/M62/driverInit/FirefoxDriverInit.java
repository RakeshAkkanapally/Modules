package com.M62.driverInit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverInit extends WebDriverInit{

	public static final String PATH="lib//driver//geckodriver.exe";
	
	@Override
	public WebDriver factoryMethod() {
		System.setProperty("webdriver.gecko.driver", PATH);
		FirefoxDriver driver=new FirefoxDriver();
		return driver;
	}
}
