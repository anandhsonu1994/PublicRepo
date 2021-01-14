package ATCAssignment.steps;

import org.openqa.selenium.WebDriver;

import ATCAssignment.pages.ProfilePage;

public class ProfileSteps {
	
	ProfilePage profilePage;
	
	public ProfileSteps(WebDriver driver) {
		profilePage = new ProfilePage(driver);
	}
	
	public void gotoProfilePage() {
		profilePage.clickProfileLink();
	}
	
	public void gotoOrderHistoryPage() {
		profilePage.clickOrderHistoryLink();
	}

}
