// Problem: https://leetcode.com/problems/longest-well-performing-interval/

package com.dhirajsalian.cp.leetcode.longestWellPerformingInterval;

import java.util.HashMap;

class Solution {
    public int longestWPI(int[] hours) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> simap = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            sum += (hours[i] > 8 ? 1 : -1);
            if (!simap.containsKey(sum)) simap.put(sum, i);
            if (sum > 0) res = Math.max(res, i + 1);
            if(simap.containsKey(sum-1)) res = Math.max(res, i - simap.get(sum-1));
        }
        return res;
    }
}
