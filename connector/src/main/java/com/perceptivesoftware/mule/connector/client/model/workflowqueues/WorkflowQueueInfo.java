
package com.perceptivesoftware.mule.connector.client.model.workflowqueues;

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
    "name",
    "id",
    "onHoldReasonListId",
    "processName",
    "processId"
})
public class WorkflowQueueInfo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("onHoldReasonListId")
    private String onHoldReasonListId;
    @JsonProperty("processName")
    private String processName;
    @JsonProperty("processId")
    private String processId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The onHoldReasonListId
     */
    @JsonProperty("onHoldReasonListId")
    public String getOnHoldReasonListId() {
        return onHoldReasonListId;
    }

    /**
     * 
     * @param onHoldReasonListId
     *     The onHoldReasonListId
     */
    @JsonProperty("onHoldReasonListId")
    public void setOnHoldReasonListId(String onHoldReasonListId) {
        this.onHoldReasonListId = onHoldReasonListId;
    }

    /**
     * 
     * @return
     *     The processName
     */
    @JsonProperty("processName")
    public String getProcessName() {
        return processName;
    }

    /**
     * 
     * @param processName
     *     The processName
     */
    @JsonProperty("processName")
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 
     * @return
     *     The processId
     */
    @JsonProperty("processId")
    public String getProcessId() {
        return processId;
    }

    /**
     * 
     * @param processId
     *     The processId
     */
    @JsonProperty("processId")
    public void setProcessId(String processId) {
        this.processId = processId;
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
        return new HashCodeBuilder().append(name).append(id).append(onHoldReasonListId).append(processName).append(processId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkflowQueueInfo) == false) {
            return false;
        }
        WorkflowQueueInfo rhs = ((WorkflowQueueInfo) other);
        return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).append(onHoldReasonListId, rhs.onHoldReasonListId).append(processName, rhs.processName).append(processId, rhs.processId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
