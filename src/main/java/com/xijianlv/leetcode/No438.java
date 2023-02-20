package com.xijianlv.leetcode;

import java.util.*;

/**
 * @author xijianlv
 */
public class No438 {

    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> res = new ArrayList<>();
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 < len1) {
            return res;
        }
        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for (int i = 0; i < len1; i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(array1, array2)) {
            res.add(0);
        }

        for (int i = len1; i < len2; i++) {
            array2[s2.charAt(i) - 'a']++;
            array2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(array1, array2)) {
                res.add(i - len1 + 1);
            }
        }
        return res;
    }
}
