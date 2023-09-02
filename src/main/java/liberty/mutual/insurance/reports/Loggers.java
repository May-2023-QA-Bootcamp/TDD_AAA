package liberty.mutual.insurance.reports;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Loggers {

	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void log(String msg) {
		logger.log(Level.INFO,msg);
	}
}
