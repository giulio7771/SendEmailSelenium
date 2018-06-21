package model.email;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;

public class EmailLoginPage {

	private static EmailLoginPage instance;

	private DriverElement driver;
	private By.ByXPath usernameField = (ByXPath) By.xpath("//input[@type = 'email' and @autocomplete = 'username']");
	private By.ByXPath usernameButton = (ByXPath) By
			.xpath("//div/div/div/div/div/div/div/content/span[contains(text(),'Próxima')]");
	private By.ByXPath passwordField = (ByXPath) By.xpath(
			"//div[@id = 'password']/div/div/div/input[@type = 'password' and @autocomplete = 'current-password']");
	private By.ByXPath passwordButton = (ByXPath) By
			.xpath("//div/div[@role = 'button']/content/span[contains(text(), 'Próxima')]");

	private EmailLoginPage() {
		driver = DriverElement.getInstance();
		driver.getDriver().get("https://www.gmail.com");
	}
/**
 * This methos with constructor private encapsulate makes the system does not run more than one 
 * instance of this class
 * @return The instance of EmailLoginPage
 */
	public static EmailLoginPage getInstance() {
		if (instance == null) {
			instance = new EmailLoginPage();
		}
		return instance;
	}

	/**
	 * This method fill any WebElement that can run .sendKeys(), with the String
	 * param value, waiting it be clickable first until 10 seconds
	 * 
	 * @param xpath
	 *            Any field to be filled
	 * @param value
	 *            String text to fill the field
	 * @return True if all ran successful, false if it did not
	 */
	public boolean fillFieldWaiting(By.ByXPath xpath, String value) {
		try {
			WebElement field = driver.getDriver().findElement(xpath);
			driver.waitUntilClickable(field);
			field.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Error during fillFieldWaiting by EmailLoginPage" + e.getMessage());
			System.out.println("DriverElement var state: " + driver.toString());
			System.out.println("'xpath' param value: " + xpath.toString());
			System.out.println("'value' param value: " + value);
			return false;
		}
		return true;
	}

	/**
	 * This method click on any clickable element after waits for it become
	 * clickable until 10 seconds
	 * 
	 * @param xpath
	 *            Any clickable element
	 * @return True if all ran successful, false if it did not
	 */
	public boolean clickWaiting(By.ByXPath xpath) {
		try {
			WebElement button = driver.getDriver().findElement(xpath);
			driver.waitUntilClickable(button);
			button.click();
		} catch (Exception e) {
			System.out.println("Error during clickdWaiting by EmailLoginPage." + e.getMessage());
			System.out.println("DriverElement var state: " + driver.toString());
			System.out.println("xpath param value: " + xpath.toString());
			return false;
		}
		return true;
	}

	/**
	 * This methos encapsulate all the tags about a login process at the email by
	 * Google process
	 * 
	 * @param username
	 *            The eletronic email of the user
	 * @param password
	 *            The password of the user
	 * @return True if all ran successful, false if it did not
	 */
	public boolean login(String username, String password) {
		try {
			if (fillFieldWaiting(usernameField, username)) {
				if (clickWaiting(usernameButton)) {
					if (fillFieldWaiting(passwordField, password)) {
						if (clickWaiting(passwordButton)) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error during loginning by EmailLoginPage" + e.getMessage());
			System.out.println("DriverElement var state: " + driver.toString());
			System.out.println("username param value: " + username);
			System.out.println("password param value: " + password);
			return false;
		}
		return false;
	}

}
