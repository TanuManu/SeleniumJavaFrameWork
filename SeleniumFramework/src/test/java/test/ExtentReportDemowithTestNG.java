package test;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemowithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}
	
	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws Exception {

		ExtentTest test = extent.createTest("My First Test","Sample Test");
		driver.get("https://www.google.com");
		test.pass("Navigated to google.com");
		
		 // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");

	}
	
	@Test
	public void test2() throws Exception {

		ExtentTest test = extent.createTest("My First Test","Sample Test");
		 // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest
	public void afterTest() {
		 driver.close();
		 driver.quit();
		 System.out.println("Test Completed");
	}

	@AfterSuite
	public void teardown() {
		extent.flush();

	}
}
