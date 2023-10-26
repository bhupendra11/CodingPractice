package com.prep2023.stackAndQueues;

public class _5MinStack {

    Node head;

    class Node{
        int val;
        int min;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public _5MinStack() {
        this.head = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        if(head == null){
            newNode.min = val;
        }
        else{
            newNode.min = Math.min(head.min, val);
        }
        newNode.next = head;
        this.head = newNode;
    }

    public void pop() {
        this.head = this.head.next;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {

        return this.head.min;
    }

    public static void main(String[] args) {
        _5MinStack obj = new _5MinStack();

        // Push some elements onto the stack
        obj.push(3);
        obj.push(2);
        obj.push(4);
        obj.push(1);

        // Print the minimum element in the stack
        System.out.println("Minimum element: " + obj.getMin()); // Expected: 1

        // Pop an element from the stack
        obj.pop();

        // Print the element at the top of the stack
        System.out.println("Top element: " + obj.top()); // Expected: 4

        // Print the minimum element in the stack after the pop
        System.out.println("Minimum element: " + obj.getMin()); // Expected: 2
    }
}
