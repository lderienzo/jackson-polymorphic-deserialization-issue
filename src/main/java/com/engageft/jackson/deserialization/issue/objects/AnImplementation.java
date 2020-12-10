package com.engageft.jackson.deserialization.issue.objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnImplementation implements AnInterface {

    private int someIntMember;

    private String someStringMember;


    public int getSomeIntMember() {
        return someIntMember;
    }

    public void setSomeIntMember(int someIntMember) {
        this.someIntMember = someIntMember;
    }

    public String getSomeStringMember() {
        return someStringMember;
    }

    public void setSomeStringMember(String someStringMember) {
        this.someStringMember = someStringMember;
    }
}
