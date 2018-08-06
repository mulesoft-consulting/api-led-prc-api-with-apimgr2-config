package org.mule.consulting.flowcontrol;

public class MissingQueryParameters extends GenerateException {
	private static final long serialVersionUID = 1L;

	public MissingQueryParameters() throws Exception {
		throw this;
	}

}
