
package com.perceptivesoftware.mule.connector.client.model.updatedocument;

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
    "drawer",
    "field1",
    "field2",
    "field3",
    "field4",
    "field5",
    "documentType"
})
public class UpdateKeys {

    @JsonProperty("drawer")
    public String drawer;
    @JsonProperty("field1")
    public String field1;
    @JsonProperty("field2")
    public String field2;
    @JsonProperty("field3")
    public String field3;
    @JsonProperty("field4")
    public String field4;
    @JsonProperty("field5")
    public String field5;
    @JsonProperty("documentType")
	public String documentType;

    /**
     * 
     * @return
     *     The drawer
     */
    @JsonProperty("drawer")
    public String getDrawer() {
        return drawer;
    }

    /**
     * 
     * @param drawer
     *     The drawer
     */
    @JsonProperty("drawer")
    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    /**
     * 
     * @return
     *     The field1
     */
    @JsonProperty("field1")
    public String getField1() {
        return field1;
    }

    /**
     * 
     * @param field1
     *     The field1
     */
    @JsonProperty("field1")
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     * 
     * @return
     *     The field2
     */
    @JsonProperty("field2")
    public String getField2() {
        return field2;
    }

    /**
     * 
     * @param field2
     *     The field2
     */
    @JsonProperty("field2")
    public void setField2(String field2) {
        this.field2 = field2;
    }

    /**
     * 
     * @return
     *     The field3
     */
    @JsonProperty("field3")
    public String getField3() {
        return field3;
    }

    /**
     * 
     * @param field3
     *     The field3
     */
    @JsonProperty("field3")
    public void setField3(String field3) {
        this.field3 = field3;
    }

    /**
     * 
     * @return
     *     The field4
     */
    @JsonProperty("field4")
    public String getField4() {
        return field4;
    }

    /**
     * 
     * @param field4
     *     The field4
     */
    @JsonProperty("field4")
    public void setField4(String field4) {
        this.field4 = field4;
    }

    /**
     * 
     * @return
     *     The field5
     */
    @JsonProperty("field5")
    public String getField5() {
        return field5;
    }

    /**
     * 
     * @param field5
     *     The field5
     */
    @JsonProperty("field5")
    public void setField5(String field5) {
        this.field5 = field5;
    }

    /**
     * 
     * @return
     *     The documentType
     */
    @JsonProperty("documentType")
    public String getDocumentType() {
        return documentType;
    }

    /**
     * 
     * @param documentType
     *     The documentType
     */
    @JsonProperty("documentType")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(drawer).append(field1).append(field2).append(field3).append(field4).append(field5).append(documentType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateKeys) == false) {
            return false;
        }
        UpdateKeys rhs = ((UpdateKeys) other);
        return new EqualsBuilder().append(drawer, rhs.drawer).append(field1, rhs.field1).append(field2, rhs.field2).append(field3, rhs.field3).append(field4, rhs.field4).append(field5, rhs.field5).append(documentType, rhs.documentType).isEquals();
    }

}
