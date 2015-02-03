
package com.perceptivesoftware.mule.connector.client.model.workflowqueues;

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
    "workflowQueues"
})
public class WorkflowQueues {

    @JsonProperty("workflowQueues")
    private List<WorkflowQueueInfo> workflowQueues = new ArrayList<WorkflowQueueInfo>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The workflowQueues
     */
    @JsonProperty("workflowQueues")
    public List<WorkflowQueueInfo> getWorkflowQueues() {
        return workflowQueues;
    }

    /**
     * 
     * @param workflowQueues
     *     The workflowQueues
     */
    @JsonProperty("workflowQueues")
    public void setWorkflowQueues(List<WorkflowQueueInfo> workflowQueues) {
        this.workflowQueues = workflowQueues;
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
        return new HashCodeBuilder().append(workflowQueues).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkflowQueues) == false) {
            return false;
        }
        WorkflowQueues rhs = ((WorkflowQueues) other);
        return new EqualsBuilder().append(workflowQueues, rhs.workflowQueues).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
