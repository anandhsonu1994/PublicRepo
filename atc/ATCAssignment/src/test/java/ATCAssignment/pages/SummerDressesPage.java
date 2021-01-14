package ATCAssignment.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SummerDressesPage {
	
	@FindBy(xpath = "//a[@title='List']")
	private WebElement listViewLink;
	
	@FindBy(xpath = "//a[@class='product-name']")
	private List<WebElement> productList;
	
	@FindBy(xpath = "//i[@class='icon-plus']")
	private WebElement plusIcon;
	
	@FindBy(xpath = "//select[@id='group_1']")
	private WebElement sizeDropDown;
	
	@FindBy(xpath = "//ul[@id='color_to_pick_list']/li")
	private List<WebElement> colorLinkList;
	
	@FindBy(xpath = "//button[@type='submit']/span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[@title='Continue shopping']")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedCheckoutBtn;
	
	@FindBy(xpath = "//div/a[text()='Summer Dresses']")
	private WebElement summerDressesLink;

	
	public SummerDressesPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickListView() {
		listViewLink.click();
	}
	
	public void clickOnProduct(int index) {
		productList.get(index).click();
	}
	
	public void clickPlusIcon() {
		plusIcon.click();
	}
	
	public void selectSize(String size) {
		Select sizeList = new Select(sizeDropDown);
		sizeList.selectByVisibleText(size);
	}
	
	public void clickFirstColor(int index) {
		colorLinkList.get(index-1).click();
	}
	
	public void clickAddToCart() {
		addToCartBtn.click();
	}
	
	public void clickContinueShopping() {
		continueShoppingBtn.click();
	}
	
	public void clickProceedCheckoutBtn() {
		proceedCheckoutBtn.click();
	}
	
	public void clickSummerDressesLink() {
		summerDressesLink.click();
	}
	
	
}
