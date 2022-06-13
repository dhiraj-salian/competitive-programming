// Problem: https://leetcode.com/problems/subsets/

package com.dhirajsalian.cp.leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        subsets(nums, nums.length, currentSet, result);
        return result;
    }

    void subsets(int[] nums, int length, List<Integer> currentSet, List<List<Integer>> result) {
        if (length <= 0) {
            result.add(currentSet);
            return;
        }
        List<Integer> dupCurrentSet = new ArrayList<>(currentSet);
        dupCurrentSet.add(nums[length - 1]);
        subsets(nums, length - 1, currentSet, result);
        subsets(nums, length - 1, dupCurrentSet, result);
    }
}
