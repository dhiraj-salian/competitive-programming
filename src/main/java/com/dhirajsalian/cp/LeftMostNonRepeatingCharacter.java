package com.dhirajsalian.cp;

/*
Given a string s, find the left most non repeating character.

Examples:

Input 1: s = "geeksforgeeks"
Output 1: 5

Input 2: s = "abcabc"
Output 2: -1

Input 3: s = "apple"
Output 3: 0

Source: geeksforgeeks.org
 */
public class LeftMostNonRepeatingCharacter {

    static int leftMostNonRepeatingCharacter(String s) {
        int[] CHAR = new int[256];
        for (int i = 0; i < s.length(); i++) {
            CHAR[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (CHAR[s.charAt(i)] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] inputs = {"geeksforgeeks", "abcabc", "apple"};
        for (String input : inputs) {
            System.out.println(leftMostNonRepeatingCharacter(input));
        }
    }
}
