package GeneralLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all reusable methods to perform operations on webdriver
 */
public class WebDriverUtility {

	
	private WebDriver driver;
	
	/**
	 * This method is used to launch the specified bowser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser){
		
		switch(browser) {
		
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
			default:
				System.out.println("Invalid Browser Info");
	}
		return driver;
}
	
	
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to navigate to an specific application
	 * @param url
	 */
	public void navigateToApp(String url) {
	driver.get(url);
}
	/**
	 * This method is used to wait until wlement or list of element is found
	 * @param time
	 */
	public void waituntilElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait until element is visible
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitwait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until element is visible 
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait until of web page is found
	 * @param title
	 * @param time
	 * @return
	 */
	public Boolean explicitwait(String title, long time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This mrthod is used to mouseover on an element
	 * @param element
	 */
	public void mouseover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
/**
 * This mrthod is used to double click on an element
 * @param element
 */
	public void doubleclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
/**
 * This mrthod is used to right click on an element
 * @param element
 */
	public void rightclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	
/**
 * This mrthod is used to right click on an element
 * @param element
 * @param dest 
 */
	public void drag_drop(WebElement element, WebElement dest) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element,dest).perform();
	}
	
	
	/**
	 * This method is used to switch the frame based on index
	 * @param index 
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch the frame based on id or name
	 * @param index 
	 * @param idOrName 
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * This method is used to switch the frame based on frame element
	 * @param frameElement 
	 * @param index 
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	
	/**
	 * This method is used to switch back
	 * @param index 
	 */
	public void switchToFrame() {
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * Thos method is used to Take screen shot of web page
	 */
	public void takess() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".Screenshots/screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
		}catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to scroll till the element 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true)", element);
	}
	
	
	
	/**
	 * This method selects an element from drop down using value
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	

	/**
	 * This method selects an element from drop down using value
	 * @param value
	 * @param element
	 */
public void dropdown(String value, WebElement element) {
	Select s= new Select(element);
	s.selectByValue(value);
}


/**
 * This method selects an element from drop down using text
 * @param element
 * @param text
 */
public void dropdown(WebElement element,String text) {
	Select s= new Select(element);
	s.selectByVisibleText(text);
}

/**
 * This method handles alert popup
 * @param status
 */
public void  handleAlert(String status) {
	Alert al= driver.switchTo().alert();
	if(status.equalsIgnoreCase("ok"))
	al.accept();
	else
		al.dismiss();
}

/**
 * This method is used to switch to parent window
 */
public void switchToParentWindow() {
	String parentID= driver.getWindowHandle();
	driver.switchTo().window(parentID);
}

/**
 * This method is to hasndle child broser
 */
public void handleChildBrowser() {
	Set<String> set=driver.getWindowHandles();
	for (String id : set)
		driver.switchTo().window(id);			
}

/**
 * This method ios used to close current window
 */
public void closeCurrentTab() {
	driver.close();
}

/**
 * This method is used to quit all the windows
 */
public void quitAllWindows() {
	driver.quit();
}


}












