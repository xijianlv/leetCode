package com.xijianlv.leetcode;

import com.xijianlv.leetcode.tool.ListNode;

/**
 * @author xijianlv
 */
public class No24 {

    public static void main(String[] args) {
        ListNode no1 = new ListNode(1);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(3);
        ListNode no4 = new ListNode(4);
        no1.next = no2;
        no2.next = no3;
        no3.next = no4;
        no4.next = null;
        swapPairs(no1);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode();
        res.next = head;
        ListNode temp = res;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = node1.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return res.next;
    }
}
