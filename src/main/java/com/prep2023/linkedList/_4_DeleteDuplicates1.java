package com.prep2023.linkedList;

/**
 * Author: Bhupendra Shekhawat
 * Date: 06/11/23
 * Topic: com.prep2023.linkedList
 * Question : <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _4_DeleteDuplicates1 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;

        ListNode cur = head.next;

        ListNode prev = head;

        while(cur != null){
            if(cur.val == prev.val){
                prev.next = cur.next;
            }
            else{
                prev = cur;
            }
            cur = cur.next;
        }

        return head;

    }
}

