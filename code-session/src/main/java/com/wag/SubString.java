package com.wag;

public class SubString {

    /**
     * Napíš metódu, ktorá pre zadaný String vráti dĺžku najdlhšieho súvislého podreťazca (substringu), v ktorom sa žiadny znak neopakuje.
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestUniqueSubstring(String s) {
        int start = 0;
        String longest = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            String temp = s.substring(start, i + 1);
            if (hasAllDifferent(temp)) {
                if (temp.length() >= longest.length()) {
                    longest = temp;
                }
            } else {
                start++;
            }
        }
        System.out.println("Longest unique substring for intput = " + s + " : " + longest);
        return longest.length();
    }

    static boolean hasAllDifferent(String temp) {
        for (char c : temp.toCharArray()) {
            if (temp.indexOf(c) != temp.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }
}
