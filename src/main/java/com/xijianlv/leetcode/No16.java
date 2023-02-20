package com.xijianlv.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author xijianlv
 */
public class No16 {
    public static void main(String[] args) {
        int[] nums = {1, 1, -1, -1, 3};
        System.out.println(threeSumClosest(nums, -1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        int l = 1;
        int r = len - 1;
        int res = 100000;
        while (i < len) {
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp - target < 0) {
                    l++;
                } else {
                    r--;
                }
                if (Math.abs(tmp - target) < Math.abs(res - target)) {
                    res = tmp;
                }
            }
            i++;
            l = i + 1;
            r = len - 1;
        }
        return res;
    }
}
