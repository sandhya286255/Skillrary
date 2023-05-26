package skillraryTestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GeneralLibraries.BaseClass;

public class addPythonToMyCart extends BaseClass {

	
	@Test
	public void addpythontomycart() {
		SoftAssert soft = new SoftAssert();
		
	home.clickGearsTab();
	home.clickSkillraryDemoApp();
	web.handleChildBrowser();
	
	soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		
	
	demoApp.selectCategory(web, 1);
	soft.assertEquals(testing.getPageHeader(), "TESTING ");

	web.scrollToElement(testing.getPythonImage());
	web.drag_drop(testing.getPythonImage(),testing.getMyCart());
	
	web.scrollToElement(testing.getfbIcon());
	testing.clickfb();
	
	
	
	soft.assertAll();
	
	
	
	}
}
