package qaautomation.august2021.pages;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip extends BasePage {
	By fromWhere = By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]/div[2]");
	By fromUrl = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]");
	By fromAdd = By.xpath("//input[@placeholder='From']");
	By fromTerbang = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div/div/input");
	By fromInput = By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//p[@class='font14 appendBottom5 blackText'][normalize-space()='Jakarta, Indonesia']");
	
	By toTerbang = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input");
	By toInput = By.xpath("//p[normalize-space()='Denpasar Bali, Indonesia']");
	
	By dateInput = By.xpath("//div[@aria-selected='true']//div[@class='dateInnerCell']");
	
	By klikSearch = By.xpath("//a[normalize-space()='Search']");
	
	By getInput = By.xpath("//*[@id=\"listing-id\"]/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div/div/p");
	
	public MakeMyTrip(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void searchpenerbangan(String from, String to) {
		clickAndWaitByXpath(fromWhere);
		clickAndWaitByXpath(fromUrl);
		clickAndWaitByXpath(fromAdd);
		setText(fromTerbang, from);
		clickAndWaitByXpath(fromInput);
		setText(toTerbang, to);
		clickAndWaitByXpath(toInput);
		clickAndWaitByXpath(dateInput);
		clickAndWaitByXpath(klikSearch);
		
		getText(getInput);
		String ambil = getText(getInput);
		
		Pattern p = Pattern.compile("\\d+");
	    Matcher m = p.matcher(ambil);
	    while(m.find()) {
	       System.out.print(m.group());
	       
	}
}
	}
