// Problem: https://leetcode.com/problems/find-all-duplicates-in-an-array/

package com.dhirajsalian.cp.leetcode.findAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            if (nums[number - 1] < 0) ans.add(number);
            nums[number - 1] = -Math.abs(nums[number - 1]);
        }
        return ans;
    }
}
