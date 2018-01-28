package com.M62.driverInit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverInit extends WebDriverInit{

	public static final String PATH="lib//driver//chromedriver.exe";
	
	@Override
	public WebDriver factoryMethod() {
		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
