package com.perceptivesoftware.mule.connector.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.google.common.base.Strings;
import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.util.Headers;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class IntegrationServerClient {

	private Client jerseyClient;
	private String token;
	private String url;
	private String user;
	private String password;
	
	private ConnectionEndpoint connectionEndpoint;
	private DocumentEndpoint documentEndpoint;
	private DocumentTypeEndpoint documentTypeEndpoint;
	private DrawerEndpoint drawerEndpoint;
	private FormsEndpoint formsEndpoint;
	private PropertyEndpoint propertyEndpoint;
	private ViewEndpoint viewEndpoint;
	private WorkflowItemEndpoint workflowItemEndpoint;
	private WorkflowQueueEndpoint workflowQueueEndpoint;
		

	public IntegrationServerClient(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
		
		this.jerseyClient = createClient();
		this.token = null;
		
		this.connectionEndpoint = new ConnectionEndpoint(this);
		this.documentEndpoint = new DocumentEndpoint(this);
		this.documentTypeEndpoint = new DocumentTypeEndpoint(this);
		this.drawerEndpoint = new DrawerEndpoint(this);
		this.formsEndpoint = new FormsEndpoint(this);
		this.propertyEndpoint = new PropertyEndpoint(this);
		this.viewEndpoint = new ViewEndpoint(this);
		this.workflowItemEndpoint = new WorkflowItemEndpoint(this);
		this.workflowQueueEndpoint = new WorkflowQueueEndpoint(this);
	}
	
	private Client createClient() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		return Client.create(clientConfig);
	}
	
	protected ClientResponse execute(WebResource webResource, String method, MediaType acceptType, 
			Headers headers, MediaType requestType, Object requestData) throws IntegrationServerConnectorException {
		
		Builder builder = webResource.accept(acceptType != null ? acceptType : MediaType.APPLICATION_JSON_TYPE);
		
		String token = getToken();
		if(!Strings.isNullOrEmpty(token)) {
			builder.header("X-IntegrationServer-Session-Hash", token);
		}
		
		if(headers != null) {
			for(Headers.Item header : headers) {
				builder.header(header.getKey(), header.getValue());
			}
		}
		
		ClientResponse clientResponse = null;
		if(requestData == null) {
			clientResponse = builder.method(method, ClientResponse.class);
		}
		else {
			builder.type(requestType != null ? requestType : MediaType.APPLICATION_JSON_TYPE);
			clientResponse = builder.method(method, ClientResponse.class, requestData);
		}
		
		if (clientResponse.getStatus() == 200 || clientResponse.getStatus() == 201) {
			if (Strings.isNullOrEmpty(getToken())) {
				MultivaluedMap<String, ?> responseHeaders = clientResponse.getHeaders();
				setToken((String) responseHeaders.getFirst("X-IntegrationServer-Session-Hash"));
			}

			return clientResponse;
		} 
		else if (clientResponse.getStatus() == 401) {
			throw new IntegrationServerConnectorException("ERROR - Token expired");
		} 
		else {
			throw new IntegrationServerConnectorException(String.format(
					"ERROR - statusCode: %d - message: %s",
					clientResponse.getStatus(),
					clientResponse.getClientResponseStatus()));
		}	
	}
		
	public String connect() throws IntegrationServerConnectorException {
		return getConnectionEndpoint().connect();
	}
	
	public void disconnect() throws IntegrationServerConnectorException {
		getConnectionEndpoint().disconnect();
	}
	
	protected ConnectionEndpoint getConnectionEndpoint() {
		return connectionEndpoint;
	}
	public DocumentEndpoint getDocumentEndpoint() {
		return documentEndpoint;
	}
	public DocumentTypeEndpoint getDocumentTypeEndpoint() {
		return documentTypeEndpoint;
	}
	public DrawerEndpoint getDrawerEndpoint() {
		return drawerEndpoint;
	}
	public FormsEndpoint getFormsEndpoint() {
		return formsEndpoint;
	}
	public PropertyEndpoint getPropertyEndpoint() {
		return propertyEndpoint;
	}
	public ViewEndpoint getViewEndpoint() {
		return viewEndpoint;
	}
	public WorkflowItemEndpoint getWorkflowItemEndpoint() {
		return workflowItemEndpoint;
	}
	
	public WorkflowQueueEndpoint getWorkflowQueueEndpoint() {
		return workflowQueueEndpoint;
	}
	
	private String getToken() {
		return token;
	}
	
	private void setToken(String updatedToken) {
		this.token = updatedToken;
	}
	
	protected Client getJerseyClient() {
		return jerseyClient;
	}
	
	protected String getUrl() {
		return url;
	}
	
	protected String getUser() {
		return user;
	}
	
	protected String getPassword() {
		return password;
	}
}
