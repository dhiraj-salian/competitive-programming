package com.dhirajsalian.cp;

/*
Given a text and a pattern, the task is to find if there is anagram of pattern present in text.

Examples:

Input 1: text = "geeksforgeeks", pat = "frog"
Output 1: yes

Input 1: text = "geeksforgeeks", pat = "rseek"
Output 1: no

Source: geeksforgeeks.org
 */
public class PatternSearch {

    static boolean isAnagramPatternPresent(String text, String pat) {
        char[] ct = new char[256], cp = new char[256];
        for (int i = 0; i < pat.length(); i++) {
            ct[text.charAt(i)]++;
            cp[pat.charAt(i)]++;
        }
        for (int i = pat.length(); i < text.length(); i++) {
            if (areSame(ct, cp, 256))
                return true;
            ct[text.charAt(i)]++;
            ct[text.charAt(i - pat.length())]--;
        }
        return false;
    }

    static boolean areSame(char[] ct, char[] cp, int n) {
        for (int i = 0; i < n; i++) {
            if (ct[i] != cp[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputTexts = {"geeksforgeeks", "geeksforgeeks"};
        String[] inputPatterns = {"frog", "rseek"};
        for (int i = 0; i < inputPatterns.length; i++) {
            System.out.println(isAnagramPatternPresent(inputTexts[i], inputPatterns[i]) ? "yes" : "no");
        }
    }
}
