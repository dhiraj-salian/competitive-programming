package com.dhirajsalian.cp;

/*
Given an array A, print leaders in the array.
Leaders are elements which don't have greater elements to the right side.

Examples:

Input 1: A = [ 7, 10, 4, 10, 6, 5, 2 ]
Output 1: 10 6 5 2

Input 2: A = [ 10, 20, 30 ]
Output 2: 30

Input 3: A = [ 30, 20, 10 ]
Output 3: 30 20 10

Source: geeksforgeeks.org
 */
public class LeadersInArray {

    /*
    Note: Does not print in required order
     */
    static void leaders(int[] a) {
        int max = a[a.length - 1];
        System.out.print(max + " ");
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > max) {
                max = a[i];
                System.out.print(max+ " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] inputs = {{7, 10, 4, 10, 6, 5, 2}, {10, 20, 30}, {30, 20, 10}};
        for (int[] input : inputs) {
            leaders(input);
        }
    }
}
