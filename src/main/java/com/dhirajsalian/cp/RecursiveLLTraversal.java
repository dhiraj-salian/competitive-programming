package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list head, recursively print the nodes of the linked list.

Examples:

Input 1: 10 20 30 40
Output 1: 10 20 30 40

Input 2: 10
Output 2: 10

Input 3: NULL
Output 3:

Source: geeksforgeeks.org
 */
public class RecursiveLLTraversal {

    static void recursiveTraversal(LLNode head) {
        if (head == null) {
            System.out.println();
            return;
        }
        System.out.printf("%s ", head.value);
        recursiveTraversal(head.next);
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40}, {10}, {}};
        for (int[] input : inputs) {
            recursiveTraversal(CustomUtil.createLinkedList(input));
        }
    }
}
