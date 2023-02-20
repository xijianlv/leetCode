package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No77 {

    public static void main(String[] args) {
        combine(1, 1);
    }

    public static List<List<Integer>> res;

    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        backTrack(n, k, 1, ans);
        return res;
    }

    public static void backTrack(int n, int k, int index, LinkedList<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        //i<=n 换成 n - (k - ans.size()) 剪枝
        for (int i = index; i <= n - (k - ans.size()) + 1; i++) {
            if (ans.contains(i)) {
                continue;
            }
            ans.add(i);
            backTrack(n, k, i + 1, ans);
            ans.removeLast();
        }
    }

}
