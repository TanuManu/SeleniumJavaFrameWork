package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
			}
	
	public static void googleSearch() {

		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

//go to google.com in chrome browser
		driver.get("https://www.google.com/");
		
//enter text in search box
		//driver.findElement(By.name("q")).sendKeys("Bosch India");
		GoogleSearchPage.textbox_search(driver).sendKeys("Bosch India");
		
//click search but due to auto suggestion it is not able to find the key
		//driver.findElement(By.name("btnK")).click();
// lets try to press enter
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		GoogleSearchPage.button_search(driver).sendKeys(Keys.ENTER);

//close browser
		driver.close();
		
		System.out.println("Test Successful");
		
	
	}

}
