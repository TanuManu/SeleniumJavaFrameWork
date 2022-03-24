package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;

 public static void main(String[] args) {
	 
	 googlesearchtest();
	
}
	public static void googlesearchtest ()
	{
	String projectpath = System.getProperty("user.dir");
	System.out.println(projectpath);
	System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	
	GoogleSearchPageObject searchPageobj = new GoogleSearchPageObject(driver);
	
	driver.get("https://www.google.com/");
	
	searchPageobj.setTextInSearchBox("Bosch India");
	searchPageobj.clickSearchButton();
	
	
	driver.close();
	
	
	}

}
