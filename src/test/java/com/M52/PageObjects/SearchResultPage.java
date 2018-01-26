package com.M52.PageObjects;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	
	SearchResultPage SearchResultPage;
	WebDriver driver;

	
	@FindBy(how=How.XPATH,using="(//div[@class='slide active']/div/div[@class='date'])[1]")
	private WebElement StartResultDateElement;
	
	@FindBy(how=How.XPATH,using="(//div[@class='slide active']/div/div[@class='date'])[2]")
	private WebElement EndResultDateElement;
	
	@FindBy(how=How.XPATH,using="(//flights-table)[1]//flights-table-header")
	private List<WebElement> Flights;
	
	@FindBy(how=How.XPATH,using="(//flights-table)[1]//flights-table-header//div[@class='start-time']")
	private List<WebElement> Departure_StartTime;
	@FindBy(how=How.XPATH,using="(//flights-table)[1]//flights-table-header//div[@class='end-time']")
	private List<WebElement> Departure_EndTime;
	@FindBy(how=How.XPATH,using="(//flights-table)[1]//flights-table-header//div[@class='meta-row flight-number-wrapper']//span[@class='flight-number']")
	private List<WebElement> Departure_FlightNumber;
	@FindBy(how=How.XPATH,using="(//flights-table)[1]//flights-table-header//strong")
	private List<WebElement> Departure_FlightTime;
	
	
	@FindBy(how=How.XPATH,using="(//flights-table)[2]//flights-table-header")
	private List<WebElement> ReturnFlights;

	@FindBy(how=How.XPATH,using="(//flights-table)[2]//flights-table-header//div[@class='start-time']")
	private List<WebElement> Arriving_StartTime;
	@FindBy(how=How.XPATH,using="(//flights-table)[2]//flights-table-header//div[@class='end-time']")
	private List<WebElement> Arriving_EndTime;
	@FindBy(how=How.XPATH,using="(//flights-table)[2]//flights-table-header//div[@class='meta-row flight-number-wrapper']//span[@class='flight-number']")
	private List<WebElement> Arriving_FlightNumber;
	@FindBy(how=How.XPATH,using="(//flights-table)[2]//flights-table-header//strong")
	private List<WebElement> Arriving_FlightTime;
	
		
	public SearchResultPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public SearchResultPage isFlightDisplayed(WebDriver driver) {
		boolean FlightDisplayed= (new WebDriverWait(driver, 10)).until(
				 new ExpectedCondition<Boolean>(){
					 public Boolean apply(WebDriver d){
						 try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						 return d.findElement(By.xpath("((//flights-table)[1]//flights-table-header)[1]")).isDisplayed();
					 }
				 }
		 );
		
		return SearchResultPage;
	}

	public String StartResultDateText(WebDriver driver) {
		StartResultDateElement = (new WebDriverWait(driver,10)).until(
				 new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("(//div[@class='slide active']/div/div[@class='date'])[1]"));
					}
				});
		 return StartResultDateElement.getText();		
	}

	public String EndResultDateText(WebDriver driver) {
		 EndResultDateElement = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='slide active']/div/div[@class='date'])[2]")));

		return EndResultDateElement.getText();
	}

	public SearchResultPage PrintFlightDetails(WebDriver driver) {
		 if(Flights.size()>=1){
			 ListIterator<WebElement> itr1 = Departure_StartTime.listIterator();
			 ListIterator<WebElement> itr2 = Departure_EndTime.listIterator();
			 ListIterator<WebElement> itr3 = Departure_FlightNumber.listIterator();
			 ListIterator<WebElement> itr4 = Departure_FlightTime.listIterator();

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
		 if(ReturnFlights.size()>=1){
			 ListIterator<WebElement> itr1 = Arriving_StartTime.listIterator();
			 ListIterator<WebElement> itr2 = Arriving_EndTime.listIterator();
			 ListIterator<WebElement> itr3 = Arriving_FlightNumber.listIterator();
			 ListIterator<WebElement> itr4 = Arriving_FlightTime.listIterator();

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
		return SearchResultPage;		
	}
	
	

}
