package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {

	
	
	// DECLARATION
	

	/**
	 * This method contains elements and respective business livraries of Tesing page
	 */
	@FindBy(xpath="//h1[@class=\"page-header\"]")
	private WebElement pageheader;
	
	@FindBy(id="Python")
	private WebElement Pythonimg;
	
	@FindBy(id="cartArea")
	private WebElement mycartArea;
	
	@FindBy(xpath="//ul/descendant::i[@class=\"fa fa-facebook\"]")
	private WebElement fbIcon;
	
	
	//INKITIALIZATION
	
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//UTILIZATION
	
	/**
	 * Thos method is used to return the page header of testing page
	 * @return
	 */
	public String getPageHeader() {
		return pageheader.getText();
	}
	
	/**
	 * This method is used to to get python image
	 * @return 
	 */
	public WebElement getPythonImage() {
		return Pythonimg;
	}
	
	
	/**
	 * this method is used to get my cart area
	 * @return 
	 */
	public WebElement getMyCart() {
		return mycartArea;
	}
	
	
	/**
	 * This method is used to click on fb icon
	 * @return 
	 */
	public WebElement getfbIcon() {
		return fbIcon;
	}
	
	/**
	 * This method is used to click on fb icon
	 */
	public void clickfb() {
		fbIcon.click();
	}
}
