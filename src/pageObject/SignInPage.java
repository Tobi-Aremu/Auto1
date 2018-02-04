package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "login-email")
	WebElement txtLoginEmail;
	
	@FindBy(id = "login-password")
	WebElement txtLoginPassword;
	
	@FindBy(xpath = "//div[5][@class='btn-container']/button")
	WebElement btnLogin;
	
	public MerchantPage SignIn(String email, String password) {
		txtLoginEmail.sendKeys(email);
		txtLoginPassword.sendKeys(password);
		btnLogin.click();
		return new MerchantPage(driver);
	
	
	}

}
