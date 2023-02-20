package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xijianlv
 */
public class No40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        combinationSum2(candidates, 8);
    }

    public static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<>(), 0);
        System.out.println(res);
        return res;
    }

    public static void backTrack(int[] candidates, int index, int target, List<Integer> ans, int sumFromAns) {
        if (target == sumFromAns) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sumFromAns + candidates[i] > target) {
                return;
            }
            ans.add(candidates[i]);
            sumFromAns = sumFromAns + candidates[i];
            backTrack(candidates, i + 1, target, ans, sumFromAns);
            ans.remove(ans.size() - 1);
            sumFromAns = sumFromAns - candidates[i];
        }
    }
}
