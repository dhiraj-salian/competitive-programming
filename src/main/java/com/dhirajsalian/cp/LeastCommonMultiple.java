package com.dhirajsalian.cp;

/*
Given two number a and b, find LCM of these two numbers.

Examples:

Input 1: a = 4, b = 6
Output 1: 12

Input 2: a = 2, b = 8
Output 2: 8

Input 3: a = 12, b = 15
Output 3: 60

Input 4: a = 3, b = 7
Output 4: 21

Source: geeksforgeeks.org
 */
public class LeastCommonMultiple {

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] inputA = {4, 2, 12, 3};
        int[] inputB = {6, 8, 15, 7};
        for (int i = 0; i < inputA.length; i++) {
            System.out.println(lcm(inputA[i], inputB[i]));
        }
    }
}
