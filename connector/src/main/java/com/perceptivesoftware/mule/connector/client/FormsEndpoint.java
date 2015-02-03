package com.perceptivesoftware.mule.connector.client;

import java.io.InputStream;
import java.util.Arrays;
import javax.ws.rs.core.MediaType;
import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.formpresentation.FormPresentationInfo;
import com.perceptivesoftware.mule.connector.client.model.formpresentation.FormPresentations;
import com.perceptivesoftware.mule.connector.client.model.forms.Forms;
import com.perceptivesoftware.mule.connector.client.util.QueryParmeters;

public class FormsEndpoint extends AbstractEndpoint {

	public FormsEndpoint(IntegrationServerClient client) {
		super(client, "form");
	}
	
	public Forms getAllForms() throws IntegrationServerConnectorException {
		return execute(null, null, "GET", null, Forms.class, null, null, null);
	}
		
	public InputStream getFormData(String documentId, String formId,
			String version) throws IntegrationServerConnectorException {

		QueryParmeters queryParameters = QueryParmeters.create();
		queryParameters.add("version", version);

		return execute(Arrays.asList(formId, "document", documentId),
				queryParameters, "GET",
				MediaType.APPLICATION_OCTET_STREAM_TYPE, InputStream.class,
				null, MediaType.APPLICATION_OCTET_STREAM_TYPE, null);
	}

	public FormPresentations getFormPresentation(String formId)
			throws IntegrationServerConnectorException {
		return execute(Arrays.asList(formId, "presentation"), null, "GET",
				null, FormPresentations.class, null, null, null);
	}

	public FormPresentationInfo getPresentationInfo(String formId,
			String presentationId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(formId, "presentation", presentationId),
				null, "GET", null, FormPresentationInfo.class, null, null, null);
	}

	public InputStream getDataDefinition(String formId, String presentationId,
			String fileId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(formId, "presentation", presentationId,
				"file", fileId), null, "GET",
				MediaType.APPLICATION_OCTET_STREAM_TYPE, InputStream.class,
				null, MediaType.APPLICATION_OCTET_STREAM_TYPE, null);

	}
	public void setFormData(String documentId, String formId, String version, InputStream form) throws IntegrationServerConnectorException {
		QueryParmeters queryParameters = QueryParmeters.create();
		queryParameters.add("version", version);
		
		execute(Arrays.asList(formId, "document", documentId), queryParameters, "PUT", MediaType.APPLICATION_OCTET_STREAM_TYPE, null, null, MediaType.APPLICATION_OCTET_STREAM_TYPE, form);	
	}
	
}
