package TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.TestInitialiazation;
import pageObject.MerchantPage;
import pageObject.SignInPage;

public class AllTestCases extends TestInitialiazation {
	
	SignInPage signinpage;	
	MerchantPage Mech;
	WebDriverWait wait;
	int LoadedImage;

	
	@Before
	public void SetupAut() {
		StartAut();
		driver.manage().window().maximize();
		signinpage = homepage.ClickLogin();
		Mech = signinpage.SignIn(myEmail, myPassword);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//Filter by manufacture by clicking checkbox(BMW)
		Mech.ClickBmw();
		
		Mech.CloseHelpToolTip();
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(Mech.pageImage));
		LoadedImage = Mech.pageImage.size();
	}
	
	//Verify filter was selected
	@Test
	public void CheckBoxSelection() {
		
		String VerifySelection = Mech.GetSelectedCar();
		System.out.println(VerifySelection);
		assertEquals("BMW", VerifySelection);
	}
	
	//Test to Verify all cars are BMW’s on the page
	@Test
	public void AllCarsBMW() {
		
		int displayedBMW=0;
		
		for(WebElement headerContext: Mech.imageHeader) 
		{
			String plainTxtContext = headerContext.getText();
			String[] arrayPlainTxtContext = plainTxtContext.split(" ");
			for(String Context:arrayPlainTxtContext) 
			{
				if(Context.equalsIgnoreCase("BMW"))
					displayedBMW++;
			}
						
		}
		System.out.println(displayedBMW);
		assertEquals(LoadedImage, displayedBMW);
	}
	
	//Verify each car has picture
	@Test
	public void AllImagesDisplayed() {
		int visiblePageImage = 0;

		for(WebElement Images: Mech.pageImage) 
		{
			boolean ImageDisplayed = Images.isDisplayed();
			if(ImageDisplayed == true) 
				visiblePageImage++;
		}

		assertEquals(LoadedImage,visiblePageImage);
		
	}
	
	//Verify each car has complete information
	@Test
	public void VerifyCarSpec() {
		
		for(WebElement carSpecs: Mech.carSpecification) 
		{
			assertNotNull(carSpecs);

		}
		
	}
	
	@After
	public void DriverQuit() {
		
		driver.quit();
	}
		
	}
	

