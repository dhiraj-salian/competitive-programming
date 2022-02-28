package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given two intersecting linked list, return the intersection point of the two linked list.

Examples:

Input 1: 5->8->7->10->12->15->NULL
               9->
Output 1: 10

Source: geeksforgeeks.org
 */
public class IntersectionPointLL {

    static LLNode intersection(LLNode head1, LLNode head2) {
        if (head1 == null || head2 == null) return null;
        int c1 = 0, c2 = 0;
        LLNode curr = head1;
        while (curr != null) {
            c1++;
            curr = curr.next;
        }
        curr = head2;
        while (curr != null) {
            c2++;
            curr = curr.next;
        }
        int diff = Math.abs(c1 - c2);
        curr = c1 >= c2 ? head1 : head2;
        while (diff != 0) {
            curr = curr.next;
            diff--;
        }
        LLNode curr2 = c1 >= c2 ? head2 : head1;
        while (curr != null && curr2 != null) {
            if (curr == curr2) return curr;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LLNode[][] inputs = {input1()};
        for (LLNode[] in : inputs) {
            System.out.println(intersection(in[0], in[1]));
        }
    }

    static LLNode[] input1() {
        LLNode[] in = new LLNode[2];
        in[0] = CustomUtil.createLinkedList(new int[]{5, 8, 7, 10, 12, 15});
        in[1] = new LLNode(9, in[0].next.next.next);
        return in;
    }
}
