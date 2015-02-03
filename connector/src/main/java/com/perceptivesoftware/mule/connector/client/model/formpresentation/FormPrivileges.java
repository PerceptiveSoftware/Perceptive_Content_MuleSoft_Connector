
package com.perceptivesoftware.mule.connector.client.model.formpresentation;

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
    "createPriv",
    "deletePriv",
    "modifyPriv",
    "viewPriv"
})
public class FormPrivileges {

    @JsonProperty("createPriv")
    private Boolean createPriv;
    @JsonProperty("deletePriv")
    private Boolean deletePriv;
    @JsonProperty("modifyPriv")
    private Boolean modifyPriv;
    @JsonProperty("viewPriv")
    private Boolean viewPriv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The createPriv
     */
    @JsonProperty("createPriv")
    public Boolean getCreatePriv() {
        return createPriv;
    }

    /**
     * 
     * @param createPriv
     *     The createPriv
     */
    @JsonProperty("createPriv")
    public void setCreatePriv(Boolean createPriv) {
        this.createPriv = createPriv;
    }

    /**
     * 
     * @return
     *     The deletePriv
     */
    @JsonProperty("deletePriv")
    public Boolean getDeletePriv() {
        return deletePriv;
    }

    /**
     * 
     * @param deletePriv
     *     The deletePriv
     */
    @JsonProperty("deletePriv")
    public void setDeletePriv(Boolean deletePriv) {
        this.deletePriv = deletePriv;
    }

    /**
     * 
     * @return
     *     The modifyPriv
     */
    @JsonProperty("modifyPriv")
    public Boolean getModifyPriv() {
        return modifyPriv;
    }

    /**
     * 
     * @param modifyPriv
     *     The modifyPriv
     */
    @JsonProperty("modifyPriv")
    public void setModifyPriv(Boolean modifyPriv) {
        this.modifyPriv = modifyPriv;
    }

    /**
     * 
     * @return
     *     The viewPriv
     */
    @JsonProperty("viewPriv")
    public Boolean getViewPriv() {
        return viewPriv;
    }

    /**
     * 
     * @param viewPriv
     *     The viewPriv
     */
    @JsonProperty("viewPriv")
    public void setViewPriv(Boolean viewPriv) {
        this.viewPriv = viewPriv;
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
        return new HashCodeBuilder().append(createPriv).append(deletePriv).append(modifyPriv).append(viewPriv).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FormPrivileges) == false) {
            return false;
        }
        FormPrivileges rhs = ((FormPrivileges) other);
        return new EqualsBuilder().append(createPriv, rhs.createPriv).append(deletePriv, rhs.deletePriv).append(modifyPriv, rhs.modifyPriv).append(viewPriv, rhs.viewPriv).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
