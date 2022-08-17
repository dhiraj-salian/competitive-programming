// Problem: https://leetcode.com/problems/jump-game/

package com.dhirajsalian.cp.leetcode.problemPatterns.jumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] possible = new boolean[nums.length];
        possible[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) possible[i] |= possible[j];
                if (possible[i]) break;
            }
        }
        return possible[nums.length - 1];
    }
}
