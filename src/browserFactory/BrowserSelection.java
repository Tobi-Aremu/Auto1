package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelection {
	
	static WebDriver driver;
	
	public static WebDriver SelectBrowser(String browserName, String url) {
		
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "c:\\Libs\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:\\Libs\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		driver.get(url);
		return driver;
		
	}
	

}
