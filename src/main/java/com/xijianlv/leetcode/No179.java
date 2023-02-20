package com.xijianlv.leetcode;

import java.util.Arrays;

/**
 * @author xijianlv
 */
public class No179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];

        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (str1, str2) -> {
            return (str2 + str1).compareTo(str1 + str2);
        });
        String ans = "";
        for (int i = 0; i < len; i++) {
            ans = ans + strs[i];
        }
        return ans.charAt(0) == '0' ? "0" : ans;
    }
}
