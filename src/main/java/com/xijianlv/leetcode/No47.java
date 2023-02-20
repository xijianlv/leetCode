package com.xijianlv.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 和46题相比，backTrack() 需要考虑去重的机制
 * 条件是(i > 0 && nums[i] == nums[i - 1] && !flags[i - 1])
 * 数值是排序过的，从第二个元素开始，如果当前元素和上一个元素相同，则说明在选用该元素会和前面已经出现的组合重复,所以需要i > 0 && nums[i] == nums[i - 1]
 * flags[i-1]必须为false。
 * 如果是true，说明当前元素现在是用来在决策树的和前一个元素下一层的节点，所以可以使用，
 * 如果是false，说明当前元素是用来在决策树的和前一个元素同层的节点，所以会导致重复，所以需要continue
 *
 * @author xijianlv
 */
public class No47 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, flags, track, res);
        return res;
    }


    public static void backTrack(int[] nums, boolean[] flags, LinkedList<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i] || (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1])) {
                continue;
            }
            track.add(nums[i]);
            flags[i] = true;
            backTrack(nums, flags, track, res);
            track.removeLast();
            flags[i] = false;
        }
    }
}
