package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No60 {

    public static void main(String[] args) {
        String s = getPermutation(3, 4);
        System.out.println(s);
    }

    public static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362800};

    public static String getPermutation(int n, int k) {
        List<String> nums = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            nums.add(String.valueOf(i));
        }
        k = k - 1;
        for (int i = n; i > 0; i--) {
            int tmp = k / factorial[i - 1];
            res.append(nums.get(tmp));
            nums.remove(tmp);
            k = k % factorial[i - 1];

        }
        return res.toString();
    }


    // public static String getPermutation(int n, int k) {
    //     StringBuilder res = new StringBuilder();
    //     backTrack(n, k, res);
    //     return res.toString();
    // }
    //
    // public static void backTrack(int n, int k, StringBuilder res) {
    //     if (res.length() == n) {
    //         return;
    //     }
    //     int count = factorial[n - 1 - res.length()];
    //     for (int i = 0; i < n; i++) {
    //         if (res.toString().contains(String.valueOf(i + 1))) {
    //             continue;
    //         }
    //         if (count < k) {
    //             k = k - count;
    //             continue;
    //         }
    //         res.append(i + 1);
    //         backTrack(n, k, res);
    //         //这里不需要回溯，只需要找到指定一个叶子节点
    //         return;
    //     }
    // }


}
