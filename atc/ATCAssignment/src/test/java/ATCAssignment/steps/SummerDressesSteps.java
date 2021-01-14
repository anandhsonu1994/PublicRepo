package ATCAssignment.steps;

import org.openqa.selenium.WebDriver;

import ATCAssignment.pages.SummerDressesPage;

public class SummerDressesSteps {
	
	SummerDressesPage summerDressesPage;
	
	public SummerDressesSteps(WebDriver driver) {
		summerDressesPage = new SummerDressesPage(driver);
	}
	
	public void changeToListView() {
		summerDressesPage.clickListView();
	}
	
	public void selectProductByOrder(int index) {
		summerDressesPage.clickOnProduct(index);
	}
	
	public void increaseProduct(int count) {
		for(int i=1; i< count; i++) {
			summerDressesPage.clickPlusIcon();
		}
	}
	
	public void selectSize(String size) {
		summerDressesPage.selectSize(size);
	}
	
	public void selectFirstColour() {
		summerDressesPage.clickFirstColor(1);
	}
	
	public void addToCart() {
		summerDressesPage.clickAddToCart();
	}
	
	public void continueShopping() {
		summerDressesPage.clickContinueShopping();
	}
	
	public void proceedToCheckout() {
		summerDressesPage.clickProceedCheckoutBtn();
	}
	
	public void navigateBackSummerDresses() {
		summerDressesPage.clickSummerDressesLink();
	}

}