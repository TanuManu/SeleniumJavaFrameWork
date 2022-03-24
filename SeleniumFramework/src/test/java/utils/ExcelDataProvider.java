package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	WebDriver driver= null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider="testdata1")
	public void test1(String username, String password) throws InterruptedException
	{ System.out.println(username+" | "+password);
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
    Thread.sleep(3000);
    
	}
	
	@DataProvider(name="testdata1")
	public Object[][] getData() {
		String excelPath = "D:/Java Projects/SeleniumFramework/excel/data.xlsx";
		Object data[][]= testData(excelPath,"1st Page");
		return data;

	}

	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int Rowcount = excel.getRowCount();
		int Colcount = excel.getColCount();
		
		Object data[][] = new Object[Rowcount-1][Colcount];

		for(int i=1; i<Rowcount; i++) {
			for(int j=0; j<Colcount; j++) {

				String cellData = excel.getCelldatastring(i, j);
				//System.out.print(cellData+ " | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
return data;
	}
}
