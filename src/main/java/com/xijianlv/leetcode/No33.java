package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No33 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        search(nums, target);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                //有序队列在前半段
                if (nums[0] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //有序队列在后半段
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
