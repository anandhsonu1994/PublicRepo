package ATCAssignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	
	@FindBy(xpath = "//p/a[@title='Proceed to checkout']")
	private WebElement summaryCheckoutBtn;
	
	@FindBy(xpath = "//button[@name='processAddress']")
	private WebElement addressCheckoutBtn;
	
	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement termsCheckBox;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement shippingCheckoutBtn;
	
	@FindBy(xpath = "//a[@class='cheque']")
	private WebElement payByCheckLink;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	
	
	public CheckoutPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickSummaryCheckoutBtn() {
		summaryCheckoutBtn.click();
	}
	
	public void clickAddressCheckoutBtn() {
		addressCheckoutBtn.click();
	}
	
	public void checkTermsConditionsBox() {
		termsCheckBox.click();
	}
	
	public void clickShippingCheckoutBtn() {
		shippingCheckoutBtn.click();
	}
	
	public void clickPayByCheckLink() {
		payByCheckLink.click();
	}
	
	public void clickConfirmOrderBtn() {
		confirmOrderBtn.click();
	}

}
