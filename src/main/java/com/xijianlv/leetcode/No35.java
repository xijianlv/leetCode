package com.xijianlv.leetcode;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">35. 搜索插入位置</a>
 * <a href="https://leetcode.cn/problems/N6YdxV/">剑指 Offer II 068. 查找插入位置</a>
 * @author xijianlv
 */
public class No35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
