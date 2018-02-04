package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "a[class = 'signin-link']")
	public WebElement lnkLogin;
	
	
	public SignInPage ClickLogin() {
		lnkLogin.click();
		return new SignInPage(driver);
	}

}
