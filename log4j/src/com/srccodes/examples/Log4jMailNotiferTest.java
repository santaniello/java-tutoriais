package com.srccodes.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Abhijit Ghosh
 * @version 1.0
 */
public class Log4jMailNotiferTest {
    private static Logger logger = LoggerFactory.getLogger(Log4jMailNotiferTest.class);


	/**
	 * To test whether fatal log sent to email id or not.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Generate exception
			throw new Exception("Generating exception to test Log4j mail notification...");
		} catch (Exception ex) {
			logger.error("Test Result : ", ex);
		}
	}
}