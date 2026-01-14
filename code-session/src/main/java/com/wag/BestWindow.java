package com.wag;

public class BestWindow {

    /**
     * Máš pole denných zmien int[] a (môžu byť aj záporné). Deň je dobrý, ak a[i] >= t (prahová hodnota).
     * Napíš metódu ktorá nájde súvislé okno dĺžky w s maximálnym počtom dobrých dní.
     *
     * @param a pole denných zmien
     * @param w nájde súvislé okno dĺžky
     * @param t prahová hodnota
     * @return
     */
    public static Result bestWindowAtLeastT(int[] a, int w, int t) {
        return null;
    }

    public record Result(int startIndex, int goodCount) {
    }

}
