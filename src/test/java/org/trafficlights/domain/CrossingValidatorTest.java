package org.trafficlights.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.trafficlights.domain.LightState.*;

public class CrossingValidatorTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(RED, RED, true),
                Arguments.of(GREEN, RED, true),
                Arguments.of(YELLOW, RED, true),
                Arguments.of(RED_YELLOW, RED, true),
                Arguments.of(UNKNOWN, RED, false),
                Arguments.of(GREEN, GREEN, false),
                Arguments.of(YELLOW, GREEN, false),
                Arguments.of(RED_YELLOW, GREEN, false),
                Arguments.of(RED, GREEN, true),
                Arguments.of(UNKNOWN, GREEN, false),
                Arguments.of(GREEN, RED_YELLOW, false),
                Arguments.of(YELLOW, RED_YELLOW, false),
                Arguments.of(RED, RED_YELLOW, true),
                Arguments.of(RED_YELLOW, RED_YELLOW, false),
                Arguments.of(UNKNOWN, RED_YELLOW, false),
                Arguments.of(GREEN, YELLOW, false),
                Arguments.of(YELLOW, YELLOW, false),
                Arguments.of(RED, YELLOW, true),
                Arguments.of(RED_YELLOW, YELLOW, false),
                Arguments.of(UNKNOWN, YELLOW, false),
                Arguments.of(GREEN, UNKNOWN, false),
                Arguments.of(YELLOW, UNKNOWN, false),
                Arguments.of(RED, UNKNOWN, false),
                Arguments.of(RED_YELLOW, UNKNOWN, false),
                Arguments.of(UNKNOWN, UNKNOWN, false)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void isValidConfiguration(LightState firstState, LightState secondState, boolean valid) {
        Assertions.assertEquals(valid, new CrossingValidator().isValidConfiguration(firstState, secondState));
    }

}
