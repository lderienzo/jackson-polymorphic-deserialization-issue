package com.engageft.jackson.deserialization.issue.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmptyDefaultImplementation implements AnInterface {

    public EmptyDefaultImplementation(){}
}
