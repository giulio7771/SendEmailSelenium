package model.pages;

import model.pages.email.EmailLoginPage;

public class EmailPage {
	static private EmailPage instance; 
	private EmailLoginPage login;
	 
	
	 private EmailPage() {
		 
	 }
	 
	 public synchronized static EmailPage getInstance() {
		 if(instance == null) {
			 instance = new EmailPage();
		 }
		 return instance;
	 }
	 /**
	  * This method do all login process on google email page
	  * @param username
	  * 			E-mail of the account
	  * @param password
	  * 			Password of the account
	  */
	 public void loginWith(String username, String password) {
		 EmailLoginPage.getInstance().login(username, password);
		 
	 }
	
	
}
