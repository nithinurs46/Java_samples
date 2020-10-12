package com;


public class Logger {

	private Logger() {

	}

	// lazy loaded singleton, follows initialization on demand idiom
	// inner classes are not loaded until they are referenced

	public static class LogHolder {
		public static Logger logger = new Logger();
	}
	public static Logger getInstance() {
		return LogHolder.logger;
	}
}

class Test {
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		System.out.println(logger);
	}
}