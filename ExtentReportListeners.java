package day52_listeners_extent_reports;

import org.testng.ITestListener;
import org.testng.internal.annotations.IListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListeners implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;   // UI user interface
	public ExtentReports extent;      // populating common details
	public ExtentTest test;   // make test entries - pass, fail, skip

    @Override
    public void onStart(ITestContext context) {
    	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\ExtentReport.html");
    	sparkReporter.config().setDocumentTitle("Automation Test Report");
    	sparkReporter.config().setReportName("Online Shopping Extent Report");
    	sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Pavan");
        extent.setSystemInfo("App Name", "OnlineShopping");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
