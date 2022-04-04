// Problem: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

package com.dhirajsalian.cp.leetcode.longestArithmeticSubsequenceOfGivenDifference;

import java.util.HashMap;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - difference)) {
                map.put(arr[i], map.get(arr[i] - difference) + 1);
            } else {
                map.put(arr[i], 1);
            }
            res = Math.max(res, map.get(arr[i]));
        }
        return res;
    }
}
