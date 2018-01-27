package com.M63.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
	
	ShoppingCartPage CartPage;
	WebDriver driver;
	
	@FindBy(how=How.ID,using="isCartBtn_btn")
	private WebElement addToCartButton;
	
	@FindBy(how=How.NAME,using="Color")
	private WebElement ColorDropDown;
	
	@FindBy(how=How.NAME,using="Storage Capacity")
	private WebElement MemoryDropDown;
	
	@FindBy(how=How.XPATH,using=".//*[contains(text(),'was just added to your cart.')]")
	private WebElement ItemAddedMessage;
	
	
	public ShoppingCartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public ShoppingCartPage ClickOnAddToCart(String color, String memory) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(addToCartButton));
		Select colorSelect=new Select(ColorDropDown);
		Select MemorySelect=new Select(MemoryDropDown);
		
		colorSelect.selectByVisibleText(color);
		MemorySelect.selectByVisibleText(memory);
		ClickOnAddToCart();
		return this;
	}

	public ShoppingCartPage ClickOnAddToCart() {
		if(addToCartButton.isDisplayed())
		addToCartButton.click();
		return this;
	}

	public boolean verifyItemAddedTOCart() {
		return ItemAddedMessage.isDisplayed();
	}


	
}
