package model.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class encapsulate a WebDriver and a WebDriverWait instance, keeping both at the only ones instances of each in the system 
 */
public class DriverElement {
	
	private static DriverElement instance;
	private WebDriver driver;
	private WebDriverWait waiter;
	
	private DriverElement() {
		String globalpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", globalpath+"//Libraries\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver = new ChromeDriver();
		waiter = new WebDriverWait(driver, 10);
	}
	
	
	//With this structure we could implement a constructor to set the wait time,
	//the load page and the WebDriver
	/*
	private DriverElement(WebDriver driver, WebDriverWait waiter, String property1, String property2) {
		System.setProperty(property1, property2);
		this.driver = driver;
		this.waiter = waiter;
	}
	*/
	
	public synchronized static DriverElement getInstance() {
		if(instance == null) {
			instance = new DriverElement();
		}
		return instance;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void waitUntilClickable(By.ByXPath xpath) {
		waiter.until(ExpectedConditions.elementToBeClickable(xpath));
	}
	public void waitUntilReady(By.ByXPath xpath) {
		WebElement element = driver.findElement(xpath);
		while(!(element.isEnabled()&&(element.isDisplayed()))) {
			System.out.println("Waiting for "+ xpath.toString());
		}
	}
	public void waitUntilClickable(WebElement element) {
		waiter.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
