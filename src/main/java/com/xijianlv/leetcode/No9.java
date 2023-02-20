package com.xijianlv.leetcode;

/**
 * 回文数
 * @author xijianlv
 */
public class No9 {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        String str = Integer.toString(x);
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
