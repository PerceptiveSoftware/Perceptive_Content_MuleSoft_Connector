
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
    "name",
    "id",
    "targetId",
    "typeId"
})
public class ContainedFolder {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("targetId")
    private Object targetId;
    @JsonProperty("typeId")
    private String typeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
    public Object getTargetId() {
        return targetId;
    }

    /**
     * 
     * @param targetId
     *     The targetId
     */
    @JsonProperty("targetId")
    public void setTargetId(Object targetId) {
        this.targetId = targetId;
    }

    /**
     * 
     * @return
     *     The typeId
     */
    @JsonProperty("typeId")
    public String getTypeId() {
        return typeId;
    }

    /**
     * 
     * @param typeId
     *     The typeId
     */
    @JsonProperty("typeId")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
        return new HashCodeBuilder().append(name).append(id).append(targetId).append(typeId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContainedFolder) == false) {
            return false;
        }
        ContainedFolder rhs = ((ContainedFolder) other);
        return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).append(targetId, rhs.targetId).append(typeId, rhs.typeId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
