package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver= null;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) {
		System.out.println("Browser Name is:" + browsername);
		System.out.println("Thread ID:" + Thread.currentThread().getId());

		if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",projectPath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",projectPath + "/drivers/iedriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} 
	}

	@Test
	public void test1() throws Exception {

		driver.get("https://www.google.com");
		Thread.sleep(4000);
	}

	@AfterTest

	public void tearDown() {
		driver.close();
		System.out.println("Test Completed Successfully");

	}

}
