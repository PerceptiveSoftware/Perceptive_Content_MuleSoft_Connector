
package com.perceptivesoftware.mule.connector.client.model.drawerdetails;

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
    "name",
    "id",
    "containedFolders",
    "containedDocuments"
})
public class DrawerDetails {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("containedFolders")
    private List<ContainedFolder> containedFolders = new ArrayList<ContainedFolder>();
    @JsonProperty("containedDocuments")
    private List<ContainedDocument> containedDocuments = new ArrayList<ContainedDocument>();
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
     *     The containedFolders
     */
    @JsonProperty("containedFolders")
    public List<ContainedFolder> getContainedFolders() {
        return containedFolders;
    }

    /**
     * 
     * @param containedFolders
     *     The containedFolders
     */
    @JsonProperty("containedFolders")
    public void setContainedFolders(List<ContainedFolder> containedFolders) {
        this.containedFolders = containedFolders;
    }

    /**
     * 
     * @return
     *     The containedDocuments
     */
    @JsonProperty("containedDocuments")
    public List<ContainedDocument> getContainedDocuments() {
        return containedDocuments;
    }

    /**
     * 
     * @param containedDocuments
     *     The containedDocuments
     */
    @JsonProperty("containedDocuments")
    public void setContainedDocuments(List<ContainedDocument> containedDocuments) {
        this.containedDocuments = containedDocuments;
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
        return new HashCodeBuilder().append(name).append(id).append(containedFolders).append(containedDocuments).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DrawerDetails) == false) {
            return false;
        }
        DrawerDetails rhs = ((DrawerDetails) other);
        return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).append(containedFolders, rhs.containedFolders).append(containedDocuments, rhs.containedDocuments).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
