package pageObject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantPage {
	
	WebDriver driver;
	
	public MerchantPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[6][@class='carFilters__checkbox--list-item']//span")
	public WebElement btnBMW;
	
	@FindBy(css = "div[class='filterActiveFilters__selectedFilter']")
	public WebElement selectedCar;
		
	@FindBy(css = "div[class='image-gallery-slides']")
	public List<WebElement> pageImage;
	
	@FindBy(css = "div[class='big-car-card__header']")
	public List<WebElement> imageHeader;
	
	@FindBy(css = "div[class='car-specs-list']")
	public List<WebElement> carSpecification;
	
	@FindBy(css = "a[class='helpTooltip__closeIcon']")
	public WebElement helpToolTip;
	
	
	
	public void ClickBmw() {
		btnBMW.click();
		
	}
	
	public void CloseHelpToolTip() {
		helpToolTip.click();
	}
	
	public String GetSelectedCar() {
		String carSelected = selectedCar.getText();
		return carSelected;
	}
}
