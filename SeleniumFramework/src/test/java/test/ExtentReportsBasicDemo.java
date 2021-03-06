package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
	
	//create extent reports and attach reporter(s)
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
		
	
	// create a toggle for the given test, add all logs under it
	ExtentTest test1 = extent.createTest("Google Search Test One", "To test google search functionality");
	
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	
	test1.log(Status.INFO, "Starting Test Case");
	
	driver.get("https://www.google.com");
	
	test1.pass("Navigated to google.com");
	
	driver.findElement(By.name("q")).sendKeys("Kolkata");
	
	test1.pass("Entered text in search box"); 	

	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	test1.pass("Pressed Keyboard enter Key");
	
	driver.close();
	driver.quit();
	
	test1.pass("Closed the browser");
	test1.info("Test Finished");
	
	//test2
ExtentTest test2 = extent.createTest("Google Search Test One", "To test google search functionality");
	
	System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	
	test2.log(Status.INFO, "Starting Test Case");
	
	driver.get("https://www.google.com");
	
	test2.pass("Navigated to google.com");
	
	driver.findElement(By.name("q")).sendKeys("Kolkata");
	
	test2.pass("Entered text in search box"); 	

	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	test2.fail("Pressed Keyboard enter Key");
	
	driver.close();
	driver.quit();
	
	test2.pass("Closed the browser");
	test2.info("Test Finished");
	
	//calling flush writes everything to the log file
	extent.flush();
	
	}
}
