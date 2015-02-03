package com.perceptivesoftware.mule.connector;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.document.Document;
import com.perceptivesoftware.mule.connector.client.model.document.Property;
import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateKeys;

public class IntegrationServerConnectorTest_Document extends BaseTest {	
	
	@Before
	public void startup() throws Exception{
		super.startup();
	}
	
	@Test
	public void testCreateDocument() throws Exception {
				
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();
		
		String documentId = createDocument("Test Document", null, keys, properties, null);
		
		Document document = connector.getDocument(documentId);
		
		Assert.assertEquals(keys.documentType, document.info.keys.documentType);
		Assert.assertEquals(keys.drawer, document.info.keys.drawer);
		Assert.assertEquals(keys.field1, document.info.keys.field1);
		Assert.assertEquals(keys.field2, document.info.keys.field2);
		Assert.assertEquals(keys.field3, document.info.keys.field3);
		Assert.assertEquals(keys.field4, document.info.keys.field4);
		Assert.assertEquals(keys.field5, document.info.keys.field5);
		
		for(String key : properties.keySet()) {
			Property property = findPropertyByName(key, document.getProperties());
			
			Assert.assertNotNull(property);
			Assert.assertEquals(properties.get(key), property.getValue());
		}		
	}
	
	@Test
	public void testCreateDocumentWithSinglePage() throws Exception {
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();

		String path = getClass().getResource("/declaration_of_independence.jpg").getPath();
		
		String documentId = createDocument("Test Document", null, keys, properties, path, "The Declaration of Independence");
		
		Document document = connector.getDocument(documentId);
		
		Assert.assertEquals(keys.documentType, document.info.keys.documentType);
		Assert.assertEquals(keys.drawer, document.info.keys.drawer);
		Assert.assertEquals(keys.field1, document.info.keys.field1);
		Assert.assertEquals(keys.field2, document.info.keys.field2);
		Assert.assertEquals(keys.field3, document.info.keys.field3);
		Assert.assertEquals(keys.field4, document.info.keys.field4);
		Assert.assertEquals(keys.field5, document.info.keys.field5);
		
		for(String key : properties.keySet()) {
			Property property = findPropertyByName(key, document.getProperties());
			
			Assert.assertNotNull(property);
			Assert.assertEquals(properties.get(key), property.getValue());
		}
		
		Assert.assertEquals(1, document.getPages().size());
		Assert.assertEquals("The Declaration of Independence", document.getPages().get(0).getName());
	}
	
	@Test
	public void testAddDocumentPage() throws Exception {
		// Create a document
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();

		String path1 = getClass().getResource("/declaration_of_independence.jpg").getPath();
		String path2 = getClass().getResource("/constitution.jpg").getPath();
		
		String documentId = createDocument("Test Document", null, keys, properties, path1);
		
		// Assure that the document was created with a page
		Document document = connector.getDocument(documentId);
		
		Assert.assertEquals(1, document.getPages().size());
		Assert.assertEquals("declaration_of_independence.jpg", document.getPages().get(0).getName());
		
		// Add a page
		connector.addPageToDocument(documentId, path2, "The Constitution");
		
		// Assure the pages are correct
		document = connector.getDocument(documentId);
		
		Assert.assertEquals(2, document.getPages().size());
		Assert.assertEquals("declaration_of_independence.jpg", document.getPages().get(0).getName());		
		Assert.assertEquals("The Constitution", document.getPages().get(1).getName());		
		
		// Assure that the details of the page were added correctly
		Assert.assertEquals("jpg", document.getPages().get(0).getExtension().toLowerCase());
		Assert.assertEquals("1", document.getPages().get(0).getPageNumber());
		Assert.assertEquals("jpg", document.getPages().get(1).getExtension().toLowerCase());
		Assert.assertEquals("2", document.getPages().get(1).getPageNumber());
	}
	
	@Test
	public void testReplaceDocumentPage() throws Exception {
		// Create a document
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();

		String path1 = getClass().getResource("/declaration_of_independence.jpg").getPath();
		String path2 = getClass().getResource("/constitution.jpg").getPath();
		
		String documentId = createDocument("Test Document", null, keys, properties, path1);
		
		// Assure that the document was created with a page
		Document document = connector.getDocument(documentId);
				
		Assert.assertEquals(1, document.getPages().size());
		Assert.assertEquals("declaration_of_independence.jpg", document.getPages().get(0).getName());
		
		// Add a page
		connector.replaceDocumentPage(documentId, document.getPages().get(0).getName(), 
				path2, "The Constitution");
		
		document = connector.getDocument(documentId);
		
		Assert.assertEquals(1, document.getPages().size());	
		Assert.assertEquals("The Constitution", document.getPages().get(0).getName());		
	}	
	
	@Test
	public void testDeleteDocumentPage() throws Exception {
		// Create a document
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();

		String path1 = getClass().getResource("/declaration_of_independence.jpg").getPath();
		String path2 = getClass().getResource("/constitution.jpg").getPath();
		
		String documentId = createDocument("Test Document", null, keys,
				properties, path1, "The Declaration of Independence");

		connector.addPageToDocument(documentId, path2, "The Constitution");
		
		// Assure that the document was created with a page
		Document document = connector.getDocument(documentId);
		
		Assert.assertEquals(2, document.getPages().size());
		Assert.assertEquals("The Declaration of Independence", document.getPages().get(0).getName());
		Assert.assertEquals("The Constitution", document.getPages().get(1).getName());
		
		// Delete a page by page number
		connector.deletePageByNumber(documentId, 1);
		
		// Assert a single page remains
		document = connector.getDocument(documentId);
		Assert.assertEquals(1, document.getPages().size());	
		Assert.assertEquals("The Constitution", document.getPages().get(0).getName());
		
		// Delete a page by page id
		connector.deletePageById(documentId, document.getPages().get(0).getId());
		document = connector.getDocument(documentId);
		Assert.assertEquals(0, document.getPages().size());	
	}
	
	@Test
	public void testDeleteDocument() throws Exception {
		// Create the document
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();
		String documentId = createDocument("Test Document", null, keys, properties, null);		
		
		// Check that the document was created
		Document document = connector.getDocument(documentId);
		Assert.assertEquals("Test Document", document.getInfo().getName());
		
		// Delete the document
		connector.deleteDocument(documentId);
		
		// Check that it was deleted
		try {
			document = connector.getDocument(documentId);
			Assert.fail();
		} catch (IntegrationServerConnectorException e) {
			Assert.assertTrue(e.getMessage().toLowerCase()
					.contains("not found"));
		}
	}
	
	@Test
	public void testRenameDocument() throws Exception {
		// Create document
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();
		
		String documentId = createDocument("Test Document", null, keys, properties, null);
		
		// Assure name is set correctly
		Document document = connector.getDocument(documentId);
		Assert.assertEquals("Test Document", document.info.getName());
		
		// Update name
		connector.renameDocument(documentId, "New Name");
		
		// Assure success
		document = connector.getDocument(documentId);
		Assert.assertEquals("New Name", document.info.getName());
	}
	
	@Test
	public void testUpdateKey() throws Exception {
		// Create the documents
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();

		// Duplicate keys only matter if no file name is specified
		String documentId = createDocument(null, null, keys, properties,
				null);

		// Update the keys
		keys.field1 = "foobar";
		connector.setDocumentKeys(documentId, keys);
		
		// Assure success
		Document document = connector.getDocument(documentId);
		Assert.assertEquals(keys.field1, document.info.keys.field1);
	}	
	
	@Test
	public void testUpdateDupicateKey() throws Exception {
		// Create the documents
		UpdateKeys keysSetA = createKeys("a");
		UpdateKeys keysSetB = createKeys("b");
		Map<String, String> properties = createProperties();

		// Duplicate keys only matter if no file name is specified
		createDocument(null, null, keysSetA, properties, null);
		String documentIdB = createDocument(null, null, keysSetB, properties,
				null);

		// Rename to an existing key set and observe failure
		try {
			connector.setDocumentKeys(documentIdB, keysSetA);
			Assert.fail();
		} catch (IntegrationServerConnectorException e) {
			Assert.assertTrue(e.getMessage().toLowerCase().contains("conflict"));
		}
	}
	
	@Test
	public void testUpdateDuplicateName() throws Exception {
		// Create the documents
		UpdateKeys keys = createKeys();
		Map<String, String> properties = createProperties();

		// Create to files with the same name and observe failure
		createDocument("Document A", null, keys, properties, null);

		try {
			createDocument("Document B", null, keys, properties, null);
		} catch (IntegrationServerConnectorException e) {
			Assert.assertTrue(e.getMessage().toLowerCase().contains("conflict"));
		}
	}
	
	private Property findPropertyByName(String name, List<Property> properties) {
		for(Property property : properties) {
			if(name.equals(property.getName())) {
				return property;
			}
		}
		
		return null;
	}
	
	
	@After
	public void shutdown() throws Exception {
		super.shutdown();
	}
}
