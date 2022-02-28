package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list and number n, find the nth node from the end of the linked list.

Examples:

Input 1: 10->20->30->40->50->NULL, n = 2
Output 1: 40

Input 2: 10->20->30->NULL, n = 3
Output 2: 10

Input 3: 10->20->NULL, n = 3
Output 3:

Input 4: 10->20->30->NULL, n = 1
Output 4: 30

Source: geeksforgeeks.org
 */
public class NthNodeFromEndLL {

    static LLNode nthNode(LLNode head, int n) {
        LLNode curr = head, nth = head;
        while (n > 0 && curr != null) {
            curr = curr.next;
            n--;
        }
        if (n > 0) return null;
        while (curr != null) {
            curr = curr.next;
            nth = nth.next;
        }
        return nth;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40, 50}, {10, 20, 30}, {10, 20}, {10, 20, 30}};
        int[] inputN = {2, 3, 3, 1};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(nthNode(CustomUtil.createLinkedList(inputs[i]), inputN[i]));
        }
    }
}
