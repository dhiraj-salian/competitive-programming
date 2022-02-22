package com.dhirajsalian.cp;

/*
Print n to 1 Recursively.

Examples:

Input 1: n = 5
Output 1: 5 4 3 2 1

Input 2: n = 2
Output 2: 2 1

Source: geeksforgeeks.org
 */
public class PrintNTo1Recursive {

    static void printNto1Recursively(int n) {
        if (n == 0) return;
        System.out.printf("%d ", n);
        printNto1Recursively(n - 1);
    }

    public static void main(String[] args) {
        int[] inputs = {5, 2};
        for (int j : inputs) {
            printNto1Recursively(j);
            System.out.println();
        }
    }
}
