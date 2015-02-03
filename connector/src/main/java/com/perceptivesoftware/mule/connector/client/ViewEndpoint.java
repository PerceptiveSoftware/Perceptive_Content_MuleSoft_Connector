package com.perceptivesoftware.mule.connector.client;

import java.util.Arrays;
import java.util.List;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.viewdetails.ViewDetails;
import com.perceptivesoftware.mule.connector.client.model.viewresults.ViewResults;
import com.perceptivesoftware.mule.connector.client.model.viewresults.VslRequest;
import com.perceptivesoftware.mule.connector.client.model.views.ViewInfo;
import com.perceptivesoftware.mule.connector.client.model.views.Views;
import com.perceptivesoftware.mule.connector.client.util.QueryParmeters;

public class ViewEndpoint extends AbstractEndpoint {

	public ViewEndpoint(IntegrationServerClient client) {
		super(client, "view");
	}
	
	public Views getViews() throws IntegrationServerConnectorException {
		 return execute(null, null, "GET", null, Views.class, null, null, null);
	}
	
	public ViewDetails getViewById(String viewId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(viewId), QueryParmeters.create().add("category", "DOCUMENT"), "GET", null, ViewDetails.class, null, null, null);
	}
	 
	public ViewResults runView( String viewId, VslRequest vsl) throws IntegrationServerConnectorException {
		ViewResults justChecking = execute(Arrays.asList(viewId, "result"), QueryParmeters.create().add("category", "DOCUMENT"), "POST",null, ViewResults.class, null,null,vsl);
		return justChecking;
	}
	public String findView( String name, List<ViewInfo> views) throws IntegrationServerConnectorException {
		for ( ViewInfo info : views)	{
			if ( name.equals(info.getName())) {
				return info.getId();
			}
		}
		throw new IntegrationServerConnectorException( "Unable to find drawer" + name );
	}

}
