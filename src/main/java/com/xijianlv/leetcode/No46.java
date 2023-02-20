package com.xijianlv.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No46 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track, res);
        return res;
    }

    public static void backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track, res);
            track.removeLast();
        }
    }
}
