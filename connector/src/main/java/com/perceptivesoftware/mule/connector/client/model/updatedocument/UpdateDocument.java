
package com.perceptivesoftware.mule.connector.client.model.updatedocument;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "info",
    "properties"
})
public class UpdateDocument {

    @JsonProperty("info")
	public UpdateInfo info;
    @JsonProperty("properties")
    public List<UpdateProperty> properties = new ArrayList<UpdateProperty>();
   
    /**
     * 
     * @return
     *     The info
     */
    @JsonProperty("info")
    public UpdateInfo getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    @JsonProperty("info")
    public void setInfo(UpdateInfo info) {
        this.info = info;
    }

    /**
     * 
     * @return
     *     The properties
     */
    @JsonProperty("properties")
    public List<UpdateProperty> getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties
     *     The properties
     */
    @JsonProperty("properties")
    public void setProperties(List<UpdateProperty> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(info).append(properties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateDocument) == false) {
            return false;
        }
        UpdateDocument rhs = ((UpdateDocument) other);
        return new EqualsBuilder().append(info, rhs.info).append(properties, rhs.properties).isEquals();
    }
    
}
