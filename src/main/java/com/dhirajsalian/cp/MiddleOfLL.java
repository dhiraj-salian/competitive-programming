package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a Linked List, find the middle of the linked list. In case of even number of nodes, print the second middle.

Examples:

Input 1: 10->5->20->15->25->NULL
Output 1: 20

Input 2: 10->5->20->15->25->30->NULL
Output 2: 15

Input 3: 10->NULL
Output 3: 10

Input 4: NULL
Output 4:

Input 5: 10->20->NULL
Output 5: 20

Source: geeksforgeeks.org
 */
public class MiddleOfLL {

    static LLNode middle(LLNode head) {
        if (head == null) return null;
        LLNode curr = head, fast = head;
        while (fast != null && fast.next != null) {
            curr = curr.next;
            fast = fast.next.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 5, 20, 15, 25}, {10, 5, 20, 15, 25, 30}, {10}, {}, {10, 20}};
        for (int[] input : inputs) {
            LLNode head = CustomUtil.createLinkedList(input);
            System.out.println(middle(head));
        }
    }
}
