package com.dhirajsalian.cp;

import java.util.ArrayList;
import java.util.List;

/*
Given a string of length n, find all subsets of a string.

Examples:

Input 1: s = "AB"
Output 1: "", "A", "B", "AB"

Input 2: s = "ABC"
Output 2: "", "A", "B", "C", "AB", "AC", "BC", "ABC"

Source: geeksforgeeks.org
 */
public class SubsetsRecursive {

    static void subsets(String s, List<String> subset) {
        subsets("", 0, s, subset);
    }

    static void subsets(String curr, int index, String s, List<String> subset) {
        if (index >= s.length()) {
            subset.add(curr);
            return;
        }
        subsets(curr + s.charAt(index), index + 1, s, subset);
        subsets(curr, index + 1, s, subset);
    }

    public static void main(String[] args) {
        String[] inputs = {"AB", "ABC"};
        for (String input : inputs) {
            List<String> subset = new ArrayList<>();
            subsets(input, subset);
            System.out.println(subset);
        }
    }
}
