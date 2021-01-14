package ATCAssignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signInLink;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailBox;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement pwdBox;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']/span")
	private WebElement signInButton;
	
	@FindBy(xpath = "//a[@class='logout']")
	private WebElement signOutButton;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void gotoSignInPage() {
		signInLink.click();
	}
	
	public void enterCredentials(String mailId, String pwd) {
		emailBox.sendKeys(mailId);
		pwdBox.sendKeys(pwd);
		signInButton.click();
	}
	
	public void clickSignOut() {
		signOutButton.click();
	}
	
}
