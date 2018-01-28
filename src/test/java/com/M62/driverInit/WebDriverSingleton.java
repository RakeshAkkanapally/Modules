package com.M62.driverInit;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {
	
	private static WebDriver driver;
	
	private WebDriverSingleton(){}
	
	public static WebDriver getDriverInstance(){
	
		if(driver==null){
		WebDriverInit driverInit=new ChromeDriverInit();
		driver=driverInit.factoryMethod(); //factoryMethod() will initialize the webdriver object
		}
		return driver;
	}
	
	public static void closeDriverInstance(){
		if(driver!=null){
			driver.quit();
			driver=null;
		}
		
	}

}
