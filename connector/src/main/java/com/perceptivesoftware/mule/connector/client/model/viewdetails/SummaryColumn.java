
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
    "filterValue",
    "function",
    "id",
    "identifierColumnId",
    "label",
    "sequence"
})
public class SummaryColumn {

    @JsonProperty("columnId")
    private String columnId;
    @JsonProperty("filterValue")
    private String filterValue;
    @JsonProperty("function")
    private String function;
    @JsonProperty("id")
    private String id;
    @JsonProperty("identifierColumnId")
    private Object identifierColumnId;
    @JsonProperty("label")
    private String label;
    @JsonProperty("sequence")
    private Integer sequence;
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
     *     The filterValue
     */
    @JsonProperty("filterValue")
    public String getFilterValue() {
        return filterValue;
    }

    /**
     * 
     * @param filterValue
     *     The filterValue
     */
    @JsonProperty("filterValue")
    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    /**
     * 
     * @return
     *     The function
     */
    @JsonProperty("function")
    public String getFunction() {
        return function;
    }

    /**
     * 
     * @param function
     *     The function
     */
    @JsonProperty("function")
    public void setFunction(String function) {
        this.function = function;
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
     *     The identifierColumnId
     */
    @JsonProperty("identifierColumnId")
    public Object getIdentifierColumnId() {
        return identifierColumnId;
    }

    /**
     * 
     * @param identifierColumnId
     *     The identifierColumnId
     */
    @JsonProperty("identifierColumnId")
    public void setIdentifierColumnId(Object identifierColumnId) {
        this.identifierColumnId = identifierColumnId;
    }

    /**
     * 
     * @return
     *     The label
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The sequence
     */
    @JsonProperty("sequence")
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 
     * @param sequence
     *     The sequence
     */
    @JsonProperty("sequence")
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
        return new HashCodeBuilder().append(columnId).append(filterValue).append(function).append(id).append(identifierColumnId).append(label).append(sequence).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SummaryColumn) == false) {
            return false;
        }
        SummaryColumn rhs = ((SummaryColumn) other);
        return new EqualsBuilder().append(columnId, rhs.columnId).append(filterValue, rhs.filterValue).append(function, rhs.function).append(id, rhs.id).append(identifierColumnId, rhs.identifierColumnId).append(label, rhs.label).append(sequence, rhs.sequence).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
