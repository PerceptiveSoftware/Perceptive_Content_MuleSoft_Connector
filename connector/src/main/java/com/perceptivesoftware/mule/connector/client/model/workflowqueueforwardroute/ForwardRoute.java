
package com.perceptivesoftware.mule.connector.client.model.workflowqueueforwardroute;

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
    "type",
    "name",
    "destinationQueueId",
    "destinationQueueName",
    "defaultRoute",
    "adHocParallelRoute"
})
public class ForwardRoute {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("destinationQueueId")
    private Object destinationQueueId;
    @JsonProperty("destinationQueueName")
    private Object destinationQueueName;
    @JsonProperty("defaultRoute")
    private Boolean defaultRoute;
    @JsonProperty("adHocParallelRoute")
    private Boolean adHocParallelRoute;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
     *     The destinationQueueId
     */
    @JsonProperty("destinationQueueId")
    public Object getDestinationQueueId() {
        return destinationQueueId;
    }

    /**
     * 
     * @param destinationQueueId
     *     The destinationQueueId
     */
    @JsonProperty("destinationQueueId")
    public void setDestinationQueueId(Object destinationQueueId) {
        this.destinationQueueId = destinationQueueId;
    }

    /**
     * 
     * @return
     *     The destinationQueueName
     */
    @JsonProperty("destinationQueueName")
    public Object getDestinationQueueName() {
        return destinationQueueName;
    }

    /**
     * 
     * @param destinationQueueName
     *     The destinationQueueName
     */
    @JsonProperty("destinationQueueName")
    public void setDestinationQueueName(Object destinationQueueName) {
        this.destinationQueueName = destinationQueueName;
    }

    /**
     * 
     * @return
     *     The defaultRoute
     */
    @JsonProperty("defaultRoute")
    public Boolean getDefaultRoute() {
        return defaultRoute;
    }

    /**
     * 
     * @param defaultRoute
     *     The defaultRoute
     */
    @JsonProperty("defaultRoute")
    public void setDefaultRoute(Boolean defaultRoute) {
        this.defaultRoute = defaultRoute;
    }

    /**
     * 
     * @return
     *     The adHocParallelRoute
     */
    @JsonProperty("adHocParallelRoute")
    public Boolean getAdHocParallelRoute() {
        return adHocParallelRoute;
    }

    /**
     * 
     * @param adHocParallelRoute
     *     The adHocParallelRoute
     */
    @JsonProperty("adHocParallelRoute")
    public void setAdHocParallelRoute(Boolean adHocParallelRoute) {
        this.adHocParallelRoute = adHocParallelRoute;
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
        return new HashCodeBuilder().append(type).append(name).append(destinationQueueId).append(destinationQueueName).append(defaultRoute).append(adHocParallelRoute).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForwardRoute) == false) {
            return false;
        }
        ForwardRoute rhs = ((ForwardRoute) other);
        return new EqualsBuilder().append(type, rhs.type).append(name, rhs.name).append(destinationQueueId, rhs.destinationQueueId).append(destinationQueueName, rhs.destinationQueueName).append(defaultRoute, rhs.defaultRoute).append(adHocParallelRoute, rhs.adHocParallelRoute).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
