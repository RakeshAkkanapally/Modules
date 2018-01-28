package com.M62.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.M62.driverInit.WebDriverSingleton;

public class StaticFactoryClass {
	
	public static HomePage initializeHomePage(WebDriver driver){
		System.out.println("Initializing Home Page..");
		return new HomePage(driver);
	}
	
	public static HomePage initializeHomePage(){
		System.out.println("Initializing Home Page..");
		return new HomePage(WebDriverSingleton.getDriverInstance());
	}

	public static SearchResultPage initializeSearchResultsPage(WebDriver driver){
		System.out.println("Initializing Search Rsults Page..");
		return new SearchResultPage(driver);
	}
	
	public static SearchResultPage initializeSearchResultsPage(){
		System.out.println("Initializing Search Rsults Page..");
		return new SearchResultPage(WebDriverSingleton.getDriverInstance());
	}
}
