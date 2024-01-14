package com.bhupendra.prep2023.linkedList;

/**
 * Author: Bhupendra Shekhawat
 * Date: 06/11/23
 * Topic: com.prep2023.linkedList
 * Question : <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _4_DeleteDuplicates_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;

        ListNode sentinal = new ListNode(Integer.MIN_VALUE);
        sentinal.next = head;

        ListNode prev = sentinal;
        ListNode cur  = sentinal.next;

        boolean foundDuplicate = false;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                foundDuplicate = true;
                //found 1 duplicate, keep skipping all the duplicate of cur num
                while(cur.next != null && cur.val == cur.next.val){
                    cur.next = cur.next.next;
                }
                //remove this cur node as well
                prev.next = cur.next;
            }
            else{
                prev = cur;
            }
            cur = cur.next;
        }
        return sentinal.next;
    }
}


