package testcasesrediffPortfolio;
import org.testng.annotations.Test;
import testbase.BaseTest;

public class ManageSessionTest extends BaseTest {
	
	

	@Test
	public void doLogin() {
		
		
		app.logInfo("Login Application");
		
		app.openBrowser("browser_name");
		app.openURL("URL");
		app.click("signIn_linkText");
		app.type("userName_id","owais1416@rediffmail.com");	
		app.type("password_xpath","Test@1416");
		//app.enterCaptcha("captcha_css");
		app.wait(30);
		app.clickButton("submitBtn_name");
		app.reportAll();
		
		
	}

	@Test
	public void doLogOut() {
		System.out.println("******* LogOut Application *******");
		//ApplicationKeywords app = new ApplicationKeywords();
	}
}
