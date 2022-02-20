package com.dhirajsalian.cp;

/*
Josephus Problem: Out of n people in a circle, in every round kth person killed, return position of the survivor.

Examples:

Input 1: n = 7, k =3
Output 1: 3

Input 2: n = 8, k = 2
Output 2: 0

Source: geeksforgeeks.org
 */
public class JosephusProblemRecursive {

    static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (k + josephus(n - 1, k)) % n;
    }

    public static void main(String[] args) {
        int[] inputN = {7, 8};
        int[] inputK = {3, 2};
        for (int i = 0; i < inputN.length; i++) {
            System.out.println(josephus(inputN[i], inputK[i]));
        }
    }
}
