package main;

import model.pages.email.EmailLoginPage;

public class Main {
	public static void main(String[] args) {
		EmailLoginPage emailHandler = EmailLoginPage.getInstance();
		emailHandler.login("asimovqa.robot@gmail.com", "asi@sky1");

	}
}
