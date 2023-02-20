package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No67 {
    public String addBinary(String a, String b) {
        String res = "";
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        int temp = 0;
        while (indexB >= 0 || indexA >= 0) {
            if (indexA == -1) {
                temp = b.charAt(indexB--) - '0';
            } else if (indexB == -1) {
                temp = a.charAt(indexA--) - '0';
            } else {
                temp = a.charAt(indexA--) - '0';
                temp = temp + b.charAt(indexB--) - '0';
            }
            temp = temp + carry;
            carry = temp / 2;
            res = (temp % 2) + res;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }
}
