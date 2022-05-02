// Problem: https://leetcode.com/problems/sort-colors/

package com.dhirajsalian.cp.leetcode.sortColors;

class Solution {
    public void sortColors(int[] nums) {
        int reds = 0, whites = 0, blues = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    reds++;
                    break;
                case 1:
                    whites++;
                    break;
                case 2:
                    blues++;
                    break;
            }
        }
        for (int i = 0; i < reds; i++) {
            nums[i] = 0;
        }
        for (int i = reds; i < reds + whites; i++) {
            nums[i] = 1;
        }
        for (int i = reds + whites; i < reds + whites + blues; i++) {
            nums[i] = 2;
        }
    }
}
