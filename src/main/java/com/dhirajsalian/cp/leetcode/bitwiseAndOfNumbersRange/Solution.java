// Problem: https://leetcode.com/problems/bitwise-and-of-numbers-range/

package com.dhirajsalian.cp.leetcode.bitwiseAndOfNumbersRange;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;
        while(left != right) {
            left >>= 1;
            right >>= 1;
            shifts++;
        }
        return left<<shifts;
    }
}
