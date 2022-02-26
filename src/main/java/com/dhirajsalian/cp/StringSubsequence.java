package com.dhirajsalian.cp;

/*
Given two strings, check if 1 string is a subsequence of other.

Examples:

Input 1: s1 = "ABCD", s2 = "AD"
Output 1: true

Input 1: s1 = "ABCDE", s2 = "AED"
Output 1: false

Source: geeksforgeeks.org
 */
public class StringSubsequence {

    static boolean isSubsequence(String s1, String s2, int n1, int n2) {
        if (n2 == 0) return true;
        if (n1 == 0) return false;
        return s1.charAt(n1 - 1) == s2.charAt(n2 - 1) ?
                isSubsequence(s1, s2, n1 - 1, n2 - 1) :
                isSubsequence(s1, s2, n1 - 1, n2);
    }

    static boolean isSubsequence(String s1, String s2) {
        if (s1.length() == s2.length()) return s1.equals(s2);
        String small = s1.length() < s2.length() ? s1 : s2;
        String large = s1.equals(small) ? s2 : s1;
        return isSubsequence(large, small, large.length(), small.length());
    }

    static boolean isSubsequenceIterative(String s1, String s2) {
        int i1 = 0, i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i1++;
                i2++;
            } else i1++;
        }
        return i2 == s2.length();
    }

    public static void main(String[] args) {
        String[] inputS1 = {"ABCD", "ABCDE"};
        String[] inputS2 = {"AD", "AED"};
        for (int i = 0; i < inputS2.length; i++) {
            System.out.println(isSubsequenceIterative(inputS1[i], inputS2[i]));
        }
    }
}
