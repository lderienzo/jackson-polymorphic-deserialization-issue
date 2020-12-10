package com.engageft.jackson.deserialization.issue.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnotherImplementation implements AnInterface {

    private double someDoubleMember;


    public double getSomeDoubleMember() {
        return someDoubleMember;
    }

    public void setSomeDoubleMember(double someDoubleMember) {
        this.someDoubleMember = someDoubleMember;
    }
}
