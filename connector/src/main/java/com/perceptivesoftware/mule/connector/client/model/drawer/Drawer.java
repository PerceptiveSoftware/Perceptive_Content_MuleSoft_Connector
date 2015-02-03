
package com.perceptivesoftware.mule.connector.client.model.drawer;

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
    "drawers"
})
public class Drawer {

    @JsonProperty("drawers")
    private List<DrawerInfo> drawers = new ArrayList<DrawerInfo>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The drawers
     */
    @JsonProperty("drawers")
    public List<DrawerInfo> getDrawers() {
        return drawers;
    }

    /**
     * 
     * @param drawers
     *     The drawers
     */
    @JsonProperty("drawers")
    public void setDrawers(List<DrawerInfo> drawers) {
        this.drawers = drawers;
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
        return new HashCodeBuilder().append(drawers).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Drawer) == false) {
            return false;
        }
        Drawer rhs = ((Drawer) other);
        return new EqualsBuilder().append(drawers, rhs.drawers).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
