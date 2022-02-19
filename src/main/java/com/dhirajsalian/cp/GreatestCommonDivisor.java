package com.dhirajsalian.cp;

/*
Find gcd of two numbers a and b.

Examples:

Input 1: a = 4, b = 6
Output 1: 2

Input 2: a = 100, b = 200
Output 2: 100

Input 3: a = 7, b = 13
Output 3: 1
 */
public class GreatestCommonDivisor {

    static int gcd1(int a, int b) {
        if (b == 0) return a;
        return gcd1(b, a % b);
    }

    static int gcd2(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] inputA = {4, 100, 7};
        int[] inputB = {6, 200, 13};
        for (int i = 0; i < inputA.length; i++) {
            System.out.println(gcd2(inputA[i], inputB[i]));
        }
    }
}
