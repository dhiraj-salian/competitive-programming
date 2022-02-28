package com.dhirajsalian.cp.util;

public class LLNode {
    public int value;
    public LLNode next;

    public LLNode(int value) {
        this.value = value;
        this.next = null;
    }

    public LLNode(int value, LLNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
