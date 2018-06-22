package main;

import model.pages.EmailPage;
import model.pages.email.EmailLoginPage;

public class Main {
	public static void main(String[] args) {
		//To manipulate all the emails pages we must only call the EmailPage
		//and it will control all the actions to us
		EmailPage email = EmailPage.getInstance();
		email.loginWith("asimovqa.robot@gmail.com", "asi@sky1");

	}
}
