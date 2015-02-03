package com.perceptivesoftware.mule.connector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.perceptivesoftware.mule.connector.client.model.forms.FormInfo;

public class IntegrationServerConnectorTest_Forms extends BaseTest{

	@Before
	public void startup() throws Exception {
		super.startup();
	}

	@Test
	public void testAddGetForm() throws Exception {

		String documentId = createDocument("Test Document", createKeys("TEST"));

		// First we will push a form onto a document and then we will pull the
		// form out of the document
		// this will test the happy path of both updateForm and getForm and we
		// will match the form by name with the
		// call to get the form list

		List<FormInfo> formList = connector.getFormList();

		String formName = getFormName();
		String formId = null;
		for (FormInfo form : formList) {
			if (formName.equals(form.getName())) {
				formId = form.getId();
				break;
			}
		}

		Assert.assertNotNull(formId);

		String filePath = getClass().getResource("/transcript.xml").getPath();
		// read the transcript.xml into a string
		FileInputStream transcriptData = new FileInputStream(filePath);
		String theTranscriptString = readInputStream(transcriptData);

		connector.setFormData(formName, documentId, filePath);

		InputStream theForm = connector.getFormData(formName, documentId);

		Assert.assertNotNull(theForm);
		String theFormStr = readInputStream(theForm);

		Assert.assertTrue(theTranscriptString.contains(theFormStr));

	}
	
	
	@Test
	public void testGetDataDefinition() throws Exception {

		String formName = getFormName();
		InputStream dataDef = connector.getDataDefinition(formName, "");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		// if there is something wrong with the dataDef an error will be thrown here.
		org.w3c.dom.Document xmlDefs = builder.parse(dataDef);

		Assert.assertNotNull(xmlDefs);
	
	}

	private String readInputStream(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		StringBuilder sBuilder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sBuilder.append(line);
		}
		reader.close();
		return sBuilder.toString();
	}
	
	private String getFormName() throws Exception {
		return getProperty("form.name");
	}

	@After
	public void shutdown() throws Exception {
		super.shutdown();
	}
}
