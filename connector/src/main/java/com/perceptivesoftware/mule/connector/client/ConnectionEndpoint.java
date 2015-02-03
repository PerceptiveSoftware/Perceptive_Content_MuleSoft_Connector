package com.perceptivesoftware.mule.connector.client;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.ConnectionStatus;
import com.perceptivesoftware.mule.connector.client.util.Headers;

public class ConnectionEndpoint extends AbstractEndpoint {

	public ConnectionEndpoint(IntegrationServerClient client) {
		super(client, "connection");
	}
	
	public String connect() throws IntegrationServerConnectorException {
		ConnectionStatus status = execute(null, null, "GET", null, ConnectionStatus.class, 
				Headers.create()
					.add("X-IntegrationServer-Username", this.getClient().getUser())
					.add("X-IntegrationServer-Password", this.getClient().getPassword()), null, null);
		
		if(status.getVersion().isEmpty()) {
			throw new IntegrationServerConnectorException(
					String.format(
							"Failed to connect to server [%s@%s] - Call succeeded, but failed to get connection",
							getClient().getUser(), getClient().getUrl()));
		}
		
		return status.getVersion();
	}
	
	public void disconnect() throws IntegrationServerConnectorException {
		execute(null, null, "DELETE", null, String.class, null, null, null);
	}
}
