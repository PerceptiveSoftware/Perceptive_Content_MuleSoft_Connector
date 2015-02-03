package com.perceptivesoftware.mule.connector.client.exceptions;

public class IntegrationServerConnectorException extends Exception {

	private static final long serialVersionUID = 1L;

	public IntegrationServerConnectorException() {
	}

	public IntegrationServerConnectorException(String message) {
		super(message);
	}

	public IntegrationServerConnectorException(Throwable cause) {
		super(cause);
	}

	public IntegrationServerConnectorException(String message, Throwable cause) {
		super(message, cause);
	}

}