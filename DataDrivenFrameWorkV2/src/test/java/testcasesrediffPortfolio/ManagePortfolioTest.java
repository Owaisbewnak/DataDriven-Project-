package testcasesrediffPortfolio;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import testbase.BaseTest;

public class ManagePortfolioTest extends BaseTest{

	@Test
	public void createPortfolio(ITestContext context) {
		JSONObject data = (JSONObject) context.getAttribute("testData");
		String portfolioName = (String) data.get("portfolioname");

		app.logInfo("Creating Portfolio ::" + portfolioName);
		app.click("createPortfolio_id");
		app.clear("portfolioname_id");
		app.type("portfolioname_id", portfolioName);
		app.click("createPortfolioButton_id");
		app.waitforWebPageToLoad();
		app.validateSelectedValueInDropDown("portfolioid_dropdown_id",portfolioName);
	
	}
	
	@Test
	public void deletePortfolio(ITestContext context) {
		JSONObject data = (JSONObject) context.getAttribute("testData");
		String portfolioName = (String) data.get("portfolioname");
		
		app.logInfo("Deleting Portfolio :: " + portfolioName);
		app.selectByVisibleText("portfolioid_dropdown_id", portfolioName);
		app.waitforWebPageToLoad();
		app.click("deletePortfolio_id");
		app.acceptAlert();
		app.waitforWebPageToLoad();
		app.validateSelectedValueNotInDropDown("portfolioid_dropdown_id",portfolioName);
	}
	
	@Test
	public void selectePortfolio(ITestContext context) {
		String portfolioName = "Portfolio30";
		app.logInfo("Selecting Portfolio :: " + portfolioName);
		app.selectByVisibleText("portfolioid_dropdown_id", portfolioName);
		app.waitforWebPageToLoad();
	}
}
