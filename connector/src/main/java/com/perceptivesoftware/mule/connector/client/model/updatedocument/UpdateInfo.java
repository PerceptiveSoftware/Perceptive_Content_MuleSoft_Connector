
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
    "name",
    "locationId",
    "keys"
})
public class UpdateInfo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("locationId")
    private String locationId;
    @JsonProperty("keys")
	public UpdateKeys keys;

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The locationId
     */
    @JsonProperty("locationId")
    public String getLocationId() {
        return locationId;
    }

    /**
     * 
     * @param locationId
     *     The locationId
     */
    @JsonProperty("locationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * 
     * @return
     *     The keys
     */
    @JsonProperty("keys")
    public UpdateKeys getKeys() {
        return keys;
    }

    /**
     * 
     * @param keys
     *     The keys
     */
    @JsonProperty("keys")
    public void setKeys(UpdateKeys keys) {
        this.keys = keys;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(locationId).append(keys).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateInfo) == false) {
            return false;
        }
        UpdateInfo rhs = ((UpdateInfo) other);
        return new EqualsBuilder().append(name, rhs.name).append(locationId, rhs.locationId).append(keys, rhs.keys).isEquals();
    }

}
