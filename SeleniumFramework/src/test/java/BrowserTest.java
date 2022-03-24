import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path : "+ projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
		
	    //WebDriver driver = new FirefoxDriver(); 
		
		//System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		
        System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.manage().window().maximize();
		
		//System.setProperty("webdriver.ie.driver", projectPath + "\\drivers\\iedriver\\IEDriverServer.exe");
		
		//WebDriver driver = new InternetExplorerDriver();
		
		//driver.get("https://www.google.com/");
		
		//driver.findElement(By.className("gLFyf gsfi")).sendKeys("Hello World");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd.com");
		
		List<WebElement> listofInputElements = driver.findElements(By.xpath("//input"));
		
		int count = listofInputElements.size();
		
		System.out.println("Count of Input Elements = "+count);
		
		//WebElement textBox = driver.findElement(By.id("email"));
	    
		//textBox.sendKeys("pranamitaguha@gmail.com");
		
        WebElement textBox2 = driver.findElement(By.id("pass"));
	    
		textBox2.sendKeys("pranamitaguha");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		} 

}
 