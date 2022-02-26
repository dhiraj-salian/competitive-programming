package com.dhirajsalian.cp;

/*
Given a string s, find the left most repeating character.

Examples:

Input 1: s = "geeksforgeeks"
Output 1: 0

Input 2: s = "abbcc"
Output 2: 1

Input 3: s = "abcd"
Output 3: -1

Source: geeksforgeeks.org
 */
public class LeftMostRepeatingCharacter {

    static int leftMostRepeatingChar(String s) {
        int res = s.length();
        int[] CHAR = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            CHAR[s.charAt(i) - 'a']++;
            if (CHAR[s.charAt(i) - 'a'] > 1) res = i;
        }
        return res != s.length() ? res : -1;
    }

    public static void main(String[] args) {
        String[] inputs = {"geeksforgeeks", "abbcc", "abcd"};
        for (String inp : inputs) {
            System.out.println(leftMostRepeatingChar(inp));
        }
    }
}
