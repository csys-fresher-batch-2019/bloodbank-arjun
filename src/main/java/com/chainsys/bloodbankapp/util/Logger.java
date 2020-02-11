package com.chainsys.bloodbankapp.util;

public class Logger {

	public static Logger getInstance() {
		return new Logger();
	}

	public void debug(Object message) {
		print(message);
	}

	private void print(Object message) {
		System.out.println(message);
	}

	public void info(Object message) {
		print(message);
	}

	public void error(Object message) {
		System.err.println(message);
	}

}
