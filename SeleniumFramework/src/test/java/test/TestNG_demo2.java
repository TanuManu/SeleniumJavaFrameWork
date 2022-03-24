package test;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_demo2 {
	
	
	
	WebDriver driver = null;
	
	
	@BeforeTest
	public void setupTest() {
		
		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension",false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		driver = new ChromeDriver(options);
		
	
	}
	
	
	
	@Test
	public void googleSearch2() {


//go to google.com in chrome browser
		driver.get("https://www.google.com/");
		
//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Bosch India");
		
//click search but due to auto suggestion it is not able to find the key
		//driver.findElement(By.name("btnK")).click();
// lets try to press enter
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
}
	@Test
	public void googleSearch3() {


//go to google.com in chrome browser
		driver.get("https://www.google.com/");
		
//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation");
		
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
		
	}

}
