package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list and a value k, reverse the linked list in groups of size k.

Examples:

Input 1: 10->20->30->40->50->60->NULL, k = 3
Output 1: 30->20->10->60->50->40->NULL

Input 2: 10->20->30->40->50->NULL, k = 3
Output 2: 30->20->10->50->40->NULL

Input 3: 10->20->30->NULL, k = 4
Output 3: 30->20->10->NULL

Source: geeksforgeeks.org
 */
public class ReverseInGroupLL {

    static LLNode reverseInGroup(LLNode head, int k) {
        if (head == null) return null;
        LLNode curr = head, prev = null;
        int start = 1;
        while (start <= k && curr != null) {
            LLNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            start++;
        }
        head.next = reverseInGroup(curr, k);
        return prev;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40, 50, 60}, {10, 20, 30, 40, 50}, {10, 20, 30}};
        int[] inputK = {3, 3, 4};
        for (int i = 0; i < inputK.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputs[i]);
            CustomUtil.printLinkedList(reverseInGroup(head, inputK[i]));
        }
    }
}
