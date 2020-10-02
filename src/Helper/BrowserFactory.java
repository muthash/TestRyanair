package Helper;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
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
			
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}
