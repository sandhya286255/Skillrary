package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebDriverUtility;

public class SkillraryDemoAppPage {

	
	
	//DECLARATION 
	
	
	
	/**
	 * This method contains elements and respective business librariesof skillrary demo app page
	 */
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement logo;
	
	
	@FindBy(id="course")
	private WebElement courseTab;
	
	
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	
	
	@FindBy(name="addresstype")
	private WebElement categoryDD;
	
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	
	
	
	
	//INITIALIAZATION
	
	
	
	public SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//UTILIAZATION
	
	
	/**
	 * This method is used to return text on the logo
	 * @return
	 */
	public String getLogoText() {
		return logo.getText();
	}
	
	/**
	 * This method is used to mousehover on course tab
	 */
	public void mousehoverToCourse(WebDriverUtility web) {
		web.mouseover(courseTab);
	}
	
	
	/**
	 * This method is used to click on selenium training
	 */
	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
	}
	
	
	/**
	 * This method is used to select the category from DD based on the index
	 * @param web
	 * @param index
	 */
	public void selectCategory(WebDriverUtility web, int index) {
		web.dropdown(categoryDD, index);
	}
	
	/**
	 * This method is iused to return contact us link
	 * @return
	 */
	public WebElement getContactUs() {
		return contactUsLink;
	}
	
	
	
	public void clickContactUs()
	{
		contactUsLink.click();
	}
}
