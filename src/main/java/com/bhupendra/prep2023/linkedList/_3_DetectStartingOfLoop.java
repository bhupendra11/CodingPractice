package com.bhupendra.prep2023.linkedList;

/**
 * Author: Bhupendra Shekhawat
 * Date: 04/11/23
 * Topic: com.prep2023.linkedList
 * Question : <a href="https://leetcode.com/problems/linked-list-cycle-ii/">142. Linked List Cycle II</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_DetectStartingOfLoop {
    public ListNode detectCycle(ListNode head) {
        //if no cycle return null, else return start of cycle
        if(head == null || head.next == null)return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }

        if(!isCycle)return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
