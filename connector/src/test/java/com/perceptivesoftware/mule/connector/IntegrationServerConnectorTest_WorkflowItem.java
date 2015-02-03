package com.perceptivesoftware.mule.connector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.perceptivesoftware.mule.connector.client.model.document.Document;
import com.perceptivesoftware.mule.connector.client.model.document.WorkflowItem;
import com.perceptivesoftware.mule.connector.client.model.workflowqueues.WorkflowQueueInfo;

public class IntegrationServerConnectorTest_WorkflowItem extends BaseTest {

	private Map<String, String> cleanupWorkflows;
	
	@Before
	public void startup() throws Exception {
		super.startup();
		cleanupWorkflows = new HashMap<String, String>();
	}

	@Test
	public void testWorkflowProcessors() throws Exception {

		// Create a document
		String documentId = createDocument("Test Document", createKeys("TEST"));

		// Put the item in workflow
		String wfItem = connector.addItemToWorkflow(documentId, "DOCUMENT",
				getOriginQueueName(), "LOW");

		// Get the document to verify it has the expected workflow items
		Document theDoc = connector.getDocument(documentId);
		List<WorkflowItem> docWFItems = theDoc.getWorkflowItems();

		Assert.assertEquals(1, docWFItems.size());
		Assert.assertEquals(wfItem, docWFItems.get(0).getId());

		// Assert that the workflow item resides in the expected queue
		com.perceptivesoftware.mule.connector.client.model.workflowitem.WorkflowItem wfInfo = connector
				.GetWorkflowItemInfo(wfItem);

		Assert.assertEquals(getOriginQueueName(), wfInfo.getWorkflowQueueName());
		
		// Route the item forward
		String qId = findWorkflowQId(getOriginQueueName());
		String destQId = findWorkflowQId(getDestinationQueueName());

		connector.routeWorkflowItem(wfItem, qId, getOriginQueueName(), destQId,
				"routeReason");

		// Verify th document now reflects th new location
		theDoc = connector.getDocument(documentId);
		docWFItems = theDoc.getWorkflowItems();

		Assert.assertEquals(1, docWFItems.size());
		Assert.assertEquals(wfItem, docWFItems.get(0).getId());

		// Assert that the workflow item resides in the expected queue
		wfInfo = connector.GetWorkflowItemInfo(wfItem);

		Assert.assertEquals(getDestinationQueueName(), wfInfo.getWorkflowQueueName());
		
		// Remove the item from workflow
		connector.removeFromWorkflow(wfItem, getDestinationQueueName());

		// Verify that th document is no longer in a workflow
		theDoc = connector.getDocument(documentId);
		docWFItems = theDoc.getWorkflowItems();

		Assert.assertTrue(docWFItems.isEmpty());
	}

	private String findWorkflowQId(String queueName) throws Exception {
		List<WorkflowQueueInfo> theList = connector.getWorkflowQueues();
		for (WorkflowQueueInfo que : theList) {
			if (queueName.equals(que.getName())) {
				return que.getId();
			}
		}

		throw new Exception("Unable to find Queue " + queueName);
	}

	private String getOriginQueueName() throws Exception {
		return getProperty("workflow.queue.origin");
	}
	
	private String getDestinationQueueName() throws Exception {
		return getProperty("workflow.queue.destination");
	}	

	@After
	public void shutdown() throws Exception {
		// Remove the workflow items
		for (String wfId : cleanupWorkflows.keySet()) {
			try {
				String queueName = cleanupWorkflows.get(wfId);
				connector.removeFromWorkflow(wfId, queueName);
			} catch (Exception e) {
				// meh
			}
		}
		
		super.shutdown();
	}
}
