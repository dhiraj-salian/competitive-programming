package com.dhirajsalian.cp;

/*
Given integers x and n, compute x ^ n.

Examples:

Input 1: x = 2, n = 3
Output 1: 8

Input 2: x = 3, n = 4
Output 2: 81

Input 3: x = 5, n = 0
Output 3: 1

Input 4: x = 5, n = 1
Output 4: 5

Source: geeksforgeeks.org
 */
public class ComputingPower {

    static int power(int x, int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= x;
        }
        return res;
    }

    static int powerRec(int x, int n) {
        if (n == 0) return 1;
        int temp = powerRec(x, n / 2);
        temp = temp * temp;
        if (n % 2 == 0)
            return temp;
        else
            return x * temp;
    }

    static int binaryPower(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x = x * x;
            n = n >> 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inputX = {2, 3, 5, 5};
        int[] inputN = {3, 4, 0, 1};
        for (int i = 0; i < inputN.length; i++) {
            System.out.println(binaryPower(inputX[i], inputN[i]));
        }
    }
}
