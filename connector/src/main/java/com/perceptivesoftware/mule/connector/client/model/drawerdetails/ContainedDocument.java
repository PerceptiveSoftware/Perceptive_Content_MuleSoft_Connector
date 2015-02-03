
package com.perceptivesoftware.mule.connector.client.model.drawerdetails;

import java.util.HashMap;
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
    "id",
    "targetId",
    "name",
    "keys"
})
public class ContainedDocument {

    @JsonProperty("id")
    private String id;
    @JsonProperty("targetId")
    private String targetId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("keys")
    private Keys keys;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The targetId
     */
    @JsonProperty("targetId")
    public String getTargetId() {
        return targetId;
    }

    /**
     * 
     * @param targetId
     *     The targetId
     */
    @JsonProperty("targetId")
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

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
     *     The keys
     */
    @JsonProperty("keys")
    public Keys getKeys() {
        return keys;
    }

    /**
     * 
     * @param keys
     *     The keys
     */
    @JsonProperty("keys")
    public void setKeys(Keys keys) {
        this.keys = keys;
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
        return new HashCodeBuilder().append(id).append(targetId).append(name).append(keys).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContainedDocument) == false) {
            return false;
        }
        ContainedDocument rhs = ((ContainedDocument) other);
        return new EqualsBuilder().append(id, rhs.id).append(targetId, rhs.targetId).append(name, rhs.name).append(keys, rhs.keys).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
