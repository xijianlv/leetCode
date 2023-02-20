package com.xijianlv.leetcode;


import com.xijianlv.leetcode.tool.ListNode;

/**
 * @author xijianlv
 */
public class No23 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);


        ListNode b = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        a.next = new ListNode(6);
        a.next.next = new ListNode(5);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = a;
        listNodes[1] = b;
        listNodes[2] = c;

        No23 p = new No23();

        ListNode listNode = p.mergeKLists(listNodes);

        System.out.println(listNode);


    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int tmp = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, tmp), merge(lists, tmp + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode ans = new ListNode(0);
        ListNode aPoint = a;
        ListNode bPoint = b;
        ListNode p = ans;
        while (aPoint != null && bPoint != null) {
            if (aPoint.val > bPoint.val) {
                p.next = bPoint;
                bPoint = bPoint.next;
            } else {
                p.next = aPoint;
                aPoint = aPoint.next;
            }
            p = p.next;
        }
        p.next = (aPoint != null ? aPoint : bPoint);
        return ans.next;
    }

}
