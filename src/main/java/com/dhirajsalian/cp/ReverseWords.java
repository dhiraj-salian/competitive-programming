package com.dhirajsalian.cp;

/*
Given a string s, reverse words in a string.

Examples:

Input 1: s = "Welcome to gfg"
Output 1: s = "gfg to Welcome"

Input 2: s = "I love coding"
Output 2: s = "coding love I"

Input 3: s = "abc"
Output 3: s = "abc"

Source: geeksforgeeks.org
 */
public class ReverseWords {

    static void reverseWords(char[] s) {
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);
        reverse(s, 0, s.length - 1);
    }

    static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String[] inputs = {"Welcome to gfg", "I love coding", "abc"};
        for (String input : inputs) {
            char[] str = input.toCharArray();
            reverseWords(str);
            System.out.println(new String(str));
        }
    }
}
