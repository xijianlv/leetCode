package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No36 {
    public static void main(String[] args) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] box = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                if (row[i][index] != 0 || col[j][index] != 0 || box[i / 3][j / 3][index] != 0) {
                    return false;
                } else {
                    row[i][index]++;
                    col[j][index]++;
                    box[i / 3][j / 3][index]++;
                }
            }
        }
        return true;
    }
}
