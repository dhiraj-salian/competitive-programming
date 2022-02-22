package com.dhirajsalian.cp;

/*
Given a binary array B, print the flips done such that there are minimum consecutive flips required to make
all the elements same.

Examples:

Input 1: B = [ 1, 1, 0, 0, 0, 1 ]
Output 1: From 2 to 4

Input 2: B = [ 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1 ]
Output 2: From 1 to 3
          From 5 to 6

Input 3: B = [ 1, 1, 1 ]
Output 3:

Input 4: B = [ 0, 1 ]
Output 4: From 0 to 0
            or
          From 1 to 1
 */
public class MinimumConsecutiveFlips {

    // GFG Solution:
    // The difference in number of groups would differ by 1
    // if both first and last elements are same. And second group will always be smaller.
    // The number of groups would be same if both first and last elements are different.
    // So we should always print second group
    static void minimumConsecFlips(int[] b) {
        for (int i = 1; i < b.length; i++) {
            if (b[i] != b[i - 1]) {
                if (b[i] != b[0]) System.out.printf("From %s to ", i);
                else System.out.println(i - 1);
            }
        }
        if (b[b.length - 1] != b[0])
            System.out.println(b.length - 1);
        System.out.println();
    }


    static void minimumConsecutiveFlips(int[] b) {
        int oneToZero = 0, zeroToOne = 0;
        if (b[0] == 0) oneToZero = 1;
        else zeroToOne = 1;
        for (int i = 1; i < b.length; i++) {
            if (b[i] == 0 && b[i - 1] == 1) oneToZero++;
            if (b[i] == 1 && b[i - 1] == 0) zeroToOne++;
        }
        boolean oneToZeroPrint = oneToZero <= zeroToOne;
        int start = -1;
        for (int i = 0; i < b.length; i++) {
            if (oneToZeroPrint) {
                if (b[i] == 0 && (i == 0 || b[i - 1] == 1)) {
                    start = i;
                }
                if (b[i] == 1 && i != 0 && b[i - 1] == 0) {
                    System.out.printf("From %s to %s\n", start, i - 1);
                    start = -1;
                }
            } else {
                if (b[i] == 1 && (i == 0 || b[i - 1] == 0)) {
                    start = i;
                }
                if (b[i] == 0 && i != 0 && b[i - 1] == 1) {
                    System.out.printf("From %s to %s\n", start, i - 1);
                    start = -1;
                }
            }
        }
        if (start > 0)
            System.out.printf("From %s to %s\n", start, b.length - 1);
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 1, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1}, {1, 1, 1}, {0, 1}};
        for (int[] input : inputs) {
            minimumConsecFlips(input);
        }
    }
}
