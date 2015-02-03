
package com.perceptivesoftware.mule.connector.client.model.document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "info",
    "workflowItems",
    "pages",
    "properties"
})
public class Document {


	@JsonProperty("info")
	public Info info;
    @JsonProperty("workflowItems")
    private List<WorkflowItem> workflowItems = new ArrayList<WorkflowItem>();
    @JsonProperty("pages")
    private List<Page> pages = new ArrayList<Page>();
    @JsonProperty("properties")
    private List<Property> properties = new ArrayList<Property>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The info
     */
    @JsonProperty("info")
	@JsonValue()
    public Info getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    /**
     * 
     * @return
     *     The workflowItems
     */
    @JsonProperty("workflowItems")
    public List<WorkflowItem> getWorkflowItems() {
        return workflowItems;
    }

    /**
     * 
     * @param workflowItems
     *     The workflowItems
     */
    @JsonProperty("workflowItems")
    public void setWorkflowItems(List<WorkflowItem> workflowItems) {
        this.workflowItems = workflowItems;
    }

    /**
     * 
     * @return
     *     The pages
     */
    @JsonProperty("pages")
    public List<Page> getPages() {
        return pages;
    }

    /**
     * 
     * @param pages
     *     The pages
     */
    @JsonProperty("pages")
    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    /**
     * 
     * @return
     *     The properties
     */
    @JsonProperty("properties")
	@JsonValue()
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties
     *     The properties
     */
    @JsonProperty("properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(info).append(workflowItems).append(pages).append(properties).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return new EqualsBuilder().append(info, rhs.info).append(workflowItems, rhs.workflowItems).append(pages, rhs.pages).append(properties, rhs.properties).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
	public boolean isCustomProperty( String id, List<Property> propList )
	{
		boolean found = false;

		for ( Property prop : propList )
		{
			if ( id.equals(prop.getId()) )
			{	
				found = true;
				break;
			}
		}

		return found;
	}	
}
