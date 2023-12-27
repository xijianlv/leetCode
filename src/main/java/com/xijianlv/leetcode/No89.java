package com.xijianlv.leetcode;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
=======
import java.util.*;
>>>>>>> 0ddb2c38007b363895acb7a27115e4a380abd6fb

/**
 * @author xijianlv
 */
public class No89 {

    public static void main(String[] args) {
<<<<<<< HEAD
        grayCode(5);
=======
        grayCode(3);
>>>>>>> 0ddb2c38007b363895acb7a27115e4a380abd6fb
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(ans.get(j) | (1 << i));
            }
        }
        return ans;
    }

<<<<<<< HEAD
    // public static Set<Integer> flags;
    // public static List<Integer> ans;
    //
    // public static List<Integer> grayCode1(int n) {
    //     flags = new HashSet<>();
    //     ans = new ArrayList<>();
    //     flags.add(0);
    //     ans.add(0);
    //     int n2 = 2 << (n - 1);
    //     backTrack(n2, n);
    //     return ans;
    // }
    //
    // public static void backTrack(int n2, int n) {
    //     if (ans.size() == n2) {
    //         return;
    //     }
    //     int bit = 1;
    //     for (int i = 0; i < n; ++i) {
    //         if (i != 0) {
    //             bit = bit << 1;
    //         }
    //         int next = ans.get(ans.size() - 1) ^ bit;
    //         if (flags.contains(next)) {
    //             continue;
    //         }
    //         ans.add(next);
    //         flags.add(next);
    //         backTrack(n2, n);
    //         if (ans.size() == n2) {
    //             return;
    //         }
    //         ans.remove(ans.size() - 1);
    //         flags.remove(next);
    //     }
    // }
=======
//    public static Set<Integer> flags;
//    public static List<Integer> ans;
//
//    public static List<Integer> grayCode(int n) {
//        flags = new HashSet<>();
//        ans = new ArrayList<>();
//        flags.add(0);
//        ans.add(0);
//        int n2 = 2 << (n - 1);
//        backTrack(n2, n);
//        return ans;
//    }
//
//    public static void backTrack(int n2, int n) {
//        if (ans.size() == n2) {
//            return;
//        }
//        int bit = 1;
//        for (int i = 0; i < n; ++i) {
//            if (i != 0) {
//                bit = bit << 1;
//            }
//            int next = ans.get(ans.size() - 1) ^ bit;
//            if (flags.contains(next)) {
//                continue;
//            }
//            ans.add(next);
//            flags.add(next);
//            backTrack(n2, n);
//            if (ans.size() == n2) {
//                return;
//            }
//            ans.remove(ans.size() - 1);
//            flags.remove(next);
//
//        }
//    }

>>>>>>> 0ddb2c38007b363895acb7a27115e4a380abd6fb
}
