package com.wag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MostFrequentTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> validCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(
                        List.of(1, 2, 2, 3),
                        Optional.of(2)
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        List.of(4, 4, 5, 5),
                        Optional.of(4) // tie -> smaller wins
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        List.of(7),
                        Optional.of(7)
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        List.of(),
                        Optional.empty()
                )
        );
    }

    @ParameterizedTest(name = "Input: {0} -> Expected: {1}")
    @MethodSource("validCases")
    void shouldReturnMostFrequent(List<Integer> input, Optional<Integer> expected) {
        Optional<Integer> result = MostFrequent.findMostFrequent(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should handle negative numbers")
    void shouldHandleNegativeNumbers() {
        Optional<Integer> result =
                MostFrequent.findMostFrequent(List.of(-1, -1, -2, -2, -2));

        assertEquals(Optional.of(-2), result);
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void shouldThrowWhenInputIsNull() {
        assertThrows(NullPointerException.class,
                () -> MostFrequent.findMostFrequent(null));
    }
}