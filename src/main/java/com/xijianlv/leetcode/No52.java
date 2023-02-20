package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No52 {
    public static void main(String[] args) {
        Integer res = totalNQueens(5);
    }

    public static Integer res;

    public static int totalNQueens(int n) {
        res = 0;
        List<char[]> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            temp.add(row);
        }
        backTrack(temp, 0);
        return res;
    }

    public static void backTrack(List<char[]> temp, int row) {
        if (temp.size() == row) {
            List<String> resTemp = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                resTemp.add(String.valueOf(temp.get(i)));
            }
            res++;
            return;
        }
        int n = temp.get(row).length;
        for (int col = 0; col < n; col++) {
            if (!isValid(temp, row, col)) {
                continue;
            }
            temp.get(row)[col] = 'Q';
            backTrack(temp, row + 1);
            temp.get(row)[col] = '.';
        }
    }

    public static boolean isValid(List<char[]> temp, int row, int col) {
        //左上角有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (temp.get(i)[j] == 'Q') {
                return false;
            }
        }
        //右上角有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < temp.get(i).length; i--, j++) {
            if (temp.get(i)[j] == 'Q') {
                return false;
            }
        }
        //当前列有冲突
        for (int i = 0; i < row; i++) {
            if (temp.get(i)[col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
