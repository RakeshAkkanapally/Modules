package com.M63.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	SearchResultPage ResultsPage;
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using=".//*[@id='gh-ac']")
	private WebElement searchField;
	
	@FindBy(how=How.XPATH,using=".//*[@id='gh-btn']")
	private WebElement searchButton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='ListViewInner']/li[1]//a//img")
	private WebElement firstResultItem;
	
	
	public SearchResultPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage searchFor(String searchRequest) {
		searchField.sendKeys(searchRequest);
		searchButton.click();
		return this;		
	}

	public ShoppingCartPage selectFirstResultItem() {
		firstResultItem.click();
		return new ShoppingCartPage(driver);
	}
	

}
