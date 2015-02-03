
package com.perceptivesoftware.mule.connector.client.model.formpresentation;

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
    "dataDefinition",
    "supportFiles"
})
public class FormPresentationInfo {

    @JsonProperty("dataDefinition")
    private DataDefinition dataDefinition;
    @JsonProperty("supportFiles")
    private List<SupportFile> supportFiles = new ArrayList<SupportFile>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The dataDefinition
     */
    @JsonProperty("dataDefinition")
    public DataDefinition getDataDefinition() {
        return dataDefinition;
    }

    /**
     * 
     * @param dataDefinition
     *     The dataDefinition
     */
    @JsonProperty("dataDefinition")
    public void setDataDefinition(DataDefinition dataDefinition) {
        this.dataDefinition = dataDefinition;
    }

    /**
     * 
     * @return
     *     The supportFiles
     */
    @JsonProperty("supportFiles")
    public List<SupportFile> getSupportFiles() {
        return supportFiles;
    }

    /**
     * 
     * @param supportFiles
     *     The supportFiles
     */
    @JsonProperty("supportFiles")
    public void setSupportFiles(List<SupportFile> supportFiles) {
        this.supportFiles = supportFiles;
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
        return new HashCodeBuilder().append(dataDefinition).append(supportFiles).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FormPresentationInfo) == false) {
            return false;
        }
        FormPresentationInfo rhs = ((FormPresentationInfo) other);
        return new EqualsBuilder().append(dataDefinition, rhs.dataDefinition).append(supportFiles, rhs.supportFiles).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
