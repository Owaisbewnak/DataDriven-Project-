package testCases;

import org.testng.annotations.Test;

import Keywords.ApplicationKeywords;

public class CreatePortfolioTest extends ApplicationKeywords{
	
	@Test
	public void createPortfolioTest() {
		/*
		 * 1. Open Target WebPage
		 * 2. Click on SignIn Button/link
		 * 3. Enter Login Details 
		 * 4. Click on Submit Button 
		 * 5. Verify you are on Portfolio Page after login
		 * 6. Click Create Portfolio Link
		 * 7. Enter the Portfolio Name 
		 * 8. Click on Create Portfolio Link 
		 */
	
		
		ApplicationKeywords app = new ApplicationKeywords();
		
		app.openBrowser("browser_name");
		app.openURL("URL");
		app.click("signIn_linkText");
		app.type("userName_id","owais1416@rediffmail.com");		
		app.type("password_xpath","Test@1416");
		app.enterCaptcha("captcha_css");
		app.clickButton("submitBtn_name");
		//app.validateTitle("My Portfolio(s) | Rediff Moneywiz");
		
		
		
		
	}
}
