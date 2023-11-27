package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: java_algo
 * @description: Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:  Each row must contain the digits 1-9 without repetition. Each column must contain the digits 1-9 without repetition. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition. Note:  A Sudoku board (partially filled) could be valid but is not necessarily solvable. Only the filled cells need to be validated according to the mentioned rules.
 * @author: Ze QIN
 * @create: 2023-09-24 19:21
 **/
public class ValidSudoku2 {

    public boolean isValidSudoku(List<List<Integer>> sudoku) {
        Set numbers = new HashSet();
        int l = sudoku.size();

        for (int i = 0; i< 9; i++) {
            for (int j = 0; j< 9; j++) {
                int current_val = sudoku.get(i).get(j);
                if (current_val != 0) {
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

        List lign1 = Arrays.asList(1,3,0,0,7,0,0,0,0);
        List lign2 = Arrays.asList(6,0,0,1,9,5,0,0,0);
        List lign3 = Arrays.asList(0,9,8,0,0,0,0,6,0);
        List lign4 = Arrays.asList(8,0,0,0,6,0,0,0,3);
        List lign5 = Arrays.asList(4,0,0,8,0,3,0,0,1);
        List lign6 = Arrays.asList(7,0,0,0,2,0,0,0,6);
        List lign7 = Arrays.asList(0,6,0,0,0,0,2,8,0);
        List lign8 = Arrays.asList(0,0,0,4,1,9,0,0,5);
        List lign9 = Arrays.asList(0,0,0,0,8,0,0,7,9);

        List<List<Integer>> sudoku = Arrays.asList(lign1, lign2, lign3, lign4, lign5, lign6, lign7, lign8, lign9);

        ValidSudoku2 validSudoku = new ValidSudoku2();
        System.out.println(validSudoku.isValidSudoku(sudoku));
    }
}
