package utility;

import org.apache.log4j.Logger;

public class Log {
	
	//initialize Log4j logs
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	//to print log for the beginning of the test case, to know which test case is being executed
	public static void startTestCase(String sTestCaseID) {
		log.info("**********************************************************************************");
		log.info("**********************************************************************************");
		log.info("$$$$$$$$$$$            " +sTestCaseID+ "          $$$$$$$$$$$$$");
		log.info("**********************************************************************************");
		log.info("**********************************************************************************");
	}
	
	//end test case
	public static void endTestCase(String sTestCaseID) {
		log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		log.info("X");
		log.info("X");
		log.info("X");
		log.info("X");

	}

	//giving information about the test case
	public static void info(String message) {
		log.info(message);

		}

 public static void warn(String message) {
	 log.warn(message);

	}

 public static void error(String message) {
	 log.error(message);

	}

 public static void fatal(String message) {
	 log.fatal(message);

	}

 public static void debug(String message) {
	 log.debug(message);

	}
}
