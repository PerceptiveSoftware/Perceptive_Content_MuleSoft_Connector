package com.perceptivesoftware.mule.connector.client;

import java.util.Arrays;
import java.util.List;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.documenttype.DocumentType;
import com.perceptivesoftware.mule.connector.client.model.documenttype.DocumentTypeInfo;
import com.perceptivesoftware.mule.connector.client.model.documenttypedetails.DocumentTypeDetails;

public class DocumentTypeEndpoint extends AbstractEndpoint {

	public DocumentTypeEndpoint(IntegrationServerClient client) {
		super(client, "documentType");
	}
	
	public DocumentType getDocumentTypeList() throws IntegrationServerConnectorException {
		return execute(null, null, "GET", null, DocumentType.class, null, null, null);
	}
	
	public DocumentTypeDetails getDocumentTypeDetails(String documentTypeId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(documentTypeId), null, "GET", null, DocumentTypeDetails.class, null, null, null);

	}

	public String findDocTypeId( String name, List<DocumentTypeInfo> docTypes) throws IntegrationServerConnectorException {
		for ( DocumentTypeInfo info : docTypes)	{
			if ( name.equals(info.getName())) {
				return info.getId();
			}
		}
		throw new IntegrationServerConnectorException( "Unable to find documentType" + name );
	}
}
