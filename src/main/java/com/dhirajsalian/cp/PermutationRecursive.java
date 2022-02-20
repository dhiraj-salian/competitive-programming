package com.dhirajsalian.cp;

/*
Given an input S, print all permutations of S.

Examples:

Input 1: S = "ABC"
Output 1: ABC, ACB, BAC, BCA, CAB, CBA

Input 2: S = "AB"
Output 2: AB BA

Input 3: S = ""
Output 3:

Source: geeksforgeeks.org
 */
public class PermutationRecursive {

    static void permute(String s, int i) {
        if (i >= s.length()) {
            System.out.printf("%s ", s);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            permute(swap(s, i, j), i + 1);
        }
    }

    static String swap(String s, int i, int j) {
        if (i == j) return s;
        int small = Math.min(i, j);
        int large = Math.max(i, j);
        return s.substring(0, small) + s.charAt(large)
                + s.substring(small + 1, large) + s.charAt(small) + s.substring(large + 1);
    }

    public static void main(String[] args) {
        String[] input = {"ABC", "AB", ""};
        for (String s : input) {
            permute(s, 0);
            System.out.println();
        }
    }
}
