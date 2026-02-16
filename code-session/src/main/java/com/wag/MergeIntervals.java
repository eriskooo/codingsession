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
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }


        return null;
    }


}
