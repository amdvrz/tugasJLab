package qaautomation.august2021;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import qaautomation.august2021.pages.LoginPage;
import qaautomation.august2021.pages.ProfilePage;

public class FailedTest extends BaseWebTest {
	
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);

	@Test(testName = "verify login is failed", description = "login will be failed")
	public void test() {
		String username = "fullstackdemo";
		String password = "fullstackdemo";

		loginPage.login(username, password);
		String failedTest = profilePage.getProfileText(username) + "failed";
		System.out.println("failed username =" + failedTest);
		assertEquals(failedTest, username);

	}

}
