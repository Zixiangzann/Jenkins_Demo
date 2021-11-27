package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(className = "rememberMe")
	WebElement Remember;
	
	@FindBy(name = "btn_login")
	WebElement LoginButton;
	
	@FindBy(id = "msg_box")
	WebElement Error;
	
	
	public LoginPage(WebDriver driver,WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void goToLoginPage() {
		driver.get("https://www.simplilearn.com/");
	}
	

	public void loginNegative() {
		 driver.manage().window().maximize();
		 wait.until(ExpectedConditions.visibilityOf(LoginLink));
		 LoginLink.click();
		 UserName.sendKeys("abc@xyz.com");
		 Password.sendKeys("Abc@12345");
		 Remember.click();
		 LoginButton.click();

	}
	
	public String errorMessage() {
		return Error.getText();	
	}

}
