
package com.perceptivesoftware.mule.connector.client.model.viewdetails;

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
    "columnId",
    "dataType",
    "displayType",
    "groupOrder",
    "id",
    "name",
    "sortDirection",
    "sortOrder",
    "width"
})
public class Column {

    @JsonProperty("columnId")
    private String columnId;
    @JsonProperty("dataType")
    private String dataType;
    @JsonProperty("displayType")
    private String displayType;
    @JsonProperty("groupOrder")
    private Integer groupOrder;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sortDirection")
    private String sortDirection;
    @JsonProperty("sortOrder")
    private Integer sortOrder;
    @JsonProperty("width")
    private Integer width;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The columnId
     */
    @JsonProperty("columnId")
    public String getColumnId() {
        return columnId;
    }

    /**
     * 
     * @param columnId
     *     The columnId
     */
    @JsonProperty("columnId")
    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    /**
     * 
     * @return
     *     The dataType
     */
    @JsonProperty("dataType")
    public String getDataType() {
        return dataType;
    }

    /**
     * 
     * @param dataType
     *     The dataType
     */
    @JsonProperty("dataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 
     * @return
     *     The displayType
     */
    @JsonProperty("displayType")
    public String getDisplayType() {
        return displayType;
    }

    /**
     * 
     * @param displayType
     *     The displayType
     */
    @JsonProperty("displayType")
    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    /**
     * 
     * @return
     *     The groupOrder
     */
    @JsonProperty("groupOrder")
    public Integer getGroupOrder() {
        return groupOrder;
    }

    /**
     * 
     * @param groupOrder
     *     The groupOrder
     */
    @JsonProperty("groupOrder")
    public void setGroupOrder(Integer groupOrder) {
        this.groupOrder = groupOrder;
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
     *     The sortDirection
     */
    @JsonProperty("sortDirection")
    public String getSortDirection() {
        return sortDirection;
    }

    /**
     * 
     * @param sortDirection
     *     The sortDirection
     */
    @JsonProperty("sortDirection")
    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    /**
     * 
     * @return
     *     The sortOrder
     */
    @JsonProperty("sortOrder")
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 
     * @param sortOrder
     *     The sortOrder
     */
    @JsonProperty("sortOrder")
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 
     * @return
     *     The width
     */
    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
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
        return new HashCodeBuilder().append(columnId).append(dataType).append(displayType).append(groupOrder).append(id).append(name).append(sortDirection).append(sortOrder).append(width).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Column) == false) {
            return false;
        }
        Column rhs = ((Column) other);
        return new EqualsBuilder().append(columnId, rhs.columnId).append(dataType, rhs.dataType).append(displayType, rhs.displayType).append(groupOrder, rhs.groupOrder).append(id, rhs.id).append(name, rhs.name).append(sortDirection, rhs.sortDirection).append(sortOrder, rhs.sortOrder).append(width, rhs.width).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
