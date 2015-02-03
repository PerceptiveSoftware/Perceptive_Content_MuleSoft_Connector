
package com.perceptivesoftware.mule.connector.client.model.routeitem;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "originWorkflowQueueId",
    "originWorkflowQueueName",
    "destinationWorkflowQueueId",
    "routeType",
    "reason"
})
public class RouteItem {

    @JsonProperty("originWorkflowQueueId")
    private String originWorkflowQueueId;
    @JsonProperty("originWorkflowQueueName")
    private String originWorkflowQueueName;
    @JsonProperty("destinationWorkflowQueueId")
    private String destinationWorkflowQueueId;
    @JsonProperty("routeType")
    private String routeType;
    @JsonProperty("reason")
    private String reason;
   

    /**
     * 
     * @return
     *     The originWorkflowQueueId
     */
    @JsonProperty("originWorkflowQueueId")
    public String getOriginWorkflowQueueId() {
        return originWorkflowQueueId;
    }

    /**
     * 
     * @param originWorkflowQueueId
     *     The originWorkflowQueueId
     */
    @JsonProperty("originWorkflowQueueId")
    public void setOriginWorkflowQueueId(String originWorkflowQueueId) {
        this.originWorkflowQueueId = originWorkflowQueueId;
    }

    /**
     * 
     * @return
     *     The originWorkflowQueueName
     */
    @JsonProperty("originWorkflowQueueName")
    public String getOriginWorkflowQueueName() {
        return originWorkflowQueueName;
    }

    /**
     * 
     * @param originWorkflowQueueName
     *     The originWorkflowQueueName
     */
    @JsonProperty("originWorkflowQueueName")
    public void setOriginWorkflowQueueName(String originWorkflowQueueName) {
        this.originWorkflowQueueName = originWorkflowQueueName;
    }

    /**
     * 
     * @return
     *     The destinationWorkflowQueueId
     */
    @JsonProperty("destinationWorkflowQueueId")
    public String getDestinationWorkflowQueueId() {
        return destinationWorkflowQueueId;
    }

    /**
     * 
     * @param destinationWorkflowQueueId
     *     The destinationWorkflowQueueId
     */
    @JsonProperty("destinationWorkflowQueueId")
    public void setDestinationWorkflowQueueId(String destinationWorkflowQueueId) {
        this.destinationWorkflowQueueId = destinationWorkflowQueueId;
    }

    /**
     * 
     * @return
     *     The routeType
     */
    @JsonProperty("routeType")
    public String getRouteType() {
        return routeType;
    }

    /**
     * 
     * @param routeType
     *     The routeType
     */
    @JsonProperty("routeType")
    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    /**
     * 
     * @return
     *     The reason
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * 
     * @param reason
     *     The reason
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
   
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(originWorkflowQueueId).append(originWorkflowQueueName).append(destinationWorkflowQueueId).append(routeType).append(reason).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RouteItem) == false) {
            return false;
        }
        RouteItem rhs = ((RouteItem) other);
        return new EqualsBuilder().append(originWorkflowQueueId, rhs.originWorkflowQueueId).append(originWorkflowQueueName, rhs.originWorkflowQueueName).append(destinationWorkflowQueueId, rhs.destinationWorkflowQueueId).append(routeType, rhs.routeType).append(reason, rhs.reason).isEquals();
    }  
}
