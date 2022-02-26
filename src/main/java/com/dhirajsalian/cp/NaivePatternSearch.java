package com.dhirajsalian.cp;

/*
Given a text and pattern, return the indexes at which the pattern is present in text.

Examples:

Input 1: txt = "ABABABCD", pat = "ABAB"
Output 1: 0 2

Input 2: txt = "ABCABCD", pat = "ABCD"
Output 2: 3

Input 3: txt = "AAAAA", pat = "AAA"
Output 3: 0 1 2

Sources: geeksforgeeks.org
 */
public class NaivePatternSearch {

    static void printPatternIndex(String txt, String pat) {
        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            boolean patternFound = true;
            for (int j = 0; j < pat.length(); j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    patternFound = false;
                    break;
                }
            }
            if (patternFound) System.out.printf("%s ", i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] inputTxts = {"ABABABCD", "ABCABCD", "AAAAA"};
        String[] inputPats = {"ABAB", "ABCD", "AAA"};
        for (int i = 0; i < inputTxts.length; i++) {
            printPatternIndex(inputTxts[i], inputPats[i]);
        }
    }
}
