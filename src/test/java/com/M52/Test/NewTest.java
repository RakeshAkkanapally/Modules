package com.M52.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.internal.runners.statements.ExpectException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.M52.PageObjects.HomePage;
import com.M52.PageObjects.SearchResultPage;
import com.google.common.base.Function;

public class NewTest {
	
	WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","lib//driver//chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  
  }
  
  @Test
  public void Flight() throws InterruptedException {
	  
	  driver.get("https://www.ryanair.com/gb/en/");
	  driver.manage().window().maximize();
	  Assert.assertEquals(driver.getTitle(),"Official Ryanair website | Book direct for the lowest fares | Ryanair.com");
	  
	  HomePage HomePage=new HomePage(driver);
	  HomePage.SelectFrom(" Belgium");
	  HomePage.SelectFromAirport("Brussels Charleroi");	 
	  Assert.assertEquals(HomePage.getSelectedFromValue(), "Brussels Charleroi");
  
	 
	  HomePage.SelectToCountry(" United Kingdom");
	  HomePage.SelectToAirport("Manchester");
	  Assert.assertEquals(HomePage.getSelectedToValue(), "Manchester");
	  
	  //Mechanism to choose random dates 
	  LocalDate startDate = LocalDate.of(java.time.LocalDateTime.now().getYear(), java.time.LocalDateTime.now().getMonthValue(), java.time.LocalDateTime.now().getDayOfMonth()); //start date
	  long start = startDate.toEpochDay();

	  LocalDate endDate = LocalDate.of(java.time.LocalDateTime.now().getYear(),java.time.LocalDateTime.now().getMonthValue()+7,java.time.LocalDateTime.now().getDayOfMonth()); //end date
	  long end = endDate.toEpochDay();

	  long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
	  long randomEpochDay2 = ThreadLocalRandom.current().longs(randomEpochDay, end).findAny().getAsLong();

	  //System.out.println(LocalDate.ofEpochDay(randomEpochDay));
	  //System.out.println(LocalDate.ofEpochDay(randomEpochDay2));

	 String StartDate=LocalDate.ofEpochDay(randomEpochDay).getDayOfMonth()+"";
	 String ToDate=LocalDate.ofEpochDay(randomEpochDay2).getDayOfMonth()+"";
	 String StartMonth=LocalDate.ofEpochDay(randomEpochDay).getMonth().name();
	 String ToMonth=LocalDate.ofEpochDay(randomEpochDay2).getMonth().name();
	 
	 HomePage.SelectFromCalendar(StartDate, StartMonth);
	 HomePage.SelectFromCalendar(ToDate,ToMonth);
	 
	 HomePage.AddTeen();
	 SearchResultPage SearchResultPage = HomePage.Search();
	 SearchResultPage.isFlightDisplayed();
	 
	 String StartResultDate=SearchResultPage.StartResultDateText().toLowerCase();
	 Assert.assertTrue(StartResultDate.toLowerCase().contains((StartDate+" "+StartMonth.substring(0,3)).toLowerCase()));
	 
	 String EndResultDate=SearchResultPage.EndResultDateText().toLowerCase();
	 Assert.assertTrue(EndResultDate.toLowerCase().contains((ToDate+" "+ToMonth.substring(0,3)).toLowerCase()));
	 SearchResultPage.PrintFlightDetails();
	 
	 System.out.println("Test Execution Completed..");	  
  }
  

  @AfterClass
  public void afterTest() {
	 driver.quit();
  }

}
