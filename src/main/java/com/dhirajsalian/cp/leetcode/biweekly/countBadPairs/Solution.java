// Problem: https://leetcode.com/contest/biweekly-contest-84/problems/count-number-of-bad-pairs/

package com.dhirajsalian.cp.leetcode.biweekly.countBadPairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        long count = getPairCount(nums.length);
        Map<Integer, Long> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i] - i, frequency.getOrDefault(nums[i] - i, 0L) + 1);
        }
        for(int key: frequency.keySet()) {
            if(frequency.get(key)>1) count -=  getPairCount(frequency.get(key));
        }
        return count;
    }

    private long getPairCount(long n) {
        return n * (n - 1) / 2;
    }
}
