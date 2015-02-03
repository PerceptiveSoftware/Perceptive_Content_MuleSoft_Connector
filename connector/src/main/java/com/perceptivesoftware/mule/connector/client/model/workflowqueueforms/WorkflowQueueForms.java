
package com.perceptivesoftware.mule.connector.client.model.workflowqueueforms;

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
    "forms"
})
public class WorkflowQueueForms {

    @JsonProperty("forms")
    private List<WorkflowQueueForm> forms = new ArrayList<WorkflowQueueForm>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The forms
     */
    @JsonProperty("forms")
    public List<WorkflowQueueForm> getForms() {
        return forms;
    }

    /**
     * 
     * @param forms
     *     The forms
     */
    @JsonProperty("forms")
    public void setForms(List<WorkflowQueueForm> forms) {
        this.forms = forms;
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
        return new HashCodeBuilder().append(forms).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkflowQueueForms) == false) {
            return false;
        }
        WorkflowQueueForms rhs = ((WorkflowQueueForms) other);
        return new EqualsBuilder().append(forms, rhs.forms).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
