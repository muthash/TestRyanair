package com.ryanair.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollEdit {
	    WebDriver driver;
		
	    @FindBy(how=How.CSS,using="carousel.ng-tns-c36-9 > div:nth-child(1) > button:nth-child(3)")
	    WebElement searchNextDepartDates;
	    
	    @FindBy(how=How.CSS,using="carousel.ng-tns-c36-9 > div:nth-child(1) > button:nth-child(1)")
	    WebElement searchPreviousDepartDates;
	    
	    @FindBy(how=How.CSS,using="li.ng-tns-c36-9")
	    List<WebElement> departDates;
	    
	    @FindBy(how=How.CSS,using="carousel.ng-tns-c36-12 > div:nth-child(1) > button:nth-child(3)")
	    WebElement searchNextReturnDates;
	    
	    @FindBy(how=How.CSS,using="carousel.ng-tns-c36-12 > div:nth-child(1) > button:nth-child(1)")
	    WebElement searchPreviousReturnDates;
	    
	    @FindBy(how=How.CSS,using="li.ng-tns-c36-9:nth-child(4) > carousel-item:nth-child(1) > button:nth-child(1)")
	    WebElement newDepartDate;
	    
	    @FindBy(how=How.CSS,using="li.ng-tns-c36-12:nth-child(3) > carousel-item:nth-child(1) > button:nth-child(1)")
	    WebElement newReturnDate;
	   
	    @FindBy(how=How.CSS,using="div.card-header.b2 > div.card-info > div")
	    WebElement flight;
	    
	    @FindBy(how=How.XPATH,using="/html/body/flights-root/div/div/div/div/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div/flight-card/div/div[1]/div[1]/div\n")
	    WebElement flight2;

	    @FindBy(how=How.CSS,using="button.fare-card__button:nth-child(2)")
	    WebElement valueButton;
	    
	    @FindBy(how=How.CSS,using=".login-touchpoint__expansion-bar")
	    WebElement logInLater;
	    
	    @FindBy(how=How.CSS,using=".continue-flow__button")
	    WebElement continueFlow;
	    
	    public ScrollEdit(WebDriver ldriver) {
			this.driver = ldriver;
		}
	    
	    public void scrollEditDates() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
	    	
	    	driver.findElement(By.cssSelector(".cookie-popup__close")).click();
	    	
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	wait.until(ExpectedConditions.elementToBeClickable(searchNextDepartDates));
	    	searchNextDepartDates.click();
	    	Thread.sleep(1000);
	    	newDepartDate.click();
	    	flight.click();
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", valueButton);
	    	valueButton.click();
	    	Thread.sleep(1000);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", valueButton);
	    	valueButton.click();
	    	
	    	for (int i = 0; i < 5; i++){
	    		searchPreviousReturnDates.click();
	    		Thread.sleep(1000);
	    	}
	    	newReturnDate.click();
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	flight2.click();
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", valueButton);
	    	valueButton.click();
	    	Thread.sleep(1000);
	    	if(valueButton.isDisplayed()) {
	    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", valueButton);
		    	valueButton.click();
	    	}
	    	
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logInLater);
	    	try {
	    		logInLater.click();
	    	}catch(NoSuchElementException e) {
	    		WebElement later = wait.until(ExpectedConditions.elementToBeClickable(logInLater));
	    		later.click();
	    	}
	    	
	    	String[] firstnames = {"Sónia", "Diogo", "Inês"};
	    	String[] surnames = {"Pereira", "Bettencourt", "Marçal"};
	    	
	    	By title=By.xpath("/html/body/flights-root/div/div/div/div/flights-lazy-passengers/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[1]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button");
    		By titleMr= By.cssSelector(".dropdown-item__link--highlighted");
    		By firstName = By.id("formState.passengers.ADT-0.name");
    		By surname = By.id("formState.passengers.ADT-0.surname");
    		driver.findElement(title).click();
    		driver.findElement(titleMr).click();
    		driver.findElement(firstName).sendKeys(firstnames[0]);
    		driver.findElement(surname).sendKeys(surnames[0]);
    		
    		By title2=By.xpath("/html/body/flights-root/div/div/div/div/flights-lazy-passengers/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[2]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button");
    		By titleMr2 = By.cssSelector("ry-dropdown-item.ng-star-inserted:nth-child(2) > button:nth-child(1)");
    		By firstName2 = By.id("formState.passengers.ADT-1.name");
    		By surname2 = By.id("formState.passengers.ADT-1.surname");
    		driver.findElement(title2).click();
    		driver.findElement(titleMr2).click();
    		driver.findElement(firstName2).sendKeys(firstnames[1]);
    		driver.findElement(surname2).sendKeys(surnames[1]);
    		
    		driver.findElement(By.id("formState.passengers.CHD-0.name")).sendKeys(firstnames[2]);
    		driver.findElement(By.id("formState.passengers.CHD-0.surname")).sendKeys(surnames[2]);
    		
    		continueFlow.click();
	    }
}
