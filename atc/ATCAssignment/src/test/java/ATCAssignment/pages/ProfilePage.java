package ATCAssignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	private WebElement profileLink;
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	private WebElement OrderHistoryLink;
	
	public ProfilePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickProfileLink() {
		profileLink.click();
	}
	
	public void clickOrderHistoryLink() {
		OrderHistoryLink.click();
	}

}
