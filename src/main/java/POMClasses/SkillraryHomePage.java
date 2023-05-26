package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {

	
	
	// DECLARATION
	
	
	/**
	 * This method contains elements and respective  business libraries of skillrary demo app
	 */
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;
	
	
@FindBy(xpath="//a[text()=' GEARS ']")
private WebElement gearsTab;


@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]/descendant::a[text()=' SkillRary Demo APP']")
private WebElement skillraryDemoAppLink;

@FindBy(xpath="//ul[contains(@class,'home_menu')]/li[1]")
private WebElement language;


@FindBy(xpath="//ul[contains(@class,'home_menu')]/descendant::a[text()=' English']")
private WebElement english;


//INITIALIZATION



public SkillraryHomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}



//UTILIAZATION



/**
 * This method returns skillrary home page logo
 * @return
 */
public WebElement getLogo() {
	return logo;
}

/**
 * This method is used to click on gears tab
 */
public void clickGearsTab() {
	gearsTab.click();
}

/**
 * This method is used to click on skillrary demo app link
 */
public void clickSkillraryDemoApp() {
	skillraryDemoAppLink.click();		
}

/**
 * This method is used to select english as default
 */
public void chooseEnglish() {
	language.click();
	english.click();
}
}





