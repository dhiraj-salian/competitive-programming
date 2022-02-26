package com.dhirajsalian.cp;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an array of integers, return distinct elements in it.

Examples:

Input 1: arr = [ 15, 12, 13, 12, 13, 13, 18 ]
Output 1: 4

Input 2: arr = [ 10, 10, 10 ]
Output 2: 1

Input 3: arr = [ 10, 11, 12 ]
Output 3: 3

Source: geeksforgeeks.org
 */
public class CountDistinctElements {

    static int countDistinctElements(Integer[] arr) {
        HashSet<Integer> h = new HashSet<>(Arrays.asList(arr));
        return h.size();
    }

    public static void main(String[] args) {
        Integer[][] inputs = {{15, 12, 13, 12, 13, 13, 18}, {10, 10, 10}, {10, 11, 12}};
        for (Integer[] input : inputs) {
            System.out.println(countDistinctElements(input));
        }
    }
}
