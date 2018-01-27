package com.M63.steps;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.M63.pageObjects.SearchResultPage;
import com.M63.pageObjects.ShoppingCartPage;
import com.M63.selenium.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.StringContains.containsString;

public class BaseStepDef extends BaseSelenium{
	
	SearchResultPage ResultsPage;
	ShoppingCartPage CartPage;
	
	/**
     * To open the website in the browser
     * @param searchRequest
     */
    @Given("^User launch the website \"([^\"]*)\"$")
    public void launchApplication(String url){
        driver.get(url);
    }
	
    /**
     * Set search request to search field in Main Search Form
     * @param searchRequest
     */
    @Given("^User search for an item \"([^\"]*)\"$")
    public void iSetSearchRequest(String searchRequest){
        ResultsPage=new SearchResultPage(driver);
        ResultsPage.searchFor(searchRequest);
    }

    @Then("^User selects the First Item listed$")
    public void selectFirstListedItem() throws Throwable {
    	CartPage=ResultsPage.selectFirstResultItem();
    }

    @Then("^User adds the item to cart$")
    public void addFirstListedItem() throws Throwable {
    	try{
    	CartPage.ClickOnAddToCart();
    	}catch(NoSuchElementException e){
    		Assert.fail("Item is not in Stock");
    	}
    	
    }
    
    @Then("^User adds the item with \"([^\"]*)\" color and \"([^\"]*)\" RAM to cart$")
    public void addFirstListedItem(String Color, String Memory) throws Throwable {
    	try{
    	CartPage.ClickOnAddToCart(Color,Memory);
    	}catch(NoSuchElementException e){
    		Assert.fail("Item with the given variant is not in Stock");
    	}
    	
    }
   
    @Then("^Verify Item is succesfully added to cart$")
    public void VerifyItemIsAdded() throws Throwable {
    	
		Assert.assertTrue("Item Added To Cart", CartPage.verifyItemAddedTOCart());

    }

    
}
