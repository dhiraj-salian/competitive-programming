// Problem: https://leetcode.com/problems/3sum-closest/

package com.dhirajsalian.cp.leetcode.threesumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE, closestSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int targetSum = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < targetSum) {
                    j++;
                    if (Math.abs(targetSum - sum) < Math.abs(difference)) {
                        closestSum = sum + nums[i];
                        difference = target - closestSum;
                    }
                } else if (sum > targetSum) {
                    k--;
                    if (Math.abs(targetSum - sum) < Math.abs(difference)) {
                        closestSum = sum + nums[i];
                        difference = target - closestSum;
                    }
                } else {
                    closestSum = sum + nums[i];
                    return closestSum;
                }
            }
        }
        return closestSum;
    }
}
