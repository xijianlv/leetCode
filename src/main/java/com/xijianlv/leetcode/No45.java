package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        jump(nums);
    }


    public static int jump(int[] nums) {
        int step = 0;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }


    // public static int step;
    //
    // public static int jump(int[] nums) {
    //     step = 0;
    //     findMaxCanJump(nums, nums.length - 1);
    //     return step;
    // }
    //
    // public static void findMaxCanJump(int[] nums, int endIndex) {
    //     if (endIndex <= 0) {
    //         return;
    //     }
    //     int index = endIndex - 1;
    //     for (int i = endIndex - 1; i >= 0; i--) {
    //         if (nums[i] >= endIndex - i) {
    //             index = i;
    //         }
    //     }
    //     step++;
    //     findMaxCanJump(nums, index);
    // }

}
