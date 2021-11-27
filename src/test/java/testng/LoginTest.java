package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.LoginPage;

public class LoginTest {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().driverVersion("95.0.4638.69").setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test()
	public void test1() {
		LoginPage loginpage = new LoginPage(driver, wait, actions);
		loginpage.goToLoginPage();
		loginpage.loginNegative();
		String ActualMsg = loginpage.errorMessage();
		String ExpMsg = "The email or password you have entered is invalid.";
		Assert.assertEquals(ActualMsg, ExpMsg);
	}

}
