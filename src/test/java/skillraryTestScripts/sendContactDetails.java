package skillraryTestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GeneralLibraries.BaseClass;

public class sendContactDetails extends BaseClass{

	
	@Test
	
	public void sendcontactDetais() {
		SoftAssert soft = new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(demoApp.getLogoText().contains("Ecommerce"));

	  web.scrollToElement(demoApp.getContactUs());
	  demoApp.clickContactUs();
	  
	  soft.assertTrue(contact.getPageLogo().isDisplayed());
	  
	  home.chooseEnglish();
	 Map<String ,String > map = excel.readData("sheet1");
	  contact.sendDetails(map.get("fullname"), map.get("email"), map.get("subject"), map.get("message"));
       
	soft.assertAll();
	
	}
}
