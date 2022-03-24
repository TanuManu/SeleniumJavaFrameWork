import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {
	
	public static void main(String[] args) {
		
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
        @SuppressWarnings("deprecation")
		WebDriver driver = new InternetExplorerDriver(caps);
        
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Kolkata");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        
        driver.close();
        driver.quit();
        
        
		
	}
	

}
