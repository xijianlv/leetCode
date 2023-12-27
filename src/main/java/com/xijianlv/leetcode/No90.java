package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        subsetsWithDup(nums);
    }

    public static List<List<Integer>> res;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        backTrack(0,nums,ans);
        System.out.println(res);
        return res;
    }

    public static void backTrack(int index, int[] nums, LinkedList<Integer> ans) {
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            ans.add(nums[i]);
            backTrack(i + 1, nums, ans);
            ans.removeLast();
        }
        res.add(new ArrayList<>(ans));
    }

}
