package model.email;

import model.email.EmailLoginPage;

public class Main {
	public static void main(String[] args) {
		EmailLoginPage emailHandler = EmailLoginPage.getInstance();
		emailHandler.login("asimovqa.robot@gmail.com", "asi@sky1");

	}
}
