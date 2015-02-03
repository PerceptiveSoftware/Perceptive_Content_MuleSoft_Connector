package com.perceptivesoftware.mule.connector.client;

import java.util.Arrays;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.routeitem.RouteItem;
import com.perceptivesoftware.mule.connector.client.model.workflowitem.AddWorkflowItem;
import com.perceptivesoftware.mule.connector.client.model.workflowitem.WorkflowItem;
import com.perceptivesoftware.mule.connector.client.util.QueryParmeters;
import com.sun.jersey.api.client.ClientResponse;

public class WorkflowItemEndpoint extends AbstractEndpoint {

	public WorkflowItemEndpoint(IntegrationServerClient client) {
		super(client, "workflowItem");
	}
	
	public WorkflowItem getWorkflowItem(String workflowItemId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(workflowItemId), null, "GET", null, WorkflowItem.class, null, null, null);
	}
	
	public void routeItem(String workflowItem, RouteItem routeItem) throws IntegrationServerConnectorException {
		execute(Arrays.asList(workflowItem, "routingAction"), null, "POST", null, null, null, null,routeItem);
	}
	
	public String addItemToWorkflow(AddWorkflowItem item) throws IntegrationServerConnectorException {
		
		ClientResponse response = execute(null,null, "POST", null, null, null, item);
			
		return getWorkflowIdFromLocation(response.getHeaders().getFirst(
				"Location"));
	}
	
	public void removeFromWorkflow(String workflowId, String queueId) throws IntegrationServerConnectorException {
		execute(Arrays.asList(workflowId),QueryParmeters.create().add("workflowQueueId", queueId), "DELETE", null, null, null, null,null);
	}
	
	private String getWorkflowIdFromLocation(String location) {
		return location.substring(location.lastIndexOf("/") + 1);
	}
}
