// Problem: https://leetcode.com/problems/climbing-stairs/

package com.dhirajsalian.cp.leetcode.problemPatterns.climbingStairs;

class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 0;
        if(n>0) steps[1] = 1;
        if(n>1) steps[2] = 2;
        if(n>2) {
            for (int i = 3; i <= n; i++) {
                steps[i] = steps[i - 1] + steps[i - 2];
            }
        }
        return steps[n];
    }
}
