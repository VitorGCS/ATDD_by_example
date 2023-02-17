package org.trafficlights.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.trafficlights.domain.LightState.*;

public class LightStateEditorTest {

    private LightStateEditor editor;

    @BeforeEach
    void setUp() {
        this.editor = new LightStateEditor();
    }

    @Test
    void setRed() {
        this.editor.setAsText("red");
        assertEquals(LightState.RED, editor.getValue());
    }

    @Test
    void getAsText() {
        editor.setValue(RED);
        assertEquals("red", editor.getAsText());
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void testStateTestWithParameters(String stringState, LightState lightState){
        editor.setAsText(stringState);
        Assertions.assertEquals(lightState, editor.getValue());
    }

    static Stream<Arguments> getArgs(){
        return Stream.of( Arguments.of( "red", RED),
                Arguments.of("red, yellow", RED_YELLOW),
                Arguments.of("green", GREEN),
                Arguments.of("yellow", YELLOW),
                Arguments.of("yellow blink", UNKNOWN),
                Arguments.of("invalid state", UNKNOWN)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void testValueForWithParameters(String stateName, LightState lightState){
        Assertions.assertEquals(lightState, lightState.valueFor(stateName));
    }
}
