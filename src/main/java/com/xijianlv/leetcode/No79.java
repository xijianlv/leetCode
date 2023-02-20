package com.xijianlv.leetcode;

import java.util.Objects;

public class No79 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'A'}
        };
        String word = "AAA";
        boolean xxx = exist(board, word);
        System.out.println();
    }

    public static boolean[][] signed;

    /**
     * 0->未发现，1->已识别到
     */
    public static Integer res;
    public static StringBuilder tmp;


    /**
     * 遍历的四个方向，依次是左、上、右、下
     */
    public static Integer[] rows = {0, -1, 0, 1};
    public static Integer[] cols = {-1, 0, 1, 0};

    public static boolean exist(char[][] board, String word) {
        res = 0;
        tmp = new StringBuilder();
        signed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (signed[i][j] || board[i][j] != word.charAt(0)) {
                    continue;
                }
                tmp.append(board[i][j]);
                signed[i][j] = true;
                backTrack(board, word, 1, i, j);
                if (res == 1) {
                    return true;
                }
                tmp.delete(0, 1);
                signed[i][j] = false;
            }
        }
        return false;
    }

    public static void backTrack(char[][] board, String word, int index, int row, int col) {
        if (res == 1 || Objects.equals(word, tmp.toString())) {
            res = 1;
            return;
        }

        for (int k = 0; k < cols.length; k++) {
            int _row = rows[k] + row;
            int _col = cols[k] + col;
            if (_col < 0 || _col >= board[0].length || _row < 0 || _row >= board.length ||
                    signed[_row][_col] || word.charAt(index) != board[_row][_col]) {
                //非法搜索范围或者已经使用过或者字符不匹配
                continue;
            }
            tmp.append(board[_row][_col]);
            signed[_row][_col] = true;
            backTrack(board, word, index + 1, _row, _col);
            if (res == 1) {
                return;
            }
            signed[_row][_col] = false;
            tmp.delete(tmp.length() - 1, tmp.length());
        }
    }
}
