//import static org.testng.Assert.assertEquals;  // Keep this one
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class FaceBookAssertion {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();


	@BeforeTest
	public void setUp() throws Exception{
		// Setup code to initialize WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sara\\Desktop\\Sarah\\Automation\\chromedriver-win64(06.01.25)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.name("email")).sendKeys("TestNG here", Keys.ENTER);
		driver.manage().window().maximize();

		Thread.sleep(3000);
	}

	//Title Assertion: Verify the title is changed or not in 'Log into facebook'
	@Test(priority=1)
	public void FBTitle() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Log in to Facebook";
		softAssert.assertEquals(ActualTitle,ExpectedTitle, "Title is mismatched");
	}

	//URL Assertion: URL is changed or not
	@Test(priority=2)
	public void FBURL() {
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://www.facebook.com/";
		softAssert.assertNotEquals(ActualURL, ExpectedURL, "URL is invalid");
	}

	//Text Assertion: Username is completely erased 
	@Test(priority=3)
	public void FBText() {
		String ActualText = driver.findElement(By.name("email")).getAttribute("value");
		String ExpectedText = "";
		softAssert.assertEquals(ActualText, ExpectedText, "Username Text is mismatched");
	}

	//Border Assertion: Border of the username field is highlighted with red color or not after entering invalid username
	@Test(priority=4)
	public void FBBorder() {
		String ActualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String ExpectedBorder = "0.8px solid rgb(240, 40, 73)"; //convert HEX to RGB value
		softAssert.assertEquals(ActualBorder, ExpectedBorder, "Username Text is mismatched");
	}

	//Error Message Assertion: Verify the error message is displayed properly
	@Test(priority=5)
	public void FBErrorMessage() {
		String ActualErrorMessage = driver.findElement(By.xpath("//div[@id=\"email_container\"]/div[2]")).getText();
		String ExpectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in."; //convert HEX to RGB value
		softAssert.assertEquals(ActualErrorMessage, ExpectedErrorMessage, "Username Error Message is mismatched");
	}

	//Image Assertion: Warning sign upon entering invalid username is displayed
	
	@Test
	public void FBWarnSign() {
	    boolean ActualSign = driver.findElement(By.xpath("//img[@class=\"_9ay6 img\"]")).isDisplayed();
	    softAssert.assertTrue(ActualSign, "Warning Sign is displayed perfectly!");
	}
	
	
	
	@AfterTest
	public void tearDown() {
		// Cleanup code to close the browser after tests are complete
		if (driver != null) 
		{
			softAssert.assertAll();
			driver.quit();
		}
	}

}
