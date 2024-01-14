package com.bhupendra.prep2023.stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 22/10/23
 * Topic: com.prep2023.stackAndQueues
 * Question Link: https://leetcode.com/problems/implement-stack-using-queues/description/
 * YouTube Link:
 * Problem:
 225. Implement Stack using Queues
 */
public class _2ImplementStackUsingOneQueueOnly {

    static class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) { //push the element like you would want in a stack, i.e for every element pushed, move it to front
            queue.offer(x);
            //move it to front
            for(int i=0;i<queue.size()-1;i++){
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            if(queue.isEmpty())return -1;
            return queue.poll();
        }

        public int top() {
            if(queue.isEmpty())return -1;

            return queue.peek();
        }

        public boolean empty() {
            return queue.size() ==0;
        }
    }


    public static void main(String[] args) {
        _1ImplementStackUsingTwoQueuesEasy.MyStack stack = new _1ImplementStackUsingTwoQueuesEasy.MyStack();

        // Test push operation
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test pop and top operations
        System.out.println("Top element: " + stack.top()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Top element: " + stack.top()); // Should print 2

        // Test empty operation
        System.out.println("Is the stack empty? " + stack.empty()); // Should print false

        // Pop remaining elements
        System.out.println("Popped element: " + stack.pop()); // Should print 2
        System.out.println("Popped element: " + stack.pop()); // Should print 1

        // Test empty operation after popping all elements
        System.out.println("Is the stack empty? " + stack.empty()); // Should print true
    }

}