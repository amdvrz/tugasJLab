package qaautomation.august2021;

import org.testng.annotations.Test;

import qaautomation.august2021.pages.CommonPage;
import qaautomation.august2021.pages.MakeMyTrip;


public class MakeMyTrip2 extends BaseWebTest {
	MakeMyTrip makemytrip = new MakeMyTrip (driver,explicitWait);
	CommonPage commonpage = new CommonPage (driver,explicitWait);
	
	@Test
	public void tugasMakeMyTrip() {
		commonpage.openUrl("https://www.makemytrip.com/");
		String fromTerbang = "jakarta";
		String toTerbang = "denpasar bali";
		makemytrip.searchpenerbangan(fromTerbang,toTerbang);
	}
}
