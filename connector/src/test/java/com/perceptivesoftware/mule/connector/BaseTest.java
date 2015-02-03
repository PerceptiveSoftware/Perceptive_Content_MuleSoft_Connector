package com.perceptivesoftware.mule.connector;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.common.base.Strings;
import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateKeys;

public class BaseTest {
	
	protected PerceptiveContentMuleSoftConnector connector;
	private List<String> cleanupDocuments;
	private Properties config;
	
	public BaseTest() {
		this.connector = new PerceptiveContentMuleSoftConnector();
		this.cleanupDocuments = new ArrayList<String>();
		this.config = null;
	}
	
	public void startup() throws Exception {
		String url = getProperty("general.url");
		String user = getProperty("general.user");
		String password = getProperty("general.password");
		
		connector.setUrl(url);
		connector.connect(user, password);
	}
	
	public void shutdown() throws Exception {
		for(String documentId : cleanupDocuments) {
			try {
				connector.deleteDocument(documentId);
			} catch(IntegrationServerConnectorException e) {
				// meh
			}
		}
		
		connector.disconnect();
	}
	
	protected String getProperty(String key) throws Exception {
		return getConfiguration().getProperty(key);
	}
	
	private Properties getConfiguration() throws Exception {
		if(config != null) {
			return config;
		}
		
		InputStream configInput = getClass().getResourceAsStream("/test.properties");
		if(configInput == null) {
			throw new FileNotFoundException("Failed to find configuration");
		}
		
		config = new Properties();
		config.load(configInput);
		
		return config;
	}
	
	protected UpdateKeys createKeys() throws Exception {
		return createKeys("");
	}

	protected UpdateKeys createKeys(String suffix) throws Exception {
		UpdateKeys keys = new UpdateKeys();
		
		keys.setDocumentType(getDocumentType());
		keys.setDrawer(getDocumentDrawer());
		keys.setField1("field1" + suffix);
		keys.setField2("field2" + suffix);
		keys.setField3("field3" + suffix);
		keys.setField4("field4" + suffix);
		keys.setField5("field5" + suffix);
		
		return keys;
	}

	protected Map<String, String> createProperties() throws Exception {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put(getDocumentPropertyName(), getDocumentPropertyValue());
		
		return properties;
	}

	protected String createDocument(String name, UpdateKeys keys) throws Exception {
		return createDocument(name, null, keys, null, null);
	}
	
	protected String createDocument(String name, String location, UpdateKeys keys, Map<String, String> properties, String filePath) throws Exception {
		return createDocument(name, location, keys, properties, filePath, null);
	}

	protected String createDocument(String name, String location, UpdateKeys keys, Map<String, String> properties, String filePath, String fileName) throws Exception {
		String documentId = "";
		
		if(Strings.isNullOrEmpty(filePath)) {
			documentId = connector.createDocument(name, location, keys, properties);	
		}
		else {
			documentId = connector.createDocumentWithPage(name, location, keys, properties, filePath, fileName);
		}
		
		cleanupDocuments.add(documentId);
		return documentId;
	}
	
	private String getDocumentType() throws Exception {
		return getProperty("document.type");
	}
	
	private String getDocumentDrawer() throws Exception {
		return getProperty("document.drawer");
	}
	
	private String getDocumentPropertyName() throws Exception {
		return getProperty("document.property.name");
	}
	
	private String getDocumentPropertyValue() throws Exception {
		return getProperty("document.property.value");
	}	
}
