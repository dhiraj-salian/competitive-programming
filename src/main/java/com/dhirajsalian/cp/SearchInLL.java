package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a single Linked List, find if the element exists.

Examples:

Input 1: 10->5->20->15->NULL, x = 20
Output 1: 3

Input 2: 10->15->NULL, x = 20
Output 2: -1

Input 3: 3->20->5->NULL, x = 3
Output 3: 1

Source: geeksforgeeks.org
 */
public class SearchInLL {

    static int search(LLNode head, int x, int position) {
        if (head == null) return -1;
        if (head.value == x) return position;
        return search(head.next, x, position + 1);
    }

    static int search(LLNode head, int x) {
        int index = 1;
        for (LLNode curr = head; curr != null; curr = curr.next) {
            if (curr.value == x) return index;
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 5, 20, 15}, {10, 15}, {3, 20, 5}};
        int[] inputX = {20, 20, 3};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(search(CustomUtil.createLinkedList(inputs[i]), inputX[i], 1));
        }
    }
}
