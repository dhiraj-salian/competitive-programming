// Problem: https://leetcode.com/problems/longest-consecutive-sequence/

package com.dhirajsalian.cp.leetcode.longestConsecutiveSequence;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if(set.contains(number+1))
                continue;
            int length = 0;
            while (set.contains(number)) {
                length++;
                number--;
            }
            res = Math.max(res, length);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}
