package com.perceptivesoftware.mule.connector.client;

import java.util.Arrays;
import java.util.List;

import com.perceptivesoftware.mule.connector.client.exceptions.IntegrationServerConnectorException;
import com.perceptivesoftware.mule.connector.client.model.drawer.Drawer;
import com.perceptivesoftware.mule.connector.client.model.drawer.DrawerInfo;
import com.perceptivesoftware.mule.connector.client.model.drawerdetails.DrawerDetails;

public class DrawerEndpoint extends AbstractEndpoint {

	public DrawerEndpoint(IntegrationServerClient client) {
		super(client, "drawer");
	}
	
	public Drawer  getDrawerList() throws IntegrationServerConnectorException {		
		return execute(null, null, "GET", null, Drawer.class, null, null, null);
	}
	
	public DrawerDetails getDrawerDetails(String drawerId) throws IntegrationServerConnectorException {
		return execute(Arrays.asList(drawerId), null, "GET", null, DrawerDetails.class, null, null, null);
	}

	
	public String findDrawerId( String name, List<DrawerInfo> drawers) throws IntegrationServerConnectorException {
		for ( DrawerInfo info : drawers)	{
			if ( name.equals(info.getName())) {
				return info.getId();
			}
		}
		throw new IntegrationServerConnectorException( "Unable to find drawer" + name );
	}
}
