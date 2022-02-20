package com.dhirajsalian.cp;

import java.util.ArrayList;
import java.util.List;

/*
Generate Power Set for a given string s using Bitwise Operator.

Examples:

Input 1: s = "abc"
Output 1: "", "a", "b", "c", "ab", "bc", "ac", "abc"

Input 2: s = "ab"
Output 2: "", "a", "b", "ab"

Source: geeksforgeeks.org
 */
public class PowerSet {

    static void printPowerSet(String s) {
        List<String> powerSet = new ArrayList<>();
        int setSize = (int) Math.pow(2, s.length());
        for (int i = 0; i < setSize; i++) {
            StringBuilder ele = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if ((i & (1 << j)) != 0) ele.append(s.charAt(j));
            }
            powerSet.add(ele.toString());
        }
        System.out.println(powerSet);
    }

    public static void main(String[] args) {
        String[] inputs = {"abc", "ab"};
        for (String input : inputs) {
            printPowerSet(input);
        }
    }

}
