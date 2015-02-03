
package com.perceptivesoftware.mule.connector.client.model.property;

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
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "properties"
})
public class PropertyList {

    @JsonProperty("properties")
    private List<PropertyInfo> properties = new ArrayList<PropertyInfo>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The properties
     */
    @JsonProperty("properties")
    public List<PropertyInfo> getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties
     *     The properties
     */
    @JsonProperty("properties")
    public void setProperties(List<PropertyInfo> properties) {
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
        return new HashCodeBuilder().append(properties).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PropertyList) == false) {
            return false;
        }
        PropertyList rhs = ((PropertyList) other);
        return new EqualsBuilder().append(properties, rhs.properties).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
	public PropertyInfo findPropertyName(String name) {
		PropertyInfo retProp = null;

		for (PropertyInfo prop : properties) {
			if (name.equals(prop.getName())) {
				retProp = prop;
				break;
			}
		}

		return retProp;
	}
	
	public PropertyInfo findPropertyId(String id) {
		PropertyInfo retProp = null;

		for (PropertyInfo prop : properties) {
			if (id.equals(prop.getId())) {
				retProp = prop;
				break;
			}
		}

		return retProp;
	}	

}
