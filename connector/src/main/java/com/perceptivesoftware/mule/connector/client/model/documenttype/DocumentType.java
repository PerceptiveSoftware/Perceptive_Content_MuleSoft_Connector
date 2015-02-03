
package com.perceptivesoftware.mule.connector.client.model.documenttype;

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
    "documentTypes"
})
public class DocumentType {

    @JsonProperty("documentTypes")
    private List<DocumentTypeInfo> documentTypes = new ArrayList<DocumentTypeInfo>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The documentTypes
     */
    @JsonProperty("documentTypes")
    public List<DocumentTypeInfo> getDocumentTypes() {
        return documentTypes;
    }

    /**
     * 
     * @param documentTypes
     *     The documentTypes
     */
    @JsonProperty("documentTypes")
    public void setDocumentTypes(List<DocumentTypeInfo> documentTypes) {
        this.documentTypes = documentTypes;
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
        return new HashCodeBuilder().append(documentTypes).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentType) == false) {
            return false;
        }
        DocumentType rhs = ((DocumentType) other);
        return new EqualsBuilder().append(documentTypes, rhs.documentTypes).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
