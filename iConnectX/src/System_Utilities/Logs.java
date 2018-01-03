package System_Utilities;

import org.apache.log4j.Logger;


public class Logs {

	
	private static Logger Logs = Logger.getLogger(Logs.class.getName());
	

	
	public static void StartTestCase(String TestCaseName) {
		
		Logs.info("***********************************************************");
		Logs.info("***********Test Case:- "+TestCaseName+" Started************");
		Logs.info("***********************************************************");
	}
	
	
	public static void EndTestCase(String TestCaseName) {
		
		Logs.info("***********************************************************");
		Logs.info("***********Test Case:- "+TestCaseName+" End****************");
		Logs.info("***********************************************************");
		
	}
	
	public static void Info(String Message) {
		Logs.info(Message);
	}
	
	public static void Warning(String Message) {		
		Logs.warn(Message);
	}
	
	public static void Error(String Message) {
		Logs.error(Message);
	}
	
	public static void FatalError(String Message) {
		Logs.fatal(Message);
	}
	
	public static void debug(String Message) {
		Logs.debug(Message);
	}
	
}
