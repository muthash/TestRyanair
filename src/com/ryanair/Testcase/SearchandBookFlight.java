package com.ryanair.Testcase;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ryanair.Pages.ScrollEdit;
import com.ryanair.Pages.SearchBar;
import com.ryanair.Pages.SelectSeat;

import helpers.BrowserFactory;

public class SearchandBookFlight {
		
	@Test
	public void search() throws MalformedURLException, InterruptedException {
		
		System.out.println("SELENIUM JAVA RYANAIR TESTS...");
		WebDriver driver = BrowserFactory.StartBrowser("LOCALF", "https://www.ryanair.com/gb/en");
		
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
