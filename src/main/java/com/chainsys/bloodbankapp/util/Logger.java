package com.chainsys.bloodbankapp.util;

public class Logger {

	private Class clazz;
	private Logger(Class clazz) {
		this.clazz = clazz;
	}
	public static Logger getInstance(Class clazz) {
		Logger logger = new Logger(clazz);
		
		return logger;
	}

	public void debug(Object message) {
		print(message);
	}

	private void print(Object message) {
		System.out.println(message);
	}

	public void info(Object message) {
		//print( "{" + clazz.getSimpleName() + "}-" + message);
		print(message);
	}

	public void error(Object message) {
		System.err.println(message);
	}

}
