package com.ryanair.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBar {
	
    WebDriver driver;
	
    @FindBy(how=How.CSS,using=".is-on-blue > fsw-trip-type-button:nth-child(1) > button:nth-child(1)")
    WebElement oneWay;

    @FindBy(how=How.CSS,using=".is-on-blue > fsw-trip-type-button:nth-child(1) > button:nth-child(1)")
    WebElement roundTrip;
    
    @FindBy(how=How.ID,using="input-button__departure") 
	WebElement departureAirport;
    
    @FindBy(how=How.ID,using="input-button__destination") 
	WebElement destinationAirport;
    
    @FindBy(how=How.TAG_NAME,using="fsw-airport-item")
    WebElement airport;
    
    @FindBy(how=How.CLASS_NAME,using="m-toggle__month")
    List<WebElement> monthWidget;
    
    @FindBy(how=How.CSS,using="[data-id='2020-12-06']")
    WebElement dateWidget;
   
    @FindBy(how=How.CSS,using="[data-id='2021-01-02']")
    WebElement returndateWidget;
    
    @FindBy(how=How.CSS,using="ry-counter.passengers-picker__passenger-type:nth-child(3) > div:nth-child(2) > div:nth-child(3)")
    WebElement addAdultsCounter;
    
    @FindBy(how=How.CSS,using="ry-counter.passengers-picker__passenger-type:nth-child(5) > div:nth-child(2) > div:nth-child(3)")
    WebElement addChildrenCounter;
    
    @FindBy(how=How.CSS,using=".passengers__confirm-button")
    WebElement done;
    
    @FindBy(how=How.CSS,using=".flight-search-widget__start-search")
    WebElement searchButton;
    
    
		
	public SearchBar(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void searchFlight() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Select round trip
		wait.until(ExpectedConditions.elementToBeClickable(roundTrip));
		roundTrip.click();
		
		//Select From Airports
		departureAirport.click();
		departureAirport.clear();
		departureAirport.sendKeys("Dublin");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        airport.click();
        
        
      //Select To Airport
		destinationAirport.click();
		destinationAirport.clear();
		destinationAirport.sendKeys("Paris Beauvais");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        airport.click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
      //Select Departure Date
        for(WebElement ele:monthWidget) {
			if(ele.getText().equalsIgnoreCase("Dec")) {
				ele.click();
			}
		}
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
        	dateWidget.click();
        }catch(StaleElementReferenceException e) {
        	WebElement departDate = wait.until(ExpectedConditions.elementToBeClickable(dateWidget));
    		departDate.click();
        }
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Select Return Date
        for(WebElement ele:monthWidget) {
			if(ele.getText().equalsIgnoreCase("Jan")) {
				ele.click();
			}
		}
        WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(returndateWidget));
		returnDate.click();
        
      //Select no. of passengers
		WebElement adults = wait.until(ExpectedConditions.elementToBeClickable(addAdultsCounter));
		adults.click();
		WebElement children = wait.until(ExpectedConditions.elementToBeClickable(addChildrenCounter));
		children.click();
		done.click();
		
		searchButton.click();
	}

}