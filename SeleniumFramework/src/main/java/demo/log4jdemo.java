package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class log4jdemo {

	private static Logger logger = LogManager.getLogger(log4jdemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n   Hello World!!   \n");
		
		logger.trace("This is a trace message");
		logger.info("This is an information");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		logger.warn("This is a warning");
		
		System.out.println("\n Completed");

	}

}
