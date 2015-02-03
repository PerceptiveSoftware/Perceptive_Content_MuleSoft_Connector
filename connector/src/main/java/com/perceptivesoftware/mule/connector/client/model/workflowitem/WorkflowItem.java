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
    "id",
    "type",
    "objectId",
    "priority",
    "isChildItem",
    "parentItemId",
    "childGenerationNum",
    "creationUserId",
    "creationUserName",
    "creationTime",
    "completedTime",
    "workflowQueueSequenceNum",
    "workflowQueueId",
    "workflowQueueName",
    "workflowQueueStartUserId",
    "workflowQueueStartUsername",
    "workflowQueueStartTime",
    "stateInfo",
    "destinationWorkflowQueueId"
})
public class WorkflowItem {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("objectId")
    private String objectId;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("isChildItem")
    private Boolean isChildItem;
    @JsonProperty("parentItemId")
    private Object parentItemId;
    @JsonProperty("childGenerationNum")
    private String childGenerationNum;
    @JsonProperty("creationUserId")
    private String creationUserId;
    @JsonProperty("creationUserName")
    private String creationUserName;
    @JsonProperty("creationTime")
    private String creationTime;
    @JsonProperty("completedTime")
    private Object completedTime;
    @JsonProperty("workflowQueueSequenceNum")
    private String workflowQueueSequenceNum;
    @JsonProperty("workflowQueueId")
    private String workflowQueueId;
    @JsonProperty("workflowQueueName")
    private String workflowQueueName;
    @JsonProperty("workflowQueueStartUserId")
    private String workflowQueueStartUserId;
    @JsonProperty("workflowQueueStartUsername")
    private String workflowQueueStartUsername;
    @JsonProperty("workflowQueueStartTime")
    private String workflowQueueStartTime;
    @JsonProperty("stateInfo")
    private StateInfo stateInfo;
    @JsonProperty("destinationWorkflowQueueId")
    private Object destinationWorkflowQueueId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The objectId
     */
    @JsonProperty("objectId")
    public String getObjectId() {
        return objectId;
    }

    /**
     * 
     * @param objectId
     *     The objectId
     */
    @JsonProperty("objectId")
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    /**
     * 
     * @return
     *     The priority
     */
    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    /**
     * 
     * @param priority
     *     The priority
     */
    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 
     * @return
     *     The isChildItem
     */
    @JsonProperty("isChildItem")
    public Boolean getIsChildItem() {
        return isChildItem;
    }

    /**
     * 
     * @param isChildItem
     *     The isChildItem
     */
    @JsonProperty("isChildItem")
    public void setIsChildItem(Boolean isChildItem) {
        this.isChildItem = isChildItem;
    }

    /**
     * 
     * @return
     *     The parentItemId
     */
    @JsonProperty("parentItemId")
    public Object getParentItemId() {
        return parentItemId;
    }

    /**
     * 
     * @param parentItemId
     *     The parentItemId
     */
    @JsonProperty("parentItemId")
    public void setParentItemId(Object parentItemId) {
        this.parentItemId = parentItemId;
    }

    /**
     * 
     * @return
     *     The childGenerationNum
     */
    @JsonProperty("childGenerationNum")
    public String getChildGenerationNum() {
        return childGenerationNum;
    }

    /**
     * 
     * @param childGenerationNum
     *     The childGenerationNum
     */
    @JsonProperty("childGenerationNum")
    public void setChildGenerationNum(String childGenerationNum) {
        this.childGenerationNum = childGenerationNum;
    }

    /**
     * 
     * @return
     *     The creationUserId
     */
    @JsonProperty("creationUserId")
    public String getCreationUserId() {
        return creationUserId;
    }

    /**
     * 
     * @param creationUserId
     *     The creationUserId
     */
    @JsonProperty("creationUserId")
    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }

    /**
     * 
     * @return
     *     The creationUserName
     */
    @JsonProperty("creationUserName")
    public String getCreationUserName() {
        return creationUserName;
    }

    /**
     * 
     * @param creationUserName
     *     The creationUserName
     */
    @JsonProperty("creationUserName")
    public void setCreationUserName(String creationUserName) {
        this.creationUserName = creationUserName;
    }

    /**
     * 
     * @return
     *     The creationTime
     */
    @JsonProperty("creationTime")
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * 
     * @param creationTime
     *     The creationTime
     */
    @JsonProperty("creationTime")
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * 
     * @return
     *     The completedTime
     */
    @JsonProperty("completedTime")
    public Object getCompletedTime() {
        return completedTime;
    }

    /**
     * 
     * @param completedTime
     *     The completedTime
     */
    @JsonProperty("completedTime")
    public void setCompletedTime(Object completedTime) {
        this.completedTime = completedTime;
    }

    /**
     * 
     * @return
     *     The workflowQueueSequenceNum
     */
    @JsonProperty("workflowQueueSequenceNum")
    public String getWorkflowQueueSequenceNum() {
        return workflowQueueSequenceNum;
    }

    /**
     * 
     * @param workflowQueueSequenceNum
     *     The workflowQueueSequenceNum
     */
    @JsonProperty("workflowQueueSequenceNum")
    public void setWorkflowQueueSequenceNum(String workflowQueueSequenceNum) {
        this.workflowQueueSequenceNum = workflowQueueSequenceNum;
    }

    /**
     * 
     * @return
     *     The workflowQueueId
     */
    @JsonProperty("workflowQueueId")
    public String getWorkflowQueueId() {
        return workflowQueueId;
    }

    /**
     * 
     * @param workflowQueueId
     *     The workflowQueueId
     */
    @JsonProperty("workflowQueueId")
    public void setWorkflowQueueId(String workflowQueueId) {
        this.workflowQueueId = workflowQueueId;
    }

    /**
     * 
     * @return
     *     The workflowQueueName
     */
    @JsonProperty("workflowQueueName")
    public String getWorkflowQueueName() {
        return workflowQueueName;
    }

    /**
     * 
     * @param workflowQueueName
     *     The workflowQueueName
     */
    @JsonProperty("workflowQueueName")
    public void setWorkflowQueueName(String workflowQueueName) {
        this.workflowQueueName = workflowQueueName;
    }

    /**
     * 
     * @return
     *     The workflowQueueStartUserId
     */
    @JsonProperty("workflowQueueStartUserId")
    public String getWorkflowQueueStartUserId() {
        return workflowQueueStartUserId;
    }

    /**
     * 
     * @param workflowQueueStartUserId
     *     The workflowQueueStartUserId
     */
    @JsonProperty("workflowQueueStartUserId")
    public void setWorkflowQueueStartUserId(String workflowQueueStartUserId) {
        this.workflowQueueStartUserId = workflowQueueStartUserId;
    }

    /**
     * 
     * @return
     *     The workflowQueueStartUsername
     */
    @JsonProperty("workflowQueueStartUsername")
    public String getWorkflowQueueStartUsername() {
        return workflowQueueStartUsername;
    }

    /**
     * 
     * @param workflowQueueStartUsername
     *     The workflowQueueStartUsername
     */
    @JsonProperty("workflowQueueStartUsername")
    public void setWorkflowQueueStartUsername(String workflowQueueStartUsername) {
        this.workflowQueueStartUsername = workflowQueueStartUsername;
    }

    /**
     * 
     * @return
     *     The workflowQueueStartTime
     */
    @JsonProperty("workflowQueueStartTime")
    public String getWorkflowQueueStartTime() {
        return workflowQueueStartTime;
    }

    /**
     * 
     * @param workflowQueueStartTime
     *     The workflowQueueStartTime
     */
    @JsonProperty("workflowQueueStartTime")
    public void setWorkflowQueueStartTime(String workflowQueueStartTime) {
        this.workflowQueueStartTime = workflowQueueStartTime;
    }

    /**
     * 
     * @return
     *     The stateInfo
     */
    @JsonProperty("stateInfo")
    public StateInfo getStateInfo() {
        return stateInfo;
    }

    /**
     * 
     * @param stateInfo
     *     The stateInfo
     */
    @JsonProperty("stateInfo")
    public void setStateInfo(StateInfo stateInfo) {
        this.stateInfo = stateInfo;
    }

    /**
     * 
     * @return
     *     The destinationWorkflowQueueId
     */
    @JsonProperty("destinationWorkflowQueueId")
    public Object getDestinationWorkflowQueueId() {
        return destinationWorkflowQueueId;
    }

    /**
     * 
     * @param destinationWorkflowQueueId
     *     The destinationWorkflowQueueId
     */
    @JsonProperty("destinationWorkflowQueueId")
    public void setDestinationWorkflowQueueId(Object destinationWorkflowQueueId) {
        this.destinationWorkflowQueueId = destinationWorkflowQueueId;
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
        return new HashCodeBuilder().append(id).append(type).append(objectId).append(priority).append(isChildItem).append(parentItemId).append(childGenerationNum).append(creationUserId).append(creationUserName).append(creationTime).append(completedTime).append(workflowQueueSequenceNum).append(workflowQueueId).append(workflowQueueName).append(workflowQueueStartUserId).append(workflowQueueStartUsername).append(workflowQueueStartTime).append(stateInfo).append(destinationWorkflowQueueId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkflowItem) == false) {
            return false;
        }
        WorkflowItem rhs = ((WorkflowItem) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(objectId, rhs.objectId).append(priority, rhs.priority).append(isChildItem, rhs.isChildItem).append(parentItemId, rhs.parentItemId).append(childGenerationNum, rhs.childGenerationNum).append(creationUserId, rhs.creationUserId).append(creationUserName, rhs.creationUserName).append(creationTime, rhs.creationTime).append(completedTime, rhs.completedTime).append(workflowQueueSequenceNum, rhs.workflowQueueSequenceNum).append(workflowQueueId, rhs.workflowQueueId).append(workflowQueueName, rhs.workflowQueueName).append(workflowQueueStartUserId, rhs.workflowQueueStartUserId).append(workflowQueueStartUsername, rhs.workflowQueueStartUsername).append(workflowQueueStartTime, rhs.workflowQueueStartTime).append(stateInfo, rhs.stateInfo).append(destinationWorkflowQueueId, rhs.destinationWorkflowQueueId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
