package GeneralLibraries;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMClasses.SeleniumTrainingPage;
import POMClasses.SkillraryDemoAppPage;
import POMClasses.SkillraryHomePage;
import POMClasses.TestingPage;
import POMClasses.contactUs;

public class BaseClass {

	

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected contactUs contact;
	
	//@BeforeSuite
	//@BeforeTest
	
	
	@BeforeClass
	public void classconfig() {
		
		property= new PropertiesUtility();
		excel =new ExcelUtility();
		web = new WebDriverUtility();
		
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
	}
	
	
	@BeforeMethod
	
	public void methodconfig() {
		 driver = web.launchBrowser(property.readData("browser"));
		 web.maximizeBrowser();
		 web.navigateToApp("url");
		 web.waituntilElementFound(Long.parseLong(property.readData("time")));
		 
		 
		 home= new SkillraryHomePage(driver);
		 demoApp = new SkillraryDemoAppPage(driver);
		 selenium = new SeleniumTrainingPage(driver);
		 testing = new TestingPage(driver);
		 contact = new contactUs(driver);
		 
		 
		 home.chooseEnglish();    
	}
	
	
	@AfterMethod
	
	public void methodTearDown() {
		web.quitAllWindows();
	}
	
	@AfterClass
	
	public void classTearDown() {
		excel.closeExcel();
	}
	//@AfterTest
//	@AfterSuite
	
}
