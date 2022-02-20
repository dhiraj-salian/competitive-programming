package com.dhirajsalian.cp;

/*
Given an array of numbers, find the two odd occurring number.

Examples:

Input 1: arr[] = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 }
Output 1: 5 6

Input 2: arr[] = { 20, 15, 20, 16 }
Output 2: 15 16

Source: geeksforgeeks.org
 */
public class TwoOddOccurringNumber {

    static Pair findTwoOddOccurringNumber(int[] arr) {
        int xor = 0, a = 0, b = 0;
        for (int j : arr) {
            xor ^= j;
        }
        int sn = (xor & -xor);
        for (int j : arr) {
            if ((j & sn) != 0) {
                a ^= j;
            } else {
                b ^= j;
            }
        }
        return new Pair(a, b);
    }

    public static void main(String[] args) {
        int[][] inputs = {{3, 4, 3, 4, 5, 4, 4, 6, 7, 7}, {20, 15, 20, 16}};
        for (int[] input : inputs) {
            System.out.println(findTwoOddOccurringNumber(input));
        }
    }

    public static class Pair {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

}
