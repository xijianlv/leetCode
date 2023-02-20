package com.xijianlv.leetcode;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * @author xijianlv
 */
public class No3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
