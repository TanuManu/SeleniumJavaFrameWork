package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_Search1 {
	
	public static void main(String[] args) {
		googleSearch();
			}
	
	public static void googleSearch() {

		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//go to google.com in chrome browser
		driver.get("https://www.google.com/");
		
//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Bosch India");
		
//click search but due to auto suggestion it is not able to find the key
		//driver.findElement(By.name("btnK")).click();
// lets try to press enter
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

//close browser
		driver.close();
		
		System.out.println("Test Successful");
		
	
	}

}
