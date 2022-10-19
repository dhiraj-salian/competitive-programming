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

    // greedy approach
    /*public boolean canJump(int[] nums) {
        int last = nums.length -1;
        if(last==0) return true;
        for(int i=last-1;i>=0;i--) {
            if(i+nums[i]>=last) last = i;
            if(last==0) return true;
        }
        return false;
    }*/
}
