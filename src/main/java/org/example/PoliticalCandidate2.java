package org.example;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PoliticalCandidate2 extends PoliticalCandidate {

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("firstName", this.getFirstName())
        .append("lastName", this.getLastName())
        .toString();
    } 
}
