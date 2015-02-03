
package com.perceptivesoftware.mule.connector.client.model.documenttypedetails;

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
    "id",
    "name",
    "type",
    "userGroupId",
    "userGroupName",
    "defaultValue",
    "listValueCandidates",
    "userList",
    "children",
    "formats",
    "required"
})
public class PropertyDocumentType {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("userGroupId")
    private Object userGroupId;
    @JsonProperty("userGroupName")
    private Object userGroupName;
    @JsonProperty("defaultValue")
    private Object defaultValue;
    @JsonProperty("listValueCandidates")
    private List<String> listValueCandidates = new ArrayList<String>();
    @JsonProperty("userList")
    private Object userList;
    @JsonProperty("children")
    private Object children;
    @JsonProperty("formats")
    private Object formats;
    @JsonProperty("required")
    private Boolean required;
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
     *     The userGroupId
     */
    @JsonProperty("userGroupId")
    public Object getUserGroupId() {
        return userGroupId;
    }

    /**
     * 
     * @param userGroupId
     *     The userGroupId
     */
    @JsonProperty("userGroupId")
    public void setUserGroupId(Object userGroupId) {
        this.userGroupId = userGroupId;
    }

    /**
     * 
     * @return
     *     The userGroupName
     */
    @JsonProperty("userGroupName")
    public Object getUserGroupName() {
        return userGroupName;
    }

    /**
     * 
     * @param userGroupName
     *     The userGroupName
     */
    @JsonProperty("userGroupName")
    public void setUserGroupName(Object userGroupName) {
        this.userGroupName = userGroupName;
    }

    /**
     * 
     * @return
     *     The defaultValue
     */
    @JsonProperty("defaultValue")
    public Object getDefaultValue() {
        return defaultValue;
    }

    /**
     * 
     * @param defaultValue
     *     The defaultValue
     */
    @JsonProperty("defaultValue")
    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 
     * @return
     *     The listValueCandidates
     */
    @JsonProperty("listValueCandidates")
    public List<String> getListValueCandidates() {
        return listValueCandidates;
    }

    /**
     * 
     * @param listValueCandidates
     *     The listValueCandidates
     */
    @JsonProperty("listValueCandidates")
    public void setListValueCandidates(List<String> listValueCandidates) {
        this.listValueCandidates = listValueCandidates;
    }

    /**
     * 
     * @return
     *     The userList
     */
    @JsonProperty("userList")
    public Object getUserList() {
        return userList;
    }

    /**
     * 
     * @param userList
     *     The userList
     */
    @JsonProperty("userList")
    public void setUserList(Object userList) {
        this.userList = userList;
    }

    /**
     * 
     * @return
     *     The children
     */
    @JsonProperty("children")
    public Object getChildren() {
        return children;
    }

    /**
     * 
     * @param children
     *     The children
     */
    @JsonProperty("children")
    public void setChildren(Object children) {
        this.children = children;
    }

    /**
     * 
     * @return
     *     The formats
     */
    @JsonProperty("formats")
    public Object getFormats() {
        return formats;
    }

    /**
     * 
     * @param formats
     *     The formats
     */
    @JsonProperty("formats")
    public void setFormats(Object formats) {
        this.formats = formats;
    }

    /**
     * 
     * @return
     *     The required
     */
    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    /**
     * 
     * @param required
     *     The required
     */
    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
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
        return new HashCodeBuilder().append(id).append(name).append(type).append(userGroupId).append(userGroupName).append(defaultValue).append(listValueCandidates).append(userList).append(children).append(formats).append(required).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PropertyDocumentType) == false) {
            return false;
        }
        PropertyDocumentType rhs = ((PropertyDocumentType) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(type, rhs.type).append(userGroupId, rhs.userGroupId).append(userGroupName, rhs.userGroupName).append(defaultValue, rhs.defaultValue).append(listValueCandidates, rhs.listValueCandidates).append(userList, rhs.userList).append(children, rhs.children).append(formats, rhs.formats).append(required, rhs.required).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
