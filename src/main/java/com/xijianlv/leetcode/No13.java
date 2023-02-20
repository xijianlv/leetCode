package com.xijianlv.leetcode;

/**
 * 罗马数字转整数
 * @author xijianlv
 */
public class No13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == 'M') {
                res = res + 1000;
                i++;
            } else if (s.charAt(i) == 'C' && i + 1 < len && s.charAt(i + 1) == 'M') {
                res = res + 900;
                i = i + 2;
            } else if (s.charAt(i) == 'D') {
                res = res + 500;
                i++;
            } else if (s.charAt(i) == 'C' && i + 1 < len && s.charAt(i + 1) == 'D') {
                res = res + 400;
                i = i + 2;
            } else if (s.charAt(i) == 'C') {
                res = res + 100;
                i++;
            } else if (s.charAt(i) == 'X' && i + 1 < len && s.charAt(i + 1) == 'C') {
                res = res + 90;
                i = i + 2;
            } else if (s.charAt(i) == 'L') {
                res = res + 50;
                i++;
            } else if (s.charAt(i) == 'X' && i + 1 < len && s.charAt(i + 1) == 'L') {
                res = res + 40;
                i = i + 2;
            } else if (s.charAt(i) == 'X') {
                res = res + 10;
                i++;
            } else if (s.charAt(i) == 'I' && i + 1 < len && s.charAt(i + 1) == 'X') {
                res = res + 9;
                i = i + 2;
            } else if (s.charAt(i) == 'V') {
                res = res + 5;
                i++;
            } else if (s.charAt(i) == 'I' && i + 1 < len && s.charAt(i + 1) == 'V') {
                res = res + 4;
                i = i + 2;
            } else if (s.charAt(i) == 'I') {
                res = res + 1;
                i++;
            }
        }
        return res;
    }
}
