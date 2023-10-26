package com.prep2023.stackAndQueues;

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

 Easy

 Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

 Implement the MyStack class:

 void push(int x) Pushes element x to the top of the stack.
 int pop() Removes the element on the top of the stack and returns it.
 int top() Returns the element on the top of the stack.
 boolean empty() Returns true if the stack is empty, false otherwise.
 Notes:

 You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.


 Example 1:

 Input
 ["MyStack", "push", "push", "top", "pop", "empty"]
 [[], [1], [2], [], [], []]
 Output
 [null, null, null, 2, 2, false]

 Explanation
 MyStack myStack = new MyStack();
 myStack.push(1);
 myStack.push(2);
 myStack.top(); // return 2
 myStack.pop(); // return 2
 myStack.empty(); // return False


 Constraints:

 1 <= x <= 9
 At most 100 calls will be made to push, pop, top, and empty.
 All the calls to pop and top are valid.


 Follow-up: Can you implement the stack using only one queue?
 */

public class _1ImplementStackUsingTwoQueuesEasy {

    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.offer(x);
        }

        public int pop() {
            if(q1.isEmpty())return -1;

            while(q1.size() >1){
                q2.offer(q1.poll());
            }
            int result = q1.poll();
            //swap q1 and q2
            swap();
            return result;
        }

        public int top() {
            if(q1.isEmpty())return -1;

            while(q1.size() >1){
                q2.offer(q1.poll());
            }
            int result = q1.remove();
            q2.offer(result);

            //swap q1 and q2
            swap();

            return result;
        }

        private void swap(){
            Queue<Integer> temp =q1;
            q1 = q2;
            q2 = temp;
        }

        public boolean empty() {
            return q1.size() ==0;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

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
