package com.dhirajsalian.cp;

/*
Given an integer n, count set bits in the integer.

Examples:

Input 1: n = 5
Output 1: 2

Input 2: n = 7
Output 2: 3

Input 3: n = 13
Output 3: 3
 */
public class CountSetBits {

    static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    static int countSetBitsBrianKerningamAlgorithm(int n) {
        int res = 0;
        while (n > 0) {
            n = (n & n - 1);
            res++;
        }
        return res;
    }

    static void initialize(int[] table) {
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
    }

    static int countSetBitsLookupMethod(int n, int[] table) {
        int res = 0;
        while (n != 0) {
            res += table[n & 0xff];
            n >>= 8;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] table = new int[256];
        initialize(table);
        int[] input = {5, 7, 13};
        for (int j : input) {
            System.out.println(countSetBitsLookupMethod(j, table));
        }
    }
}
