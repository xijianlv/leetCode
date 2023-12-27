package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No93 {
    public static void main(String[] args) {
        String str = "0000";
        restoreIpAddresses(str);
    }

    public static List<String> res;

    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() <= 3) {
            return res;
        }
        if (s.length() == 4) {
            res.add(s.charAt(0) + "." + s.charAt(1) + "." + s.charAt(2) + "." + s.charAt(3));
            return res;
        }
        LinkedList<String> ans = new LinkedList<>();
        backTrack(s, ans, 0, 0);
        return res;
    }


    public static void backTrack(String str, LinkedList<String> ans, Integer index, Integer id) {
        if (ans.size() == 4) {
            //找到四段，返回
            if (index == str.length()) {
                //且使用完了字符传，记录答案
                res.add(ans.get(0) + "." + ans.get(1) + "." + ans.get(2) + "." + ans.get(3));
            }
            return;
        }

        if (index == str.length()) {
            //还没有找到四段，字符串提前遍历完了
            return;
        }

        if (str.charAt(index) == '0') {
            ans.add(String.valueOf(str.charAt(index)));
            backTrack(str, ans, index + 1, id + 1);
        }

        //一般情况
        StringBuilder strTmp = new StringBuilder();
        for (int i = index; i < str.length(); ++i) {
            strTmp.append(str.charAt(i));
            int num = Integer.parseInt(strTmp.toString());
            if (num > 0 && num <= 255) {
                ans.add(strTmp.toString());
                backTrack(str, ans, i + 1, id + 1);
                ans.removeLast();
            } else {
                break;
            }
        }
    }

}
