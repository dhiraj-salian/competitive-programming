package com.dhirajsalian.cp;

/*
Given an array A of integers, return the index of majority element.
A majority element is an element that appears more than n/2 times in an array, where n = length of the array.

Examples:

Input 1: A = [ 8, 3, 4, 8, 8 ]
Output 1: 0 or 3 or 4

Input 2: A = [ 3, 7, 4, 7, 7, 5 ]
Output 2: -1

Input 3: A = [ 20, 30, 40, 50, 50, 50, 50 ]
Output 3: 3 or 4 or 5 or 6

Source: geeksforgeeks.org
 */
public class MajorityElement {

    static int majorityElement(int[] a) {
        int res = 0, count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[res] == a[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int j : a) {
            if (a[res] == j) count++;
        }
        if (count <= a.length / 2) {
            res = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputs = {{8, 3, 4, 8, 8}, {3, 7, 4, 7, 7, 5}, {20, 30, 40, 50, 50, 50, 50}};
        for (int[] input : inputs) {
            int out = majorityElement(input);
            System.out.println(out == -1 ? "No Element" : input[out]);
        }
    }
}
