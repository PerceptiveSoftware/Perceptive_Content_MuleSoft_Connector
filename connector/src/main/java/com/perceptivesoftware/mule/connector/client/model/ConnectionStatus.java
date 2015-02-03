package com.perceptivesoftware.mule.connector.client.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
	"version"
})
public class ConnectionStatus
{
	@JsonProperty("version")
	private String version;

	@JsonProperty("version")
	public String getVersion() 
	{
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) 
	{
		this.version = version;
	}
}