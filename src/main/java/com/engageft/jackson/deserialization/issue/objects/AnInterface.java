package com.engageft.jackson.deserialization.issue.objects;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({
        @Type(AnImplementation.class),
        @Type(AnotherImplementation.class)
})
public interface AnInterface {
}
