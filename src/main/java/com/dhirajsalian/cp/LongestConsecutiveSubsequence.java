package com.dhirajsalian.cp;

import java.util.HashSet;

/*
Given an array of integers, find the longest consecutive sum.

Examples:

Input 1: arr = [ 1, 9, 3, 4, 2, 20 ]
Output 1: 4

Input 2: arr = [ 8, 20, 7, 30 ]
Output 2: 2

Input 3: arr = [ 20, 30, 40 ]
Output 3: 1

Source: geeksforgeeks.org
 */
public class LongestConsecutiveSubsequence {

    static int longestConsecutiveSubsequence(int[] input) {
        HashSet<Integer> h = new HashSet<>();
        int res = 1;
        for (int i : input) {
            h.add(i);
        }
        for (int i : h) {
            if (!h.contains(i - 1)) {
                int curr = 1;
                while (h.contains(i + curr)) {
                    curr++;
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 9, 3, 4, 2, 20}, {8, 20, 7, 30}, {20, 30, 40}};
        for (int[] input : inputs) {
            System.out.println(longestConsecutiveSubsequence(input));
        }
    }
}
