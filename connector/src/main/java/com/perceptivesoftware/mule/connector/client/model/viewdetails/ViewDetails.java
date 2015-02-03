
package com.perceptivesoftware.mule.connector.client.model.viewdetails;

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
    "category",
    "classifier",
    "autoRun",
    "columns",
    "description",
    "filters",
    "searchPrompts",
    "summaryColumns"
})
public class ViewDetails {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private String category;
    @JsonProperty("classifier")
    private String classifier;
    @JsonProperty("autoRun")
    private Boolean autoRun;
    @JsonProperty("columns")
    private List<Column> columns = new ArrayList<Column>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("filters")
    private List<Filter> filters = new ArrayList<Filter>();
    @JsonProperty("searchPrompts")
    private List<Object> searchPrompts = new ArrayList<Object>();
    @JsonProperty("summaryColumns")
    private List<SummaryColumn> summaryColumns = new ArrayList<SummaryColumn>();
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
     *     The category
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The classifier
     */
    @JsonProperty("classifier")
    public String getClassifier() {
        return classifier;
    }

    /**
     * 
     * @param classifier
     *     The classifier
     */
    @JsonProperty("classifier")
    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    /**
     * 
     * @return
     *     The autoRun
     */
    @JsonProperty("autoRun")
    public Boolean getAutoRun() {
        return autoRun;
    }

    /**
     * 
     * @param autoRun
     *     The autoRun
     */
    @JsonProperty("autoRun")
    public void setAutoRun(Boolean autoRun) {
        this.autoRun = autoRun;
    }

    /**
     * 
     * @return
     *     The columns
     */
    @JsonProperty("columns")
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * 
     * @param columns
     *     The columns
     */
    @JsonProperty("columns")
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The filters
     */
    @JsonProperty("filters")
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    @JsonProperty("filters")
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * 
     * @return
     *     The searchPrompts
     */
    @JsonProperty("searchPrompts")
    public List<Object> getSearchPrompts() {
        return searchPrompts;
    }

    /**
     * 
     * @param searchPrompts
     *     The searchPrompts
     */
    @JsonProperty("searchPrompts")
    public void setSearchPrompts(List<Object> searchPrompts) {
        this.searchPrompts = searchPrompts;
    }

    /**
     * 
     * @return
     *     The summaryColumns
     */
    @JsonProperty("summaryColumns")
    public List<SummaryColumn> getSummaryColumns() {
        return summaryColumns;
    }

    /**
     * 
     * @param summaryColumns
     *     The summaryColumns
     */
    @JsonProperty("summaryColumns")
    public void setSummaryColumns(List<SummaryColumn> summaryColumns) {
        this.summaryColumns = summaryColumns;
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
        return new HashCodeBuilder().append(id).append(name).append(category).append(classifier).append(autoRun).append(columns).append(description).append(filters).append(searchPrompts).append(summaryColumns).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ViewDetails) == false) {
            return false;
        }
        ViewDetails rhs = ((ViewDetails) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(category, rhs.category).append(classifier, rhs.classifier).append(autoRun, rhs.autoRun).append(columns, rhs.columns).append(description, rhs.description).append(filters, rhs.filters).append(searchPrompts, rhs.searchPrompts).append(summaryColumns, rhs.summaryColumns).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
