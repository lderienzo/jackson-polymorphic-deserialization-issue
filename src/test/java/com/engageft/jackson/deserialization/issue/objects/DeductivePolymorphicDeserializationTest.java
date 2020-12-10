package com.engageft.jackson.deserialization.issue.objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeductivePolymorphicDeserializationTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String COMPOSITE_OBJECT_WITH_AN_IMPLEMENTATION =
            "{\n" +
                    "   \"compositeClassIntMember\":11235,\n" +
                    "   \"compositeClassStringMember\":\"compositeClassString\",\n" +
                    "   \"polyMorphicMember\":{\n" +
                    "      \"someIntMember\":1126,\n" +
                    "      \"someStringMember\":\"someString\"\n" +
                    "   }\n" +
                    "}";
    private static final String COMPOSITE_OBJECT_WITH_ANOTHER_IMPLEMENTATION =
            "{\n" +
                    "   \"compositeClassIntMember\":11235,\n" +
                    "   \"compositeClassStringMember\":\"compositeClassString\",\n" +
                    "   \"polyMorphicMember\":{\n" +
                    "      \"someDoubleMember\":3.14159\n" +
                    "   }\n" +
                    "}";
    private static final String COMPOSITE_OBJECT_WITH_EMPTY_IMPLEMENTATION =
            "{\n" +
                    "   \"compositeClassIntMember\":11235,\n" +
                    "   \"compositeClassStringMember\":\"compositeClassString\",\n" +
                    "   \"polyMorphicMember\":{\n" +
                    "      \n" +
                    "   }\n" +
                    "}";
    private static CompositeClass compositeObject;


    // This will work beautifully as expected
    @Test
    void testPolymorphicDeserializationOfCompositeObjectWithAnImplementation() throws JsonProcessingException {
        compositeObject = MAPPER.readValue(COMPOSITE_OBJECT_WITH_AN_IMPLEMENTATION, CompositeClass.class);
        assertThat(compositeObject.getPolyMorphicMember()).isInstanceOf(AnImplementation.class);
    }

    // This will also work beautifully as expected
    @Test
    void testPolymorphicDeserializationOfCompositeObjectWithAnotherImplementation() throws JsonProcessingException {
        compositeObject = MAPPER.readValue(COMPOSITE_OBJECT_WITH_ANOTHER_IMPLEMENTATION, CompositeClass.class);
        assertThat(compositeObject.getPolyMorphicMember()).isInstanceOf(AnotherImplementation.class);
    }

    /*
        This will fail with:
        com.fasterxml.jackson.databind.exc.InvalidTypeIdException: Cannot deduce unique subtype of
        `com.lderienzo.jackson.deserialization.issue.objects.SomeInterface` (2 candidates match)
     */
    @Test
    void testPolymorphicDeserializationOfCompositeObjectWithEmptyImplementation() throws JsonProcessingException {
        compositeObject = MAPPER.readValue(COMPOSITE_OBJECT_WITH_EMPTY_IMPLEMENTATION, CompositeClass.class);
        assertThat(compositeObject.getPolyMorphicMember()).isInstanceOf(AnEmptyImplementation.class);
    }
}
