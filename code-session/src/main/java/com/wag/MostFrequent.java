package com.wag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MostFrequent {

    /**
     * Vráti najčastejšie sa vyskytujúce číslo v zozname.
     * <p>
     * Ak je zoznam prázdny → vráť Optional.empty()
     * <p>
     * Ak majú dve čísla rovnakú frekvenciu → vráť menšie z nich.
     *
     * @param numbers
     * @return
     */
    public static Optional<Integer> findMostFrequent(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Optional.empty();
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        Map.Entry<Integer, Integer> max = null;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (max == null || entry.getValue() > max.getValue()) {
                max = entry;
            } else if (entry.getValue() == max.getValue()) {
                if (entry.getKey() < max.getKey()) {
                    max = entry;
                }
            }
        }

        return Optional.ofNullable(max.getKey());
    }

}
