package com.bhupendra.prep2023.stackAndQueues;

import java.util.Stack;

/**
 * Author: Bhupendra Shekhawat
 * Date: 23/10/23
 * Topic: com.prep2023.stackAndQueues
 * Question Link: https://leetcode.com/problems/implement-queue-using-stacks/description/
 * YouTube Link:
 * Problem:
 * 232. Implement Queue using Stacks
 */

public class _3ImplementQueueUsing2StackPushOptimised {
    class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>(); //auxillary stack
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() { //need to remove the bottom most
            //move all exisiting elements to s2 (auxillary stack)
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int result = s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return result;
        }

        public int peek() {
            //move all exisiting elements to s2 (auxillary stack)
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int result = s2.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return result;
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        _3ImplementQueueUsing2StackPopOptimised.MyQueue obj = new _3ImplementQueueUsing2StackPopOptimised.MyQueue();

        // Enqueue elements
        obj.push(1);
        obj.push(2);
        obj.push(3);

        // Dequeue elements
        int param_2 = obj.pop(); // Dequeues 1
        int param_3 = obj.pop(); // Dequeues 2

        // Peek at the front element
        int param_4 = obj.peek(); // Returns 3

        // Check if the queue is empty
        boolean param_5 = obj.empty(); // Returns false

        System.out.println("Dequeued: " + param_2);
        System.out.println("Dequeued: " + param_3);
        System.out.println("Front element: " + param_4);
        System.out.println("Is the queue empty? " + param_5);
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
