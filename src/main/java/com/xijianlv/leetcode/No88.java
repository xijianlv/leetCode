package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        int temp;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                temp = nums2[p2--];
            } else if (p2 == -1) {
                temp = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                temp = nums1[p1--];
            } else {
                temp = nums2[p2--];
            }
            nums1[index--] = temp;
        }
    }
}
