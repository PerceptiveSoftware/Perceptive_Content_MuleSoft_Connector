
package com.perceptivesoftware.mule.connector.client.model.workflowitem;

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
    "objectId",
    "itemType",
    "workflowQueueId",
    "itemPriority"
})
public class AddWorkflowItem {

    @JsonProperty("objectId")
    private String objectId;
    @JsonProperty("itemType")
    private String itemType;
    @JsonProperty("workflowQueueId")
    private String workflowQueueId;
    @JsonProperty("itemPriority")
    private String itemPriority;

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
     *     The itemType
     */
    @JsonProperty("itemType")
    public String getItemType() {
        return itemType;
    }

    /**
     * 
     * @param itemType
     *     The itemType
     */
    @JsonProperty("itemType")
    public void setItemType(String itemType) {
        this.itemType = itemType;
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
     *     The itemPriority
     */
    @JsonProperty("itemPriority")
    public String getItemPriority() {
        return itemPriority;
    }

    /**
     * 
     * @param itemPriority
     *     The itemPriority
     */
    @JsonProperty("itemPriority")
    public void setItemPriority(String itemPriority) {
        this.itemPriority = itemPriority;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(objectId).append(itemType).append(workflowQueueId).append(itemPriority).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddWorkflowItem) == false) {
            return false;
        }
        AddWorkflowItem rhs = ((AddWorkflowItem) other);
        return new EqualsBuilder().append(objectId, rhs.objectId).append(itemType, rhs.itemType).append(workflowQueueId, rhs.workflowQueueId).append(itemPriority, rhs.itemPriority).isEquals();
    }

}
