package helpers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver StartBrowser(String browserName, String url) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(browserName.equalsIgnoreCase("FIREFOX")) {
			
			cap.setBrowserName(BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);
			
		} else if(browserName.equalsIgnoreCase("CHROME")) {
			
			cap.setBrowserName(BrowserType.CHROME);
			driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);
			
		} else if(browserName.equalsIgnoreCase("IE")) {
			
			cap.setBrowserName(BrowserType.IE);
			driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);
			
		} else if(browserName.equalsIgnoreCase("LOCAL")) {
			System.setProperty("webdriver.chrome.driver", "/Users/smuthama/eclipse-workspace/SeleniumDrivers/webdrivers/chromedriver");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("LOCALF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/smuthama/eclipse-workspace/SeleniumDrivers/webdrivers/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}

