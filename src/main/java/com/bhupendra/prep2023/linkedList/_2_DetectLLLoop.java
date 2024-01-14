package com.bhupendra.prep2023.linkedList;

/**
 * Author: Bhupendra Shekhawat
 * Date: 04/11/23
 * Topic: com.prep2023.linkedList
 * Question : <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _2_DetectLLLoop {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)return true;
        }
        return false;

    }
}
