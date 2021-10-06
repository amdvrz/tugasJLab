package qaautomation.august2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import qaautomation.august2021.utils.TestUtility;
import qaautomation.august2021.pages.CommonPage;

public class YopmailTest extends BaseWebTest {
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	@Test
	public void testYopmail() {
		commonPage.openUrl("https://yopmail.com/en/");
		driver.get().findElement(By.id("login")).click();
		driver.get().findElement(By.id("login")).sendKeys("andhinyfatikha");
		driver.get().findElement(By.id("refreshbut")).click();
		driver.get().findElement(By.id("newmail")).click();
		driver.get().switchTo().frame(2);
		driver.get().findElement(By.id("msgto")).click();
		driver.get().findElement(By.id("msgto")).sendKeys("automationtest");
		driver.get().findElement(By.id("msgsubject")).click();
		driver.get().findElement(By.id("msgsubject")).sendKeys("andhinyfatikha");
		driver.get().findElement(By.id("msgbody")).click();
		driver.get().findElement(By.id("msgbody")).sendKeys("andhinyfatikha");
		TestUtility.hardWait(3);
		driver.get().findElement(By.id("msgsend")).click();
		TestUtility.hardWait(3);
		commonPage.navigateBrowser("back");
		TestUtility.hardWait(3);
		driver.get().findElement(By.id("login")).click();
		driver.get().findElement(By.id("login")).clear();
		driver.get().findElement(By.id("login")).sendKeys("automationtest");
		TestUtility.hardWait(3);
		driver.get().findElement(By.id("refreshbut")).click();
		driver.get().switchTo().frame(2);
		
		String getText = driver.get().findElement(By.xpath("//*[@id=\"mail\"]/div")).getText();
		System.out.println(getText);
	}
}
