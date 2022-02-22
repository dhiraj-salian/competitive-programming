package com.dhirajsalian.cp;

/*
Given n ranges, find the maximum appearing element in these ranges.

Examples:

Input 1: L = [ 1, 2, 5, 15 ], R = [ 5, 8, 7, 18 ]
Output 1: 5

Source: geeksforgeeks.org
 */
public class MaxAppearingElementInRanges {

    static int maxAppearingElement(int[] l, int[] r) {
        int[] temp = new int[1000];
        for (int i = 0; i < l.length; i++) {
            temp[l[i]]++;
            temp[r[i]+1]--;
        }
        int max = temp[0], res = 0;
        for (int i = 1; i < 1000; i++) {
            temp[i] += temp[i - 1];
            if (max < temp[i]) {
                max = temp[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inputL = {1, 2, 5, 15};
        int[] inputR = {5, 8, 7, 18};
        System.out.println(maxAppearingElement(inputL, inputR));
    }
}
