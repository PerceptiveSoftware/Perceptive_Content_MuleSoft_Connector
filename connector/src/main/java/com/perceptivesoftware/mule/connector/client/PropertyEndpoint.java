package com.perceptivesoftware.mule.connector.client;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.property.PropertyList;

public class PropertyEndpoint extends AbstractEndpoint {

	public PropertyEndpoint(IntegrationServerClient client) {
		super(client, "property");
	}
	
	public PropertyList getAllProperties() throws IntegrationServerConnectorException {
		return execute( null, null, "GET", null, PropertyList.class, null, null, null);
	}
}
