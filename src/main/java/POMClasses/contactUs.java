package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactUs {

	
	
	//DECLARATION
	
	

	/**
	 * This method contains elements and respective business livbaries of contact us page
	 */
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement pageLogo;
	
	@FindBy(name="name")
	private WebElement fullNameTF;
	
	@FindBy(name="sender")
	private WebElement emailTF;
	
	@FindBy(name="subject")
	private WebElement subTF;
	
	@FindBy(name="message")
	private WebElement msgTF;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendMailButton;
	
	
	//INITIALIZATION
	
	
	public contactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//UTILIAZATION
	
	/**
	 * This method returns contact us page logo
	 * @return 
	 */
	public WebElement  getPageLogo() {
		return pageLogo;
	}
	
	
	/**
	 * This method is used to send contact details
	 * @param fullname 
	 * @param email 
	 * @param subject 
	 * @param message 
	 */
	public  void sendDetails(String fullname, String email, String subject, String message) {
		fullNameTF.sendKeys(fullname);
		emailTF.sendKeys(email);
		subTF.sendKeys(subject);
		msgTF.sendKeys(message);
		sendMailButton.click();
		
	}
}






