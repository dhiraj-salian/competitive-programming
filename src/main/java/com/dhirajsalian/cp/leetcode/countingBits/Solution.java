// Problem: https://leetcode.com/problems/counting-bits/

package com.dhirajsalian.cp.leetcode.countingBits;

class Solution {
    public int[] countBits(int n) {
        int[] bitCount = new int[n + 1];
        bitCount[0] = 0;
        if (n == 0) return bitCount;
        bitCount[1] = 1;
        if (n == 1) return bitCount;
        int closestPowerOf2 = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bitCount[i] = 1;
                closestPowerOf2 = i;
            } else {
                bitCount[i] = 1 + bitCount[i & ~closestPowerOf2];
            }
        }
        return bitCount;
    }

    public int[] countBitsDP(int n) {
        int[] bitCount = new int[n + 1];
        bitCount[0] = 0;
        if (n == 0) return bitCount;
        bitCount[1] = 1;
        if (n == 1) return bitCount;
        for (int i = 2; i <= n; i++) {
            int msb = (int) Math.floor(Math.log10(i) / Math.log10(2));
            int closestPowerOf2 = (int) Math.pow(2, msb);
            bitCount[i] = 1 + bitCount[i & ~closestPowerOf2];
        }
        return bitCount;
    }
}
