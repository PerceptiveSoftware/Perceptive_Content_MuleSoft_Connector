
package com.perceptivesoftware.mule.connector.client.model.workflowqueueforwardroute;

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
    "forwardRoutes"
})
public class WorkflowQueueForwardRoute {

    @JsonProperty("forwardRoutes")
    private List<ForwardRoute> forwardRoutes = new ArrayList<ForwardRoute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The forwardRoutes
     */
    @JsonProperty("forwardRoutes")
    public List<ForwardRoute> getForwardRoutes() {
        return forwardRoutes;
    }

    /**
     * 
     * @param forwardRoutes
     *     The forwardRoutes
     */
    @JsonProperty("forwardRoutes")
    public void setForwardRoutes(List<ForwardRoute> forwardRoutes) {
        this.forwardRoutes = forwardRoutes;
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
        return new HashCodeBuilder().append(forwardRoutes).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkflowQueueForwardRoute) == false) {
            return false;
        }
        WorkflowQueueForwardRoute rhs = ((WorkflowQueueForwardRoute) other);
        return new EqualsBuilder().append(forwardRoutes, rhs.forwardRoutes).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
