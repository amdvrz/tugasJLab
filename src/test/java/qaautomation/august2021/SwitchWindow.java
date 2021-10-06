package qaautomation.august2021;

import org.testng.annotations.Test;

import qaautomation.august2021.pages.CommonPage;

public class SwitchWindow extends BaseWebTest {
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Test
	public void testSwitchingWindow() {
		commonPage.openNewWindow();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://pinterest.com");
	}

}
