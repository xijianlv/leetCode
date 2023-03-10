package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No12 {

    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] thousands = {"", "M", "MM", "MMM"};

    public String intToRoman(int num) {

        StringBuilder res = new StringBuilder();
        res.append(thousands[num / 1000]);
        res.append(hundreds[(num % 1000) / 100]);
        res.append(tens[(num % 100) / 10]);
        res.append(ones[num % 10]);
        return res.toString();
    }
}
