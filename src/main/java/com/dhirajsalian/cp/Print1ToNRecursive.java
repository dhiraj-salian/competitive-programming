package com.dhirajsalian.cp;

/*
Print n to 1 Recursively.

Examples:

Input 1: n = 4
Output 1: 1 2 3 4

Input 2: n = 5
Output 2: 1 2 3 4 5

Source: geekforgeeks.org
 */
public class Print1ToNRecursive {
    static void print1toNRecursively(int n) {
        if (n == 0) return;
        print1toNRecursively(n - 1);
        System.out.printf("%d ", n);
    }

    public static void main(String[] args) {
        int[] inputs = {4, 5};
        for (int j : inputs) {
            print1toNRecursively(j);
            System.out.println();
        }
    }
}
