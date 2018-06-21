package model.email;

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
		driver = new ChromeDriver();
		waiter = new WebDriverWait(driver, 10);
	}
	
	/**
	 * 
	 * @param driver instance of navigator class
	 */
	/*
	private DriverElement(WebDriver driver, WebDriverWait waiter, String property1, String property2) {
		System.setProperty(property1, property2);
		this.driver = driver;
		this.waiter = waiter;
	}
	*/
	
	public static DriverElement getInstance() {
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
	public void waitUntilClickable(WebElement element) {
		waiter.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
