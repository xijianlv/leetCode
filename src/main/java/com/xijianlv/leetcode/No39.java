package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xijianlv
 */
public class No39 {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        combinationSum(candidates, 1);
    }

    public static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>(), 0);
        System.out.println(res);
        return res;
    }

    public static void backTrack(int[] candidates, int target, int index, List<Integer> ans, int sumFromAns) {
        if (sumFromAns == target) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sumFromAns + candidates[i] > target) {
                return;
            }
            ans.add(candidates[i]);
            sumFromAns = sumFromAns + candidates[i];
            backTrack(candidates, target, i, ans, sumFromAns);
            ans.remove(ans.size() - 1);
            sumFromAns = sumFromAns - candidates[i];
        }
    }

}
