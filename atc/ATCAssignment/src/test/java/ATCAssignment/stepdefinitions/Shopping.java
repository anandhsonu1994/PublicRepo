package ATCAssignment.stepdefinitions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import ATCAssignment.steps.AddressesSteps;
import ATCAssignment.steps.CheckoutSteps;
import ATCAssignment.steps.LoginSteps;
import ATCAssignment.steps.ProfileSteps;
import ATCAssignment.steps.SummerDressesSteps;
import ATCAssignment.steps.WomenShoppingSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shopping {
	
	WebDriver driver;
	LoginSteps loginStep;
	AddressesSteps addressesStep;
	WomenShoppingSteps womenShoppingSteps;
	SummerDressesSteps summerDressesSteps;
	CheckoutSteps checkoutSteps;
	ProfileSteps profileSteps;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		this.driver.get("http://automationpractice.com/index.php");
		loginStep = new LoginSteps(driver); 
		addressesStep = new AddressesSteps(driver);
		womenShoppingSteps = new WomenShoppingSteps(driver);
		profileSteps = new ProfileSteps(driver); 
		checkoutSteps = new CheckoutSteps(driver);
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
		loginStep = null;
		addressesStep = null;
		womenShoppingSteps = null;
		profileSteps = null;
		checkoutSteps = null;
	}

	@Given("^Login into the application$")
	public void login_into_the_application() throws Throwable {
		loginStep.signIn("test.123@test.com","test123");   
	}

	@And("^Navigate to 'My Addresses' and add a new address$")
	public void navigate_to_My_Addresses_and_add_a_new_address() throws Throwable {
		addressesStep.addNewAddress();
	}

	@And("^Fill all the informations\\(not only the mandatory\\)$")
	public void fill_all_the_informations_not_only_the_mandatory() throws Throwable {
		addressesStep.fillAllInformation();  
	}

	@And("^Click 'Save'$")
	public void click_Save() throws Throwable {
		addressesStep.saveAddress();
	}

	@And("^Navigate to 'Women' --> Summer dresses$")
	public void navigate_to_Women_Summer_dresses() throws Throwable {
		womenShoppingSteps.navigateToSummerDresses();
	}

	@And("^The Items would be in 'Grid view'\\. Change it to 'List View'\\.$")
	public void the_Items_would_be_in_Grid_view_Change_it_to_List_View() throws Throwable {
		summerDressesSteps = new SummerDressesSteps(driver);
		summerDressesSteps.changeToListView();
	    
	}

	@And("^Click on the first item to view\\.$")
	public void click_on_the_first_item_to_view() throws Throwable {
		summerDressesSteps.selectProductByOrder(1);   
	}

	@Given("^Increase the quantity to (\\d+)$")
	public void increase_the_quantity_to(int arg1) throws Throwable {
		summerDressesSteps.increaseProduct(5);
	}

	@Given("^Change the size to 'L'$")
	public void change_the_size_to_L() throws Throwable {
		summerDressesSteps.selectSize("L");
	    
	}

	@Given("^Select any colour\\.$")
	public void select_any_colour() throws Throwable {
		summerDressesSteps.selectFirstColour(); 
	}

	@Given("^Add to cart$")
	public void add_to_cart() throws Throwable {
		summerDressesSteps.addToCart();
	}

	@And("^Click 'Continue shopping' and repeat the same for the other (\\d+) items as well under the summer dresses\\.$")
	public void click_Continue_shopping_and_repeat_the_same_for_the_other_items_as_well_under_the_summer_dresses(int arg1) throws Throwable {
		summerDressesSteps.continueShopping();
		summerDressesSteps.navigateBackSummerDresses();
		
		summerDressesSteps.selectProductByOrder(2); 
		summerDressesSteps.increaseProduct(5);
		summerDressesSteps.selectSize("L");
		summerDressesSteps.selectFirstColour(); 
		summerDressesSteps.addToCart();
		summerDressesSteps.continueShopping();
		
		summerDressesSteps.navigateBackSummerDresses();
		summerDressesSteps.selectProductByOrder(3); 
		summerDressesSteps.increaseProduct(5);
		summerDressesSteps.selectSize("L");
		summerDressesSteps.selectFirstColour(); 
		summerDressesSteps.addToCart();
	}

	@And("^Proceed to checkout and complete the payment$")
	public void proceed_to_checkout_and_complete_the_payment() throws Throwable {
		summerDressesSteps.proceedToCheckout();
		checkoutSteps.summaryStep();
		checkoutSteps.addressStep();
		checkoutSteps.shippingStep();
		checkoutSteps.paymentStep();
		checkoutSteps.confirmOrder();    
	}

	@And("^Move to your profile and check 'order history and details'$")
	public void move_to_your_profile_and_check_order_history_and_details() throws Throwable {
		profileSteps.gotoProfilePage();
		profileSteps.gotoOrderHistoryPage();
	}

	@When("^Capture screenshot of the order history$")
	public void capture_screenshot_of_the_order_history() throws Throwable {
		TakesScreenshot ss = (TakesScreenshot)driver;		
		File file = ss.getScreenshotAs(OutputType.FILE);	
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
		Files.copy(file,new File(".\\src\\test\\java\\ATCAssignment\\ScreenShots\\" + filename+".png"));
	}

	@Then("^Sign out from the application$")
	public void sign_out_from_the_application() throws Throwable {
		loginStep.signOut();  
	}
}