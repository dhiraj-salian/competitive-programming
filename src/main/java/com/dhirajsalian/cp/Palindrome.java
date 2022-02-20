package com.dhirajsalian.cp;

/*
Given an integer N, check if it is palindrome number.

Examples:

Input 1: N = 78987
Output 1: Yes

Input 2: N = 8668
Output 2: Yes

Input 3: N = 8
Output 3: Yes

Input 4: N = 21
Output 4: No

Input 5: N = 367
Output 5: No

Source: geeksforgeeks.org
 */
public class Palindrome {

    static boolean isPalindrome1(int n) {
        int digits = (int) Math.floor(Math.log10(n) + 1);
        int firstDigitHelper = (int) Math.pow(10, digits - 1);
        while (n != 0) {
            int firstDigit = n / firstDigitHelper;
            int lastDigit = n % 10;
            if (firstDigit != lastDigit) return false;
            n = n - firstDigit * firstDigitHelper;
            n /= 10;
            firstDigitHelper /= 100;
        }
        return true;
    }

    static boolean isPalindrome2(int n) {
        int num = n, rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return n == rev;
    }

    public static void main(String[] args) {
        int[] input = {78987, 8668, 8, 21, 367};
        for (int j : input) {
            System.out.println(isPalindrome2(j) ? "Yes" : "No");
        }
    }

}
