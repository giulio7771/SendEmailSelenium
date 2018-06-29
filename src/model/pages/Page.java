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
	 */
	public void writeOnWith(By.ByXPath xpath, String value) {
		// try {
		WebElement field = null;

		for (int i = 0; i < 60; i++) {

			try {
				field = driver.getDriver().findElement(xpath);
				break;
			} catch (NoSuchElementException e) {

				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(e.getMessage());
			}
			// With the last iteration of the for loop and nothing was found we throw the
			// exception
			if (i == 59) {
				throw new NoSuchElementException("After 60 times trying to find this element we couldn't");
			}

		}
		// deprecated way to wait for the WebElement gets ready
		// while (field == null) {
		// try {
		// field = driver.getDriver().findElement(xpath);
		// } catch (NoSuchElementException e) {
		// System.out.println(e.getMessage());
		// }
		// }

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
	}

	/**
	 * This method click on any clickable element after waits for it become
	 * clickable until 10 seconds
	 * 
	 * @param xpath
	 *            Any clickable element
	 */
	public void click(By.ByXPath xpath) {
		// try {
		WebElement button = driver.getDriver().findElement(xpath);
		driver.waitUntilClickable(button);

		for (int i = 0; i < 60; i++) {

			try {
				button = driver.getDriver().findElement(xpath);
				button.click();
				return;
			} catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println("staleElementReferenceException on click");

			} catch (NoSuchElementException e) {
				System.out.println("no such element exception");
			} catch (Exception e) {
				System.out.println("other exception on click");
			} finally {
				button = driver.getDriver().findElement(xpath);

			}
			if (i == 59) {
				throw new NoSuchElementException("After 60 times trying to find this element we couldn't");
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

	/**
	 * This methos submit any submitable WebElement
	 * 
	 * @param xpath
	 *            The xpath mail to be submited
	 */
	public void submit(By.ByXPath xpath) {
		driver.getDriver().findElement(xpath).submit();
	}

}
