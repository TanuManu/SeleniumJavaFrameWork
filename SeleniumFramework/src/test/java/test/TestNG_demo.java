package test;

import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_demo {



	WebDriver driver = null;
	public static String BrowserName = null;


	@BeforeTest
	public void setupTest() {

		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		PropertiesFile.getProperties();

		if( BrowserName.equalsIgnoreCase("chrome"))
		{System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();


		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension",false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		driver = new ChromeDriver(options);
		}

		else if( BrowserName.equalsIgnoreCase("firefox"))
		{System.setProperty("webdriver.gecko.driver", projectpath + "/drivers/geckodriver/geckodriver.exe");
		 driver = new FirefoxDriver();

		}

	}



	@Test
	public void googleSearch() {


		//go to google.com in chrome browser
		driver.get("https://www.google.com/");

		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Bosch India");

		//click search but due to auto suggestion it is not able to find the key
		//driver.findElement(By.name("btnK")).click();
		// lets try to press enter
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@AfterTest
	public void teardownTest() {


		//close browser
		driver.close();
		driver.quit();
		

		System.out.println("Test Successful");
		PropertiesFile.setProperties();

	}

}
