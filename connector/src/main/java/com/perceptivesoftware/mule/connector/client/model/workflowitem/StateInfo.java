package com.perceptivesoftware.mule.connector.client.model.workflowitem;

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
    "state",
    "stateDetail",
    "stateStartTime",
    "stateUserId",
    "stateUsername",
    "totalHoldTime"
})
public class StateInfo {

    @JsonProperty("state")
    private String state;
    @JsonProperty("stateDetail")
    private String stateDetail;
    @JsonProperty("stateStartTime")
    private String stateStartTime;
    @JsonProperty("stateUserId")
    private String stateUserId;
    @JsonProperty("stateUsername")
    private String stateUsername;
    @JsonProperty("totalHoldTime")
    private String totalHoldTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The stateDetail
     */
    @JsonProperty("stateDetail")
    public String getStateDetail() {
        return stateDetail;
    }

    /**
     * 
     * @param stateDetail
     *     The stateDetail
     */
    @JsonProperty("stateDetail")
    public void setStateDetail(String stateDetail) {
        this.stateDetail = stateDetail;
    }

    /**
     * 
     * @return
     *     The stateStartTime
     */
    @JsonProperty("stateStartTime")
    public String getStateStartTime() {
        return stateStartTime;
    }

    /**
     * 
     * @param stateStartTime
     *     The stateStartTime
     */
    @JsonProperty("stateStartTime")
    public void setStateStartTime(String stateStartTime) {
        this.stateStartTime = stateStartTime;
    }

    /**
     * 
     * @return
     *     The stateUserId
     */
    @JsonProperty("stateUserId")
    public String getStateUserId() {
        return stateUserId;
    }

    /**
     * 
     * @param stateUserId
     *     The stateUserId
     */
    @JsonProperty("stateUserId")
    public void setStateUserId(String stateUserId) {
        this.stateUserId = stateUserId;
    }

    /**
     * 
     * @return
     *     The stateUsername
     */
    @JsonProperty("stateUsername")
    public String getStateUsername() {
        return stateUsername;
    }

    /**
     * 
     * @param stateUsername
     *     The stateUsername
     */
    @JsonProperty("stateUsername")
    public void setStateUsername(String stateUsername) {
        this.stateUsername = stateUsername;
    }

    /**
     * 
     * @return
     *     The totalHoldTime
     */
    @JsonProperty("totalHoldTime")
    public String getTotalHoldTime() {
        return totalHoldTime;
    }

    /**
     * 
     * @param totalHoldTime
     *     The totalHoldTime
     */
    @JsonProperty("totalHoldTime")
    public void setTotalHoldTime(String totalHoldTime) {
        this.totalHoldTime = totalHoldTime;
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
        return new HashCodeBuilder().append(state).append(stateDetail).append(stateStartTime).append(stateUserId).append(stateUsername).append(totalHoldTime).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StateInfo) == false) {
            return false;
        }
        StateInfo rhs = ((StateInfo) other);
        return new EqualsBuilder().append(state, rhs.state).append(stateDetail, rhs.stateDetail).append(stateStartTime, rhs.stateStartTime).append(stateUserId, rhs.stateUserId).append(stateUsername, rhs.stateUsername).append(totalHoldTime, rhs.totalHoldTime).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
