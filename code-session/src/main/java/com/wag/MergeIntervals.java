package com.wag;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    /**
     * Máš zoznam intervalov [start, end] (vrátane hraníc), kde platí start <= end.
     * <p>
     * Zlúči všetky prekrývajúce sa alebo dotýkajúce sa intervaly (t. j. [1,3] a [3,5] sa majú zlúčiť na [1,5]).
     * <p>
     * Vráti výsledok ako zoznam intervalov zoradených podľa start.
     * <p>
     * Vstup môže byť v ľubovoľnom poradí.
     * <p>
     * Ak je vstup null alebo prázdny → vráť prázdny zoznam.
     *
     * @param intervals
     * @return
     */
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals == null || intervals.size() < 2) {
            throw new IllegalArgumentException();
        }

        // sort
        List<int[]> sorted = intervals.stream()
                .peek(m -> {
                    if (m.length != 2) {
                        throw new IllegalArgumentException();
                    }
                })
                .sorted((a, b) -> a[0] - b[0])
                .toList();
        print("sorted", sorted);

        List<int[]> out = new ArrayList<>();
        int[] curr = sorted.get(0);

        for (int i = 1; i < sorted.size(); i++) {
            int[] next = sorted.get(i);
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                out.add(curr);
                curr = next;
            }
        }

        out.add(curr);

        return out;
    }

    private static void print(String message, List<int[]> intervals) {
        System.out.println("*** " + message + " ***");
        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }


}
