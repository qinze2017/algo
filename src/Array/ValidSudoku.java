package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: java_algo
 * @description: Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:  Each row must contain the digits 1-9 without repetition. Each column must contain the digits 1-9 without repetition. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition. Note:  A Sudoku board (partially filled) could be valid but is not necessarily solvable. Only the filled cells need to be validated according to the mentioned rules.
 * @author: Ze QIN
 * @create: 2023-09-24 19:21
 **/
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set numbers = new HashSet();
        int l = board.length;

        for (int i = 0; i< 9; i++) {
            for (int j = 0; j< 9; j++) {
                char current_val = board[i][j];
                if (current_val != '.') {
                    if (!numbers.add(current_val + " found in row " + i) ||
                    ! numbers.add(current_val + " found in column " + j) ||
                    ! numbers.add(current_val + " found in sub box " + i/3 + "." + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'1','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
