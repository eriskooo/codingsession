package com.wag;

public class MaxVowelsInWindow {


    /**
     * Napíš metódu, ktorá pre zadaný String s a veľkosť okna w vráti maximálny počet samohlások v ľubovoľnom súvislom podreťazci dĺžky w.
     *
     * @param s
     * @param w
     * @return
     */
    public static int maxVowelsInWindow(String s, int w) {
        System.out.println("s = " + s);
        System.out.println("w = " + w);
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (w <= 0 || w > s.length()) {
            throw new IllegalArgumentException();
        }

        // initial count
        int sum = 0;
        for (int i = 0; i < w; i++) {
            if (isSamohlaska(s.charAt(i))) {
                ++sum;
            }
        }

        int best = sum;
        for (int i = w; i < s.length(); i++) {
            int leftIndex = i - w;
            int rightIndex = i;
            if (isSamohlaska(s.charAt(leftIndex))) {
                --sum;
            }
            if (isSamohlaska(s.charAt(rightIndex))) {
                ++sum;
            }
            if (sum > best) {
                best = sum;
            }
        }

        return best;
    }

    private static boolean isSamohlaska(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
