package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {
	
	@Test
	public void test1() {
		System.out.println("I am inside Test 4");
	}

	@Test
	public void test2() {
		System.out.println("I am inside Test 5");
	    String projectPath = System.getProperty("user.dir");
	   System.setProperty("WebDriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.findElement(By.name("q")).sendKeys("Apple");
	driver.findElement(By.name("abc")).sendKeys("Orange");
	driver.close();
	}

	@Test
	public void test3() {
		System.out.println("I am inside Test 6");
		throw new SkipException("This test is skipped");
	}

}
