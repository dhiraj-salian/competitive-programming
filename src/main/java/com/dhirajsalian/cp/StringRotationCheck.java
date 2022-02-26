package com.dhirajsalian.cp;

/*
Given two strings s1 and s2, check if 1 string is a rotation of other.

Examples:

Input 1: s1 = "ABCD", s2 = "CDAB"
Output 1: yes

Input 2: s1 = "ABAAA", s2 = "BAAAA"
Output 2: yes

Input 3: s1 = "ABAB", s2 = "ABBA"
Output 3: no

Source: geeksforgeeks.org
 */
public class StringRotationCheck {

    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        String[] inputS1 = {"ABCD", "ABAAA", "ABAB"};
        String[] inputS2 = {"CDAB", "BAAAA", "ABBA"};
        for (int i = 0; i < inputS1.length; i++) {
            System.out.println(isRotation(inputS1[i], inputS2[i]) ? "yes" : "no");
        }
    }
}
