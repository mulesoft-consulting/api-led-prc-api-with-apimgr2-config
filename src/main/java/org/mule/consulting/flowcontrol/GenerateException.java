package org.mule.consulting.flowcontrol;

public class GenerateException extends Exception {
	private static final long serialVersionUID = 1L;

	public GenerateException() throws Exception {
		throw this;
	}
}
