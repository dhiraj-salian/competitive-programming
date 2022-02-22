package com.dhirajsalian.cp;

/*
Given a circular array A, find the maximum sub-array sum.

Input 1: [ 10, 5, -5 ]
Output 1: 15

Input 2: [ 5, -2, 3, 4 ]
Output 2: 12

Input 3: [ 2, 3, -4 ]
Output 3: 5

Input 4: [ 8, -4, 3, -5, 4 ]
Output 4: 12

Input 5: [ -3, 4, 6, -2 ]
Output 5: 10

Input 6: [ -8, 7, 6 ]
Output 6: 13

Input 7: [ 3, -4, 5, 6 -8, 7 ]
Output 7: 17

Input 8: [ -5, -3 ]
Output 8: -3

Source: geeksforgeeks.org
 */
public class MaximumCircularSubArraySum {

    static int maxCircularSubArraySum(int[] a) {
        int maxEnding = a[0], maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            maxEnding = Math.max(a[i], maxEnding + a[i]);
            maxSum = Math.max(maxSum, maxEnding);
        }
        if (maxSum < 0)
            return maxSum;
        int minEnding = a[0], minSum = a[0];
        for (int i = 1; i < a.length; i++) {
            minEnding = Math.min(a[i], minEnding + a[i]);
            minSum = Math.min(minSum, minEnding);
        }
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        int circularSubArraySum = sum - minSum;
        return Math.max(maxSum, circularSubArraySum);
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 5, -5}, {5, -2, 3, 4}, {2, 3, -4}, {8, -4, 3, -5, 4},
                {-3, 4, 6, -2}, {-8, 7, 6}, {3, -4, 5, 6, -8, 7}, {-5,-3}};
        for (int[] input : inputs) {
            System.out.println(maxCircularSubArraySum(input));
        }
    }

}
