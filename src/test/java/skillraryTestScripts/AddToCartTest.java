package skillraryTestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GeneralLibraries.BaseClass;

public class AddToCartTest extends BaseClass  {

	@Test
	public void addTocartRest() {
		SoftAssert soft = new SoftAssert();
		
	home.clickGearsTab();
	home.clickSkillraryDemoApp();
	web.handleChildBrowser();
	
		soft.assertTrue(demoApp.getLogoText().contains("Ecommerce"));
		demoApp.mousehoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		
		soft.assertEquals(selenium.getPageHeader(), "selenium TYraining");
		
		int intialquantity = Integer.parseInt(selenium.getQuantity());
		selenium.doubleClickPlusButton(web);
	int finalQuantity = Integer.parseInt(selenium.getQuantity());
	soft.assertEquals(finalQuantity, intialquantity+1);
	
	
	selenium.clickaddToCart();
	web.handleAlert("ok");
	soft.assertEquals(selenium.getMessage(), "Item added to cart");
	
	soft.assertAll();
	}
}
