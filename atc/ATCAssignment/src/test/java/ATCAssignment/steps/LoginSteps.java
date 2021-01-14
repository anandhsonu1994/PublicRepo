package ATCAssignment.steps;

import org.openqa.selenium.WebDriver;

import ATCAssignment.pages.LoginPage;

public class LoginSteps {
	
	LoginPage loginPage;
	
	public LoginSteps(WebDriver driver) {
		loginPage = new LoginPage(driver);
	}
	
	public void signIn(String maildId, String pwd) {
		loginPage.gotoSignInPage();	
		loginPage.enterCredentials(maildId, pwd);
	}
	
	public void signOut() {
		loginPage.clickSignOut();
	}
}
