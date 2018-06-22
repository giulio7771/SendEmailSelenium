package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import model.pages.email.EmailLoginPage;

public abstract class Page {

	protected DriverElement driver;

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
	public boolean writeOnWith(By.ByXPath xpath, String value) {
		// try {
		WebElement field = null;

		while (field == null) {
			try {
				field = driver.getDriver().findElement(xpath);
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}

		driver.waitUntilReady(xpath);
		driver.waitUntilClickable(field);
		field.sendKeys(value);
		// } catch (Exception e) {
		// System.out.println("Error during fillFieldWaiting by EmailLoginPage" +
		// e.getMessage());
		// System.out.println("DriverElement var state: " + driver.toString());
		// System.out.println("'xpath' param value: " + xpath.toString());
		// System.out.println("'value' param value: " + value);
		// return false;
		// }
		//
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
	public void click(By.ByXPath xpath) {
		// try {
		WebElement button = driver.getDriver().findElement(xpath);
		driver.waitUntilClickable(button);
		while (true) {
			try {
				button = driver.getDriver().findElement(xpath);
				button.click();
				return;
			} catch (StaleElementReferenceException e) {
				System.out.println("staleElementReferenceException on click");

			} catch (NoSuchElementException e) {
				System.out.println("no such element exception");
			} catch (Exception e) {
				System.out.println("other exception on click");
			}finally{
				button = driver.getDriver().findElement(xpath);
				
			}
		}
		// } catch (Exception e) {
		// System.out.println("Error during clickdWaiting by EmailLoginPage." +
		// e.getMessage());
		// System.out.println("DriverElement var state: " + driver.toString());
		// System.out.println("xpath param value: " + xpath.toString());
		// return false;
		// }
		
	}

	public void submit(By.ByXPath xpath) {
		driver.getDriver().findElement(xpath).submit();
	}

}
