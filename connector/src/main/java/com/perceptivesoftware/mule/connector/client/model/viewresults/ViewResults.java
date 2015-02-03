
package com.perceptivesoftware.mule.connector.client.model.viewresults;

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
    "hasMore",
    "resultRows"
})
public class ViewResults {

    @JsonProperty("hasMore")
    private Boolean hasMore;
    @JsonProperty("resultRows")
    private List<ViewResultRow> resultRows = new ArrayList<ViewResultRow>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The hasMore
     */
    @JsonProperty("hasMore")
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * 
     * @param hasMore
     *     The hasMore
     */
    @JsonProperty("hasMore")
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     * 
     * @return
     *     The resultRows
     */
    @JsonProperty("resultRows")
    public List<ViewResultRow> getResultRows() {
        return resultRows;
    }

    /**
     * 
     * @param resultRows
     *     The resultRows
     */
    @JsonProperty("resultRows")
    public void setResultRows(List<ViewResultRow> resultRows) {
        this.resultRows = resultRows;
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
        return new HashCodeBuilder().append(hasMore).append(resultRows).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ViewResults) == false) {
            return false;
        }
        ViewResults rhs = ((ViewResults) other);
        return new EqualsBuilder().append(hasMore, rhs.hasMore).append(resultRows, rhs.resultRows).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
