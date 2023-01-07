package org.trafficlights.domain;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.trafficlights.domain.LightState.*;

public class LightStateTest {

    @Test
    public void testStateTest(){
        Assertions.assertEquals(LightState.RED_YELLOW, RED.next());
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void testStateTestWithParameters(LightState preLightState, LightState nextLightState){
        Assertions.assertEquals(nextLightState, preLightState.next());
    }

    static Stream<Arguments> getArgs(){
        return Stream.of( Arguments.of(RED, RED_YELLOW),
                Arguments.of(RED_YELLOW, GREEN),
                Arguments.of(GREEN, YELLOW),
                Arguments.of(YELLOW, RED),
                Arguments.of(UNKNOWN, UNKNOWN)
        );
    }

}
