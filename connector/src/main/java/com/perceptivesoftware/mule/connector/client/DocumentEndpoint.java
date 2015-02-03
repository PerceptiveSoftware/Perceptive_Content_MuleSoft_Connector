package com.perceptivesoftware.mule.connector.client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.document.Document;
import com.perceptivesoftware.mule.connector.client.model.document.Keys;
import com.perceptivesoftware.mule.connector.client.model.document.Page;
import com.perceptivesoftware.mule.connector.client.model.document.Property;
import com.perceptivesoftware.mule.connector.client.model.document.RenameDocument;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateDocument;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateInfo;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateKeys;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateProperty;
import com.perceptivesoftware.mule.connector.client.util.Headers;
import com.sun.jersey.api.client.ClientResponse;

public class DocumentEndpoint extends AbstractEndpoint {

	public DocumentEndpoint(IntegrationServerClient client) {
		super(client, "document");
	}

	public Document getDocument(String docId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(docId), null , "GET", null, Document.class, null, null, null);
	}

	public void setKeys(String docId, UpdateKeys updateKeys) throws IntegrationServerConnectorException {

		Document inDoc = getDocument(docId);
		UpdateDocument apiDoc = createUpdateDocument(inDoc, updateKeys);
				
		execute(Arrays.asList(docId), null, "PUT", MediaType.APPLICATION_JSON_TYPE, null, null, null, apiDoc);
	}
	
	public void setCustomProperties(String docId, List<UpdateProperty> properties)  throws IntegrationServerConnectorException {
		
		Document inDoc = getDocument(docId);

		UpdateDocument apiDoc = createUpdateDocPropertiesOnly(inDoc, properties);
			
		execute(Arrays.asList(docId), null, "PUT", null, null, null, null,apiDoc);
		
	}
	
	public void renameDocument(String docId, RenameDocument name)  throws IntegrationServerConnectorException {
		execute(Arrays.asList(docId, "name"), null, "PUT", null, null, null, null,name);
		
	}
	
	
	public void addPage(String docId, String fileName, InputStream fileStream)
			throws IntegrationServerConnectorException {
		Headers headers = Headers.create();
		headers.add("X-IntegrationServer-Resource-Name", fileName);

		execute(Arrays.asList(docId, "page"), null, "POST", null, null,
				headers, MediaType.APPLICATION_OCTET_STREAM_TYPE, fileStream);
	}
	
	public void replacePage(String docId, String pageId, String fileName, long fileSize, InputStream fileStream)
			throws IntegrationServerConnectorException {
		Headers headers = Headers.create();
		headers.add("X-IntegrationServer-Resource-Name", fileName);
		headers.add("X-IntegrationServer-File-Size", fileSize);

		execute(Arrays.asList(docId, "page", pageId, "file"), null, "PUT",
				null, null, headers, MediaType.APPLICATION_OCTET_STREAM_TYPE,
				fileStream);
	}
	
	public InputStream getPage(String docId, int pageNumber)  throws IntegrationServerConnectorException {
		
		Document inDoc = getDocument(docId);
		List<Page> pages = inDoc.getPages();
			
		Page aPage = pages.get(pageNumber-1);

		return execute(Arrays.asList(docId, "page", aPage.getId(), "file"), null, "GET", MediaType.APPLICATION_OCTET_STREAM_TYPE, InputStream.class, null , MediaType.APPLICATION_OCTET_STREAM_TYPE, null );
	}
	
	public String createDocument(String docname, String location,
			UpdateKeys keys, List<UpdateProperty> properties)
			throws IntegrationServerConnectorException {

		UpdateDocument updateDocument = createUpdateDocument(docname, location,
				keys, properties);

		ClientResponse response = execute(null, null, "POST", null, null, null,
				updateDocument);

		return getDocumentIdFromLocation(response.getHeaders().getFirst(
				"Location"));
	}

	public String createDocument(String docname, String location,
			UpdateKeys keys, List<UpdateProperty> properties,
			InputStream fileStream, String fileName) throws IntegrationServerConnectorException {

		UpdateDocument updateDocument = createUpdateDocument(docname, location,
				keys, properties);

		ClientResponse response = execute(null, null, "POST", null, null, null,
				updateDocument);

		String documentId = getDocumentIdFromLocation(response.getHeaders()
				.getFirst("Location"));

		addPage(documentId, fileName, fileStream);
		return documentId;
	}
	
	private String getDocumentIdFromLocation(String location) {
		return location.substring(location.lastIndexOf("/") + 1);
	}
	
	public void deleteDocument(String docId) throws IntegrationServerConnectorException {
		execute(Arrays.asList(docId), null , "DELETE", null, null, null, null, null);
	}

	public void deletePageByNumber(String docId, int pageNumber) throws IntegrationServerConnectorException {
		Document inDoc = getDocument(docId);
		List<Page> pages = inDoc.getPages();
		Page aPage = pages.get(pageNumber-1);
		execute(Arrays.asList(docId, "page", aPage.getId()), null , "DELETE", null, null, null, null, null);
	}
	
	public void deletePageById(String docId, String pageId) throws IntegrationServerConnectorException {
		execute(Arrays.asList(docId, "page", pageId), null , "DELETE", null, null, null, null, null);
	}
	
	private UpdateDocument createUpdateDocument(String docname,
			String location, UpdateKeys keys, List<UpdateProperty> properties) {
		UpdateDocument apiDoc = new UpdateDocument();

		apiDoc.info = new UpdateInfo();
		apiDoc.info.keys = new UpdateKeys();
		apiDoc.info.setName(docname);
		apiDoc.info.setLocationId(location);
		apiDoc.info.setKeys(setKeysNotNull(keys));


		apiDoc.properties = properties;

		return apiDoc;
	}
	
	private UpdateDocument createUpdateDocument(Document inDoc, UpdateKeys inKeys) {
		UpdateDocument apiDoc = new UpdateDocument();
		UpdateInfo apiInfo = new UpdateInfo();

		apiInfo.setKeys(mergeUpdateKeys(inKeys, inDoc.info.getKeys()));
		apiInfo.setName(inDoc.info.getName());
		apiInfo.setLocationId(inDoc.info.getLocationId());
		apiDoc.setInfo(apiInfo);

		List<UpdateProperty> propList = new ArrayList<UpdateProperty>();
		for(Property prop : inDoc.getProperties()) {
			UpdateProperty  aProp = new UpdateProperty();

			aProp.setId(prop.getId());
			aProp.setType(prop.getType());
			aProp.setValue(prop.getValue());

			propList.add(aProp);
		}

		apiDoc.setProperties(propList);

		return apiDoc;
	}
	
	private UpdateKeys mergeUpdateKeys(UpdateKeys updatedKeys, Keys currentKeys) {
		UpdateKeys keys = new UpdateKeys();

		keys.documentType = updatedKeys.documentType != null ? updatedKeys.documentType
				: currentKeys.documentType;
		keys.drawer = updatedKeys.drawer != null ? updatedKeys.drawer : currentKeys.drawer;
		keys.field1 = updatedKeys.field1 != null ? updatedKeys.field1 : currentKeys.field1;
		keys.field2 = updatedKeys.field2 != null ? updatedKeys.field2 : currentKeys.field2;
		keys.field3 = updatedKeys.field3 != null ? updatedKeys.field3 : currentKeys.field3;
		keys.field4 = updatedKeys.field4 != null ? updatedKeys.field4 : currentKeys.field4;
		keys.field5 = updatedKeys.field5 != null ? updatedKeys.field5 : currentKeys.field5;

		return keys;
	}
	private UpdateKeys setKeysNotNull(UpdateKeys inKeys) {
		UpdateKeys keys = new UpdateKeys();
		keys.documentType = inKeys.documentType != null ? inKeys.documentType
				: "default";
		keys.drawer = inKeys.drawer != null ? inKeys.drawer : "default";
		keys.field1 = inKeys.field1 != null ? inKeys.field1 : null;
		keys.field2 = inKeys.field2 != null ? inKeys.field2 : null;
		keys.field3 = inKeys.field3 != null ? inKeys.field3 : null;
		keys.field4 = inKeys.field4 != null ? inKeys.field4 : null;
		keys.field5 = inKeys.field5 != null ? inKeys.field5 : "default";
		return keys;
	}
	
	private UpdateDocument createUpdateDocPropertiesOnly(Document inDoc,
			List<UpdateProperty> properties) {
		UpdateDocument updateDocuemnt = new UpdateDocument();

		UpdateKeys aKeys = new UpdateKeys();
		aKeys.setDocumentType(inDoc.info.keys.getDocumentType());
		aKeys.setDrawer(inDoc.info.keys.getDrawer());
		aKeys.setField1(inDoc.info.keys.getField1());
		aKeys.setField2(inDoc.info.keys.getField2());
		aKeys.setField3(inDoc.info.keys.getField3());
		aKeys.setField4(inDoc.info.keys.getField4());
		aKeys.setField5(inDoc.info.keys.getField5());

		UpdateInfo isDoc = new UpdateInfo();
		isDoc.setKeys(aKeys);
		isDoc.setName(inDoc.info.getName());
		isDoc.setLocationId(inDoc.info.getLocationId());

		updateDocuemnt.setInfo(isDoc);
		updateDocuemnt.setProperties(properties);

		return updateDocuemnt;
	}
}
