package com.ryanair.Testcase;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.ryanair.Pages.ScrollEdit;
import com.ryanair.Pages.SearchBar;
import com.ryanair.Pages.SelectSeat;

import Helper.BrowserFactory;

public class SearchandBookFlight {
		
	@Test
	public void search() throws MalformedURLException, InterruptedException {
		
//		WebDriver driver = BrowserFactory.StartBrowser("CHROME", "https://www.ryanair.com/gb/en");
//		SearchBar searchFlight = PageFactory.initElements(driver, SearchBar.class);
//		searchFlight.getFlight();
		
		System.out.println("WELCOME TO SELENIUM JAVA ...");
		System.setProperty("webdriver.chrome.driver", "/Users/smuthama/eclipse-workspace/installer/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ryanair.com/gb/en");
		driver.manage().window().maximize();
		SearchBar flight = PageFactory.initElements(driver, SearchBar.class);
		flight.searchFlight();
		
		ScrollEdit edit = PageFactory.initElements(driver, ScrollEdit.class);
		edit.scrollEditDates();
		
		SelectSeat seat = PageFactory.initElements(driver, SelectSeat.class);
		seat.selection();
		
		
		System.out.println("FINISHED RUNNING...");
		
		
//		driver.quit();
	}

}


