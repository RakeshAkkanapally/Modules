package com.M51;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.google.common.base.Function;

public class NewTest {
	
	WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
	  
  }
  
  @Test
  public void Flight() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","lib//driver//chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.ryanair.com/gb/en/");
	  driver.manage().window().maximize();
	  Assert.assertEquals(driver.getTitle(),"Official Ryanair website | Book direct for the lowest fares | Ryanair.com");
	  
	  WebElement From=driver.findElement(By.xpath("(//*[@name='departureAirportName'])[1]"));
	  From.click();
	  
	  ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
	  
	  WebElement FromCountry=(new WebDriverWait(driver, 10)).until(
			  new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//*[text()=' Belgium']"));
				}
			});
	  FromCountry.click();
	  
	  WebElement FromAirport=(new WebDriverWait(driver, 10)).until(
			  new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//*[text()='Brussels Charleroi']"));
				}
			});
	  FromAirport.click();	 
	  Assert.assertEquals(From.getAttribute("value"), "Brussels Charleroi");
  
	 
	  WebElement To=driver.findElement(By.xpath("(//*[@name='destinationAirportName'])[1]"));
	  //To.click();
	  
	  WebElement ToCountry=(new WebDriverWait(driver, 10)).until(
			  new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//*[text()=' Germany']"));
				}
			});	  
	  Assert.assertTrue(ToCountry.getAttribute("class").contains("unavailable"));
	  
	  ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
	  ToCountry=(new WebDriverWait(driver, 10)).until(
			  new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//*[text()=' United Kingdom']"));
				}
			});
	  ToCountry.click();
	  
	  WebElement ToAirport=(new WebDriverWait(driver, 10)).until(
			  new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//*[text()='Manchester']"));
				}
			});
	  ToAirport.click();
	  
	  new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementValue(To, "Manchester"));
	  Assert.assertEquals(To.getAttribute("value"), "Manchester");
	  
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
	 driver=SelectFromCalendar(driver, StartDate, StartMonth);
	 driver=SelectFromCalendar(driver, ToDate,ToMonth);
	 driver.findElement(By.xpath("//div[@class='dropdown-handle']")).click();
	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(WebDriverException.class);
	 WebElement AddTeen = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("(//*[@icon-id='glyphs.plus-circle'])[2]/.."));
		     }});
	 AddTeen.click();
	 
	 driver.findElement(By.xpath("//button/span[text()=\"Let's go! \"]")).click();
	
	 boolean FlightDisplayed= (new WebDriverWait(driver, 10)).until(
			 new ExpectedCondition<Boolean>(){
				 public Boolean apply(WebDriver d){
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					 return d.findElement(By.xpath("((//flights-table)[1]//flights-table-header)[1]")).isDisplayed();
				 }
			 }
	 );
	 WebElement StartResultDateElement = (new WebDriverWait(driver,10)).until(
			 new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("(//div[@class='slide active']/div/div[@class='date'])[1]"));
				}
			});
	 String StartResultDate=StartResultDateElement.getText();
	 Assert.assertTrue(StartResultDate.toLowerCase().contains((StartDate+" "+StartMonth.substring(0,3)).toLowerCase()));
	 
	 WebElement EndResultDateElement = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='slide active']/div/div[@class='date'])[2]")));
	 String EndResultDate=EndResultDateElement.getText();
	 Assert.assertTrue(EndResultDate.toLowerCase().contains((ToDate+" "+ToMonth.substring(0,3)).toLowerCase()));
	 
	// Thread.sleep(5000);
	 //Verify atleast one flight available for each destination
	 
	 //wait till Flight details get loaded
	 
	 List<WebElement> Flights=driver.findElements(By.xpath("(//flights-table)[1]//flights-table-header"));
	 if(Flights.size()>=1){
		 List<WebElement> StartTime = driver.findElements(By.xpath("(//flights-table)[1]//flights-table-header//div[@class='start-time']"));
		 List<WebElement> EndTime = driver.findElements(By.xpath("(//flights-table)[1]//flights-table-header//div[@class='end-time']"));
		 List<WebElement> FlightNumber = driver.findElements(By.xpath("(//flights-table)[1]//flights-table-header//div[@class='meta-row flight-number-wrapper']//span[@class='flight-number']"));
		 List<WebElement> FlightTime = driver.findElements(By.xpath("(//flights-table)[1]//flights-table-header//strong"));
		 
		 ListIterator<WebElement> itr1 = StartTime.listIterator();
		 ListIterator<WebElement> itr2 = EndTime.listIterator();
		 ListIterator<WebElement> itr3 = FlightNumber.listIterator();
		 ListIterator<WebElement> itr4 = FlightTime.listIterator();

		 System.out.println("\nTo Flight");
		 while (itr1.hasNext()) {
			System.out.println("\nFlight Number:"+itr3.next().getText());
			System.out.print("\tStart Time:"+itr1.next().getText());
			System.out.print("\tEnd Time:"+itr2.next().getText());
			System.out.print("\tFlightTime:"+itr4.next().getText());

		 }
		 
	 }else{
		 System.out.println("No To Flights Available");
	 }
	 List<WebElement> ReturnFlights = driver.findElements(By.xpath("(//flights-table)[2]//flights-table-header"));
	 if(ReturnFlights.size()>=1){
		 List<WebElement> StartTime = driver.findElements(By.xpath("(//flights-table)[2]//flights-table-header//div[@class='start-time']"));
		 List<WebElement> EndTime = driver.findElements(By.xpath("(//flights-table)[2]//flights-table-header//div[@class='end-time']"));
		 List<WebElement> FlightNumber = driver.findElements(By.xpath("(//flights-table)[2]//flights-table-header//div[@class='meta-row flight-number-wrapper']//span[@class='flight-number']"));
		 List<WebElement> FlightTime = driver.findElements(By.xpath("(//flights-table)[2]//flights-table-header//strong"));
		 
		 ListIterator<WebElement> itr1 = StartTime.listIterator();
		 ListIterator<WebElement> itr2 = EndTime.listIterator();
		 ListIterator<WebElement> itr3 = FlightNumber.listIterator();
		 ListIterator<WebElement> itr4 = FlightTime.listIterator();

		 System.out.println("\nReturn Flight");
		 while (itr1.hasNext()) {
			System.out.println("\nFlight Number:"+itr3.next().getText());
			System.out.print("\tStart Time:"+itr1.next().getText());
			System.out.print("\tEnd Time:"+itr2.next().getText());
			System.out.print("\tFlightTime:"+itr4.next().getText());

		 }
		 		 
	 }else{
		 System.out.println("No Return Flights Available");
	 }
  }
  
  public WebDriver SelectFromCalendar(WebDriver driver,String StartDate, String startMonth){
	  
	  System.out.println(StartDate+";;"+startMonth);
	  int i=1;
	  
	  while(i<11){
		  WebElement Month=driver.findElement(By.xpath("(//h1[@class='month-name'])["+i+"]")); 
		  System.out.println(Month.getText());
	  if(Month.getText().toLowerCase().contains(startMonth.toLowerCase())){
		 WebElement Calendar=driver.findElement(By.xpath("(//core-datepicker//ul[@class='days'])["+i+"]"));
		 List<WebElement> Days=Calendar.findElements(By.xpath("(//core-datepicker//ul[@class='days'])["+i+"]/li"));
		 for (WebElement day : Days) {
			 System.out.println(day.getAttribute("data-id").substring(0,2));
			 String str=day.getAttribute("data-id").substring(0,2);
			if((str.substring(0,1).equals("0")?str.substring(1):str).equals(StartDate))
			{
				day.click();
				return driver;
			}
		 }
	  }
	  else{
		  driver.findElement(By.xpath("//button[@class='arrow right']")).click();
		  i++;
	  }
  }
	  
		 return driver;
  }

  @AfterTest
  public void afterTest() {
	 driver.quit();
  }

}
