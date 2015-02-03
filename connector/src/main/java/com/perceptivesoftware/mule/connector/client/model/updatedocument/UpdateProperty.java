
package com.perceptivesoftware.mule.connector.client.model.updatedocument;

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
    "id",
    "value",
    "type",
    "childProperties"
})
public class UpdateProperty {

    @JsonProperty("id")
    private String id;
    @JsonProperty("value")
    private String value;
    @JsonProperty("type")
    private String type;
    @JsonProperty("childProperties")
    private Object childProperties;

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The childProperties
     */
    @JsonProperty("childProperties")
    public Object getChildProperties() {
        return childProperties;
    }

    /**
     * 
     * @param childProperties
     *     The childProperties
     */
    @JsonProperty("childProperties")
    public void setChildProperties(Object childProperties) {
        this.childProperties = childProperties;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(value).append(type).append(childProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateProperty) == false) {
            return false;
        }
        UpdateProperty rhs = ((UpdateProperty) other);
        return new EqualsBuilder().append(id, rhs.id).append(value, rhs.value).append(type, rhs.type).append(childProperties, rhs.childProperties).isEquals();
    }

}
