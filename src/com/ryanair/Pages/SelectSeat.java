package com.ryanair.Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSeat {
	
	 WebDriver driver;
	 
	 @FindBy(how=How.CSS,using=".seats-modal__cta")
	 WebElement familyInfoModal;
	 
	 @FindBy(how=How.CSS,using=" div.seatmap__seatrow--with-band:nth-child(5) > div:nth-child(2) > button:nth-child(1)")
	 WebElement firstSeat;
	 
	 @FindBy(how=How.CSS,using=" div.seatmap__seatrow--with-band:nth-child(5) > div:nth-child(2) > button:nth-child(2)")
	 WebElement secondSeat;
	 
	 @FindBy(how=How.CSS,using=" div.seatmap__seatrow--with-band:nth-child(5) > div:nth-child(2) > button:nth-child(3)")
	 WebElement thirdSeat;
	 
	 @FindBy(how=How.CSS,using=".ry-button")
	 WebElement nextFlight;
	 
	 @FindBy(how=How.CSS,using="button.seats-prompt__cta:nth-child(3)")
	 WebElement sameSeats;
	 
	 @FindBy(how=How.CSS,using=".enhanced-takeover-beta__product-dismiss-cta")
	 WebElement dontAvaoidAcrowds;
	 
	 @FindBy(how=How.CSS,using="bags-cabin-bag-product.product:nth-child(1) > div:nth-child(1) > bags-product-selector:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ry-radio-circle-button:nth-child(1) > label:nth-child(1)")
	 WebElement smallBag;
	 
	 @FindBy(how=How.CSS,using=".ry-button--gradient-yellow")
	 WebElement continueSeatPage;
	 
	 @FindBy(how=How.CSS,using=".ry-button--full")
	 WebElement continueAnythingElse;
	 
	 public SelectSeat(WebDriver ldriver) {
			this.driver = ldriver;
	 }
	 
	 public void selection() {
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(familyInfoModal));
		 familyInfoModal.click();
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".seats-modal__cta")));
		 
		 Boolean seatNotAvailable = true;
		 int count = 5;
		 try {
			 firstSeat.click();
			 secondSeat.click();
			 thirdSeat.click();
		 }catch(NoSuchElementException e) {
			 while (seatNotAvailable) {
				 count++;
				 System.out.println("Iterating Through Seat - "+count);
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 try {
					 driver.findElement(By.cssSelector("div.seatmap__seatrow--with-band:nth-child("+count+") > div:nth-child(2) > button:nth-child(1)")).click();
					 driver.findElement(By.cssSelector("div.seatmap__seatrow--with-band:nth-child("+count+") > div:nth-child(2) > button:nth-child(2)")).click();
					 driver.findElement(By.cssSelector("div.seatmap__seatrow--with-band:nth-child("+count+") > div:nth-child(2) > button:nth-child(3)")).click();
					 seatNotAvailable = false;
				 }catch(NoSuchElementException | ElementClickInterceptedException d) {}
				 if(count == 35) {
					 seatNotAvailable = false;
				 }
			 }
		 }
		 
		 if(!seatNotAvailable) {
			 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)");
		 }
		 
		 wait.until(ExpectedConditions.elementToBeClickable(nextFlight));
		 nextFlight.click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(sameSeats));
		 sameSeats.click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(dontAvaoidAcrowds));
		 dontAvaoidAcrowds.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(smallBag));
		 smallBag.click();
		 
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueSeatPage);
		 continueSeatPage.click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(continueAnythingElse));
		 continueAnythingElse.click();
	 }

}
