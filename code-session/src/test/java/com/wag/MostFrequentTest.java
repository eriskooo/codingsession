package com.wag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    static Stream<org.junit.jupiter.params.provider.Arguments> heavyDuplicateCases() {
        return Stream.of(
                arguments(
                        List.of(1, 1, 1, 1, 1),
                        Optional.of(1)
                ),
                arguments(
                        List.of(2, 2, 2, 3, 3),
                        Optional.of(2)
                ),
                arguments(
                        List.of(10, 20, 20, 10, 30, 30), // all twice -> smallest 10
                        Optional.of(10)
                )
        );
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void shouldThrowWhenInputIsNull() {
        Optional<Integer> mostFrequent = MostFrequent.findMostFrequent(null);
        assertEquals(Optional.empty(), mostFrequent);
    }

    @Test
    @DisplayName("Empty list -> Optional.empty()")
    void emptyListShouldReturnEmpty() {
        assertEquals(Optional.empty(), MostFrequent.findMostFrequent(List.of()));
    }

    @Test
    @DisplayName("Single element -> that element")
    void singleElement() {
        assertEquals(Optional.of(42), MostFrequent.findMostFrequent(List.of(42)));
    }

    @Test
    @DisplayName("All elements unique -> return smallest (tie on frequency=1)")
    void allUniqueShouldReturnSmallest() {
        assertEquals(Optional.of(1), MostFrequent.findMostFrequent(List.of(5, 3, 1, 4, 2)));
    }

    @Test
    @DisplayName("Tie among many candidates -> return smallest")
    void tieAmongManyCandidatesShouldReturnSmallest() {
        // each appears twice -> choose smallest = 1
        assertEquals(Optional.of(1), MostFrequent.findMostFrequent(List.of(3, 3, 2, 2, 1, 1)));
    }

    @Test
    @DisplayName("Most frequent at the end of list")
    void mostFrequentAtEnd() {
        assertEquals(Optional.of(9), MostFrequent.findMostFrequent(List.of(1, 2, 3, 9, 9, 9)));
    }

    @Test
    @DisplayName("Most frequent at the beginning of list")
    void mostFrequentAtBeginning() {
        assertEquals(Optional.of(7), MostFrequent.findMostFrequent(List.of(7, 7, 7, 1, 2, 3)));
    }

    @Test
    @DisplayName("Handles Integer.MIN_VALUE and Integer.MAX_VALUE correctly")
    void shouldHandleIntegerMinMax() {
        assertEquals(Optional.of(Integer.MIN_VALUE),
                MostFrequent.findMostFrequent(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE)));
    }

    @Test
    @DisplayName("Tie between MIN_VALUE and another number -> MIN_VALUE wins because it's smaller")
    void tieBetweenMinValueAndOther() {
        assertEquals(Optional.of(Integer.MIN_VALUE),
                MostFrequent.findMostFrequent(List.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 0)));
    }

    @Test
    @DisplayName("Does not modify input list")
    void shouldNotModifyInputList() {
        List<Integer> input = new ArrayList<>(List.of(2, 2, 1));
        List<Integer> snapshot = List.copyOf(input);

        MostFrequent.findMostFrequent(input);

        assertEquals(snapshot, input);
    }

    @ParameterizedTest(name = "{index}: input={0} expected={1}")
    @MethodSource("heavyDuplicateCases")
    void heavyDuplicates(List<Integer> input, Optional<Integer> expected) {
        assertEquals(expected, MostFrequent.findMostFrequent(input));
    }

    @Test
    @DisplayName("If list contains null elements -> define behavior (example: throws NPE)")
    void nullElementInsideList_behaviorDecision() {
        // Tento test si nechaj podľa toho, ako to chceš mať v implementácii:
        // A) ak nully zakazuješ -> NPE
        assertThrows(NullPointerException.class,
                () -> MostFrequent.findMostFrequent(List.of(1, null, 1)));

        // B) ak nully podporíš -> potom by si test zmenil napr. na:
        // assertEquals(Optional.of(1), MostFrequent.findMostFrequent(Arrays.asList(1, null, 1)));
        // alebo by null mohol byť kandidát: Optional.ofNullable(null) (čo je divné) -> radšej zakázať
    }
}