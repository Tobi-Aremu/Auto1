package config;

import org.openqa.selenium.WebDriver;

import browserFactory.BrowserSelection;
import pageObject.HomePage;

public class TestInitialiazation {
	
	private String browser = "firefox";
	private final String url = "https://www.auto1.com/en/our-cars";
	public final String myEmail = "e.aremu@yahoo.com";
	public final String myPassword= "testing1";
	public WebDriver driver;
	public HomePage homepage;
	
	public void StartAut() {
		driver = BrowserSelection.SelectBrowser(browser, url);
		homepage = new HomePage(driver);
	}
}
