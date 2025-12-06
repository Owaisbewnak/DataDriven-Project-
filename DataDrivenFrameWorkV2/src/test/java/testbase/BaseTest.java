package testbase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Keywords.ApplicationKeywords;
import reports.ExtentManager;
import runner.DataUtil;

public class BaseTest {
	public ApplicationKeywords app;
	public String number;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@BeforeTest
	public void beforeTest(ITestContext context) throws FileNotFoundException, IOException, ParseException {
		//System.out.println("******* Before Test *******");
		// Single App Object for Single Test
		// Initialize and Share for All the test cases
		
		
		// Read Test JSON
		String testdatajsonfilePath = context.getCurrentXmlTest().getParameter("testdatajsonfile");
		String dataFlag = context.getCurrentXmlTest().getParameter("dataflag");
		int iteration = Integer.parseInt(context.getCurrentXmlTest().getParameter("dataSetID"));
		
		JSONObject data = new DataUtil().getTestData(testdatajsonfilePath, dataFlag, iteration);
		context.setAttribute("testData", data);
		
		String runMode = (String) data.get("runmode");
		
		app = new ApplicationKeywords();
		

		// Init Reports
		extentReport = ExtentManager.getReports();
		extentTest = extentReport.createTest(context.getCurrentXmlTest().getName());
		extentTest.log(Status.INFO, "Starting Test : " + context.getCurrentXmlTest().getName());
		
		extentTest.log(Status.INFO, "Data :: " + data.toString());
		app.setReport(extentTest);
		
		context.setAttribute("extentReport", extentReport);
		context.setAttribute("extentTest", extentTest);
		
		if (!runMode.equalsIgnoreCase("Yes")) {
			extentTest.log(Status.SKIP, "RunMode in Test Data is not True");
			throw new SkipException("RunMode in Test Data is not True");
		}
		context.setAttribute("app", app);
	}	

	@AfterTest
	public void afterTest(ITestContext context) {
		//System.out.println("******* After Test *******");
		app = (ApplicationKeywords) context.getAttribute("app");
		if(app !=null) {
			app.quitDriver(); 
		}
		
		
		
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		if(extentReport != null) {
			extentReport.flush();
		}
		
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {
		//System.out.println("******* Before Method *******");
		app = (ApplicationKeywords) context.getAttribute("app");
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		extentTest = (ExtentTest) context.getAttribute("extentTest");
		
		String criticalFailure = (String) context.getAttribute("isCriticalFaliure");
		if (criticalFailure!=null && criticalFailure.equals("true")) {
			app.logSkip("Critical Failure in Previous Test Method");
			throw new SkipException("Critical Failure in Previous Test Method");
		}
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context) {
		
		app.reportAll();
	}

}
