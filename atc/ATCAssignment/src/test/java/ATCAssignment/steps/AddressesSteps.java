package ATCAssignment.steps;

import org.openqa.selenium.WebDriver;

import ATCAssignment.pages.AddressesPage;

public class AddressesSteps {
	
	AddressesPage addressesPage;
	
	public AddressesSteps(WebDriver driver) {
		addressesPage = new AddressesPage(driver);
	}
	
	public void addNewAddress() {
		addressesPage.gotoAddressesPage();
		addressesPage.clickAddNewAddress();
	}
	
	public void fillAllInformation() {
		addressesPage.fillFirstName("testFirstName");
		addressesPage.fillLastName("testLastName");
		addressesPage.fillCompanyName("testCompany");
		addressesPage.fillAddress1("testAddress1");
		addressesPage.fillAddress2("testAddress2");
		addressesPage.fillCityName("testCityName");
		addressesPage.selectState("Texas");
		addressesPage.fillZipCode("12345");
		addressesPage.selectCountry("United States");
		addressesPage.fillHomePhone("9999-9999");
		addressesPage.fillMobilePhone("99999-99999");
		addressesPage.fillAdditionalInfo("TestAdditionalInfo");
		addressesPage.fillAddressTitle("Test Address");
	}
	
	public void saveAddress() {
		addressesPage.saveAddress();
	}

}
