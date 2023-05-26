package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralLibraries.WebDriverUtility;

public class SeleniumTrainingPage {

	
	
	//DECLARATION
	
	
	
	/**
	 * This method contains elements and respective business livraries of selenium Training page
	 */
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageheader;
	
	
	
	@FindBy(id="add")
	private WebElement plusButton;
	
	
	@FindBy(id="quantity")
	private WebElement quantity;
	
	
	@FindBy(xpath="//button[.=' Add to Cart']")
	private WebElement addToCart;
	
	
	@FindBy(xpath="//div[@class='callout callout-success']/span")
	private WebElement message;
	
	//INITIALIZATION
	
	
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		// UTILIZATION
		
		/**
		 * This method returns page header of selenium training page
		 */
		public String getPageHeader() {
			return pageheader.getText();
		}
			
			/**
			 * This metod is used to double click pon plus button
			 */
			public void doubleClickPlusButton(WebDriverUtility web) {
				web.doubleclick(plusButton);
			}
		
			
			/**
			 * This method is used to get the quantity of added items
			 * @return
			 */
			public String getQuantity() {
				return quantity.getAttribute("value");
				
			}
			
			/**
			 * This method is used to click on the add to cart button
			 */
			public void clickaddToCart() {
				addToCart.click();
			}
			
			/**
			 * This method is used to get the text on the item added message
			 * @return
			 */
			public String getMessage() {
				return message.getText();
			}
			
			
			
	}

