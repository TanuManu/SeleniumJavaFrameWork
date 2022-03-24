package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:/Java Projects/SeleniumFramework/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.filemail.com/share/upload-file");
		driver.findElement(By.id("addBtn")).click();

		Runtime.getRuntime().exec("C:/Users/Pranamita Guha/OneDrive/Desktop/AuToIT/demofilescript.exe");


		Thread.sleep(3000);

		//driver.close();

	}

}
