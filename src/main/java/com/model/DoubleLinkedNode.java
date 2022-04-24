package com.model;

public class DoubleLinkedNode {
    public DoubleLinkedNode prev;
    public DoubleLinkedNode next;
    public int key;
    public int value;

    public DoubleLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public DoubleLinkedNode(int key, int value, DoubleLinkedNode prev, DoubleLinkedNode next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
