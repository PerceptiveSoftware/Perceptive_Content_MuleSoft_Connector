package com.perceptivesoftware.mule.connector.client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.util.Headers;
import com.perceptivesoftware.mule.connector.client.util.QueryParmeters;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AbstractEndpoint {
	private IntegrationServerClient client;
    private WebResource webResource;
	
	public AbstractEndpoint(IntegrationServerClient client, String path) {
		this.client = client;
		this.webResource = client.getJerseyClient().resource(client.getUrl()).path(path);
	}

	protected ClientResponse execute(List<String> paths,
			QueryParmeters queryParameters, String method,
			MediaType acceptType, Headers headers, MediaType requestType,
			Object requestData) throws IntegrationServerConnectorException {

		WebResource modifiedWebResource = webResource;

		if (queryParameters != null) {
			for (QueryParmeters.Item queryParameter : queryParameters) {
				modifiedWebResource = modifiedWebResource.queryParam(
						queryParameter.getKey(), queryParameter.getValue());
			}
		}

		if (paths != null) {
			for (String path : paths) {
				modifiedWebResource = modifiedWebResource.path(path);
			}
		}

		return client.execute(modifiedWebResource, method, acceptType, headers,
				requestType, requestData);
	}
	
	protected <T> T execute(List<String> paths, QueryParmeters queryParameters,
			String method, MediaType acceptType, Class<T> returnClass,
			Headers headers, MediaType requestType, Object requestData)
			throws IntegrationServerConnectorException {

		ClientResponse clientResponse = execute(paths, queryParameters, method, acceptType, headers, requestType, requestData);
		
		if(returnClass == null) {
			return null;
		}

		return clientResponse.getEntity(returnClass);		
	}	
	
	protected IntegrationServerClient getClient() {
		return client;
	}
}
