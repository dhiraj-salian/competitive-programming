package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list pair-wise swap nodes of a linked list.

Examples:

Input 1: 1->2->3->4->5->6->NULL
Output 1: 2->1->4->3->6->5->NULL

Input 2: 1->2->3->4->5->NULL
Output 2: 2->1->4->3->5->NULL

Source: geeksforgeeks.org
 */
public class PairwiseSwapNodesLL {

    static LLNode pairwiseSwap(LLNode head) {
        if (head == null) return null;
        LLNode curr = head, prev = null;
        while (curr != null && curr.next != null) {
            if (prev == null) {
                LLNode temp = curr.next;
                curr.next = temp.next;
                temp.next = curr;
                head = temp;
            } else {
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = curr;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5}};
        for (int[] input : inputs) {
            LLNode head = CustomUtil.createLinkedList(input);
            CustomUtil.printLinkedList(pairwiseSwap(head));
        }
    }
}
