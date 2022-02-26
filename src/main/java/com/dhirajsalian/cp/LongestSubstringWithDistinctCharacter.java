package com.dhirajsalian.cp;

import java.util.Arrays;

/*
Given a string str, find the longest substring with distinct characters.

Examples:

Input 1: str = "abcdabc"
Output 1: 4

Input 2: str = "aaa"
Output 2: 1

Input 3: str = ""
Output 3: 0

Input 4: str = "abaacdbab"
Output 4: 4

Source: geeksforgeeks.org
 */
public class LongestSubstringWithDistinctCharacter {

    static int longestSubstringWithDistinctCharacter(String str) {
        int start = 0, res = 0, maxEnd;
        int[] index = new int[256];
        Arrays.fill(index, -1);
        for (int i = 0; i < str.length(); i++) {
            start = Math.max(start, index[str.charAt(i)] + 1);
            maxEnd = i - start + 1;
            res = Math.max(res, maxEnd);
            index[str.charAt(i)] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] inputStr = {"abcdabc", "aaa", "", "abaacdbab"};
        for (String str : inputStr) {
            System.out.println(longestSubstringWithDistinctCharacter(str));
        }
    }
}
