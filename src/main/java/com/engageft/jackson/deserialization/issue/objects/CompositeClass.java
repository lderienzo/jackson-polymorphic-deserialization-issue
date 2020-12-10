package com.engageft.jackson.deserialization.issue.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompositeClass {

    private int compositeClassIntMember;

    private String compositeClassStringMember;

    private AnInterface polyMorphicMember;


    public int getCompositeClassIntMember() {
        return compositeClassIntMember;
    }

    public void setCompositeClassIntMember(int compositeClassIntMember) {
        this.compositeClassIntMember = compositeClassIntMember;
    }

    public String getCompositeClassStringMember() {
        return compositeClassStringMember;
    }

    public void setCompositeClassStringMember(String compositeClassStringMember) {
        this.compositeClassStringMember = compositeClassStringMember;
    }

    public AnInterface getPolyMorphicMember() {
        return polyMorphicMember;
    }

    public void setPolyMorphicMember(AnInterface polyMorphicMember) {
        this.polyMorphicMember = polyMorphicMember;
    }
}
