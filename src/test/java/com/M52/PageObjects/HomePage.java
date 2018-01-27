package com.M52.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class HomePage {
	
	private HomePage HomePage;
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		System.out.println("inside constr");
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Home Page initialized..");
	}
	
	@FindBy(how=How.XPATH,using="(//*[@name='departureAirportName'])[1]")
	private WebElement From;

	@FindBy(how=How.XPATH,using="//*[text()=' Belgium']")
	private WebElement FromCountry;

	@FindBy(how=How.XPATH,using="//*[text()='Brussels Charleroi']")
	private WebElement FromAirport;
	
	@FindBy(how=How.XPATH,using="(//*[@name='destinationAirportName'])[1]")
	private WebElement To;
	
	@FindBy(how=How.XPATH,using="//*[text()=' United Kingdom']")
	private WebElement ToCountry;
	
	@FindBy(how=How.XPATH,using="//*[text()='Manchester']")
	private WebElement ToAirport;
	
	@FindBy(how=How.XPATH,using="//div[@class='dropdown-handle']")
	private WebElement AddPassengersDropdown;
	
	@FindBy(how=How.XPATH,using="(//*[@icon-id='glyphs.plus-circle'])[2]/..")
	private WebElement TeenPlusButton;

	@FindBy(how=How.XPATH,using="//button/span[text()=\"Let's go! \"]")
	private WebElement SearchButton;

	
public HomePage SelectFrom(final String Country){
	  System.out.println("Selecting Country.."+Country);
	From.click();
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
	FromCountry=(new WebDriverWait(driver, 10)).until(
			  new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//*[text()='"+Country+"']"));
				}
			});
	  FromCountry.click();
	  	
	return this;
	
}
	
	public HomePage SelectFromAirport(final String Airport){
		System.out.println("Selecting Airport:"+Airport);
		WebElement FromAirport=(new WebDriverWait(driver, 10)).until(
				  new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//*[text()='"+Airport+"']"));
					}
				});
		  FromAirport.click();	
		  return this;
	}
	
	public String getSelectedFromValue(){
		return From.getAttribute("value");
	}
	
	public HomePage SelectToCountry(final String Country){
		System.out.println("Selecting To Country:"+Country);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
		ToCountry=(new WebDriverWait(driver, 10)).until(
				  new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//*[text()='"+Country+"']"));
					}
				});	 
		ToCountry.click();
		return this;
		
	}
	
	public HomePage SelectToAirport(final String Airport){
		System.out.println("Selecting To Airport:"+Airport);
		ToAirport=(new WebDriverWait(driver, 10)).until(
				  new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//*[text()='"+Airport+"']"));
					}
				});
		  ToAirport.click();
		return this;
		
	}
	
	public String getSelectedToValue(){
	  new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementValue(To, "Manchester"));
	  return To.getAttribute("value");
	}
	
	public HomePage SelectFromCalendar(String StartDate, String startMonth){
		  
		  System.out.println("Selecting..."+StartDate+"-"+startMonth);
		  int i=1;
		  
		  while(i<11){
			  WebElement Month=driver.findElement(By.xpath("(//h1[@class='month-name'])["+i+"]")); 
		  if(Month.getText().toLowerCase().contains(startMonth.toLowerCase())){
			 WebElement Calendar=driver.findElement(By.xpath("(//core-datepicker//ul[@class='days'])["+i+"]"));
			 List<WebElement> Days=Calendar.findElements(By.xpath("(//core-datepicker//ul[@class='days'])["+i+"]/li"));
			 for (WebElement day : Days) {
				 String str=day.getAttribute("data-id").substring(0,2);
				if((str.substring(0,1).equals("0")?str.substring(1):str).equals(StartDate))
				{
					day.click();
					return this;
				}
			 }
		  }
		  else{
			  driver.findElement(By.xpath("//button[@class='arrow right']")).click();
			  i++;
		  }
	  }
		  
			 return this;
	  }
	
	public HomePage AddTeen(){
		AddPassengersDropdown.click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(WebDriverException.class);
		 TeenPlusButton = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.xpath("(//*[@icon-id='glyphs.plus-circle'])[2]/.."));
			     }});
		TeenPlusButton.click();
		return this;
	}

	public SearchResultPage Search() {
		SearchButton.click();
		return new SearchResultPage(driver);		
	}
	
}