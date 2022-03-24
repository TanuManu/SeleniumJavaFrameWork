package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_demo;

public class PropertiesFile {

	static Properties prop = new Properties();

	static String ProjectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
        setProperties();
        getProperties();
	}

	public static void getProperties() {

		try {

			System.out.println(ProjectPath);
			InputStream input = new FileInputStream(ProjectPath +"/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TestNG_demo.BrowserName = browser;
		}

		catch (Exception exp) {

			System.out.println("Message:" + exp.getMessage());
			System.out.println("Status:" + exp.getCause());
			exp.printStackTrace();

		}
	}


	public static void setProperties() {

		try {
			OutputStream output = new FileOutputStream(ProjectPath +"/src/test/java/config/config.properties");
			prop.setProperty("result", "Pass");
			prop.store(output, null);
		}
		

		catch (Exception exp) {

			System.out.println("Message:" + exp.getMessage());
			System.out.println("Status:" + exp.getCause());
			exp.printStackTrace();

		}



	}
}
