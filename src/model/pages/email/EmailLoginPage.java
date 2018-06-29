package model.pages.email;

import org.openqa.selenium.By;

import org.openqa.selenium.By.ByXPath;

import model.pages.DriverElement;
import model.pages.Page;


public class EmailLoginPage extends Page{

	protected static EmailLoginPage instance;
	
	
	private By.ByXPath usernameField = (ByXPath) By.xpath("//input[@type = 'email' and @autocomplete = 'username']");
	
	private By.ByXPath usernameButton = (ByXPath) By.xpath("//div/div/div/div/div/div/div/content/span[contains(text(),'Próxima')]");
	
	private By.ByXPath passwordField = (ByXPath) By.xpath("//div[@id = 'password']/div/div/div/input[@type = 'password' and @autocomplete = 'current-password']");
	
	private By.ByXPath passwordButton = (ByXPath) By.xpath("//div/div[@role = 'button']/content/span[contains(text(), 'Próxima')]");

	private EmailLoginPage() {
		driver = DriverElement.getInstance();
		driver.getDriver().get("https://www.gmail.com");
	}

	/**
	 * This method with constructor private encapsulate makes the system does not
	 * run more than one instance of this class
	 * 
	 * @return The instance of EmailLoginPage
	 */
	public synchronized static EmailLoginPage getInstance() {
		if (instance == null) {
			instance = new EmailLoginPage();
		}
		return instance;
	}




	/**
	 * This method encapsulate all the tags about a login process at the email by
	 * Google process
	 * 
	 * @param username
	 *            The electronic email of the user
	 * @param password
	 *            The password of the user
	 * @return True if all ran successful, false if it did not
	 */
	public boolean login(String username, String password) {
		writeOnWith(usernameField, username);
		click(usernameButton);
		writeOnWith(passwordField, password);
		click(passwordButton);
		//submit(passwordField);
		
		
		//		try {
//			if (toFill(usernameField, username)) {
//				if (click(usernameButton)) {
//					if (toFill(passwordField, password)) {
//						if (click(passwordButton)) {
//							return true;
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			//System.out.println("Error during loginning by EmailLoginPage" + e.getMessage());
//			System.out.println("DriverElement var state: " + driver.toString());
//			System.out.println("username param value: " + username);
//			System.out.println("password param value: " + password);
//			//return false;
//		}
		return false;
	}
	

}
