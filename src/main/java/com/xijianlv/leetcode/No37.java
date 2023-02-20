package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No37 {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }

    public static int n = 9;

    public static void solveSudoku(char[][] board) {
        backTrack(board, 0, 0, false);
    }

    public static boolean backTrack(char[][] board, int row, int col, boolean flag) {
        if (col == n) {
            col = 0;
            row++;
            if (row == n) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int k = 1; k <= n; k++) {
                if (!isValid(board, row, col, k)) {
                    continue;
                }
                board[row][col] = (char) (k + '0');
                flag = backTrack(board, row, col + 1, flag);
                if (flag) {
                    return flag;
                }
                board[row][col] = '.';
            }
        } else {
            flag = backTrack(board, row, col + 1, flag);
        }
        return flag;
    }


    public static boolean isValid(char[][] board, int row, int col, int num) {
        //行冲突
        for (int i = 0; i < n; i++) {
            if (board[row][i] == '0' + num) {
                return false;
            }
        }
        //列冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == '0' + num) {
                return false;
            }
        }
        //3*3范围冲突
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (board[i][j] == '0' + num) {
                    return false;
                }
            }
        }
        return true;
    }
}
