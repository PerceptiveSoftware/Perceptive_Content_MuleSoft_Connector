
package com.perceptivesoftware.mule.connector.client.model.viewresults;

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
    "vslText"
})
public class VslRequest {

    @JsonProperty("vslText")
    private String vslText;

    /**
     * 
     * @return
     *     The vslText
     */
    @JsonProperty("vslText")
    public String getVslText() {
        return vslText;
    }

    /**
     * 
     * @param vslText
     *     The vslText
     */
    @JsonProperty("vslText")
    public void setVslText(String vslText) {
        this.vslText = vslText;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(vslText).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VslRequest) == false) {
            return false;
        }
        VslRequest rhs = ((VslRequest) other);
        return new EqualsBuilder().append(vslText, rhs.vslText).isEquals();
    }

}
