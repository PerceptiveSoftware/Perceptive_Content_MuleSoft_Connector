package com.perceptivesoftware.mule.connector.client;

import java.util.Arrays;
import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.workflowqueueforms.WorkflowQueueForms;
import com.perceptivesoftware.mule.connector.client.model.workflowqueues.WorkflowQueues;

public class WorkflowQueueEndpoint extends AbstractEndpoint {

	public WorkflowQueueEndpoint(IntegrationServerClient client) {
		super(client, "workflowQueue");
	}
	
	public WorkflowQueues getAllWorkflowQueue() throws IntegrationServerConnectorException {		
		 return execute( null, null, "GET", null, WorkflowQueues.class, null, null, null);
	}
	
	public WorkflowQueueForms getWorkflowQueueForms(String queueId) throws IntegrationServerConnectorException {
		 return  execute(Arrays.asList(queueId, "form"), null, "GET", null, WorkflowQueueForms.class, null, null, null);
	}		
}
