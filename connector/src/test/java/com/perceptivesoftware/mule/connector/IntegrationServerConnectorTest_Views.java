package com.perceptivesoftware.mule.connector;

import java.util.List;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.perceptivesoftware.mule.connector.client.model.updatedocument.UpdateKeys;
import com.perceptivesoftware.mule.connector.client.model.viewdetails.ViewDetails;
import com.perceptivesoftware.mule.connector.client.model.viewresults.ViewResultRow;
import com.perceptivesoftware.mule.connector.client.model.viewresults.ViewResults;
import com.perceptivesoftware.mule.connector.client.model.views.ViewInfo;

public class IntegrationServerConnectorTest_Views extends BaseTest {

	@Before
	public void startup() throws Exception {
		super.startup();
	}

	@Test
	public void testGetViewList() throws Exception {

		List<ViewInfo> viewList = connector.getViewList();
		Assert.assertNotNull(viewList);
			
		// Find the document view		
		String viewId = null;
		ViewInfo theView = null;
		for (ViewInfo view : viewList) {
			if (getViewName().equals(view.getName())) {
				viewId = view.getId();
				theView = view;
				break;
			}
		}

		Assert.assertNotNull(viewId);
		Assert.assertNotNull(theView);
		
		// Test that the view can be retrieved by ID
		ViewDetails viewById = connector.getViewById(viewId);
		Assert.assertNotNull(viewById);
		Assert.assertEquals(theView.getName(), viewById.getName());
		Assert.assertEquals(theView.getCategory(), viewById.getCategory());
		Assert.assertEquals(theView.getDescription(), viewById.getDescription());
		Assert.assertEquals(theView.getId(), viewById.getId());
		Assert.assertEquals(theView.getClassifier(), viewById.getClassifier());

		// Test that the view can be retrieved by name
		ViewDetails viewByName = connector.getViewByName(getViewName());
		Assert.assertNotNull(viewByName);
		Assert.assertEquals(theView.getName(), viewByName.getName());
		Assert.assertEquals(theView.getCategory(), viewByName.getCategory());
		Assert.assertEquals(theView.getDescription(), viewByName.getDescription());
		Assert.assertEquals(theView.getId(), viewByName.getId());
		Assert.assertEquals(theView.getClassifier(), viewByName.getClassifier());
		
		Assert.assertEquals(viewById, viewByName);
	}
	
	@Test
	public void testRunViewNoFilter() throws Exception {
		ViewResults viewResults = connector.runViewByName(getViewName(), "");
		List<ViewResultRow> theResults = viewResults.getResultRows();
		Assert.assertTrue(theResults.size()>0);
	}
	
	@Test
	public void testRunViewWithFilter() throws Exception {
		UpdateKeys testKeys = createKeys("TEST_FIELD");
		
		// Create 5 documents to find using a view
		createDocument("Test Document1", testKeys);
		createDocument("Test Document2", testKeys);
		createDocument("Test Document3", testKeys);
		createDocument("Test Document4", createKeys("TEST"));
		createDocument("Test Document5", createKeys("TEST"));		

		// Run the view with VSL filter
		String vslText = String.format("[field1] = '%s'", testKeys.field1);
		ViewResults viewResults = connector.runViewByName(getViewName(), vslText);
		
		// Verify results
		List<ViewResultRow> theResults = viewResults.getResultRows();
		Assert.assertTrue(theResults.size() == 3);
	}
	
	private String getViewName() throws Exception {
		return getProperty("view.name");
	}

	@After
	public void shutdown() throws Exception {
		super.shutdown();
	}
}


