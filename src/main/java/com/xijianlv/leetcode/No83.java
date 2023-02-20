package com.xijianlv.leetcode;

import com.xijianlv.leetcode.tool.ListNode;

/**
 * @author xijianlv
 */
public class No83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
