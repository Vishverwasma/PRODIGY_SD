package SudokuSolver.com.sudoku.solver;

import SudokuSolver.com.sudoku.solver.SudokuGrid;

public class Validator {
    public static boolean isValid(SudokuGrid grid, int r, int c, int num) {
        int n = grid.getSize();
        int sqrt = (int) Math.sqrt(n);

        // Check rows
        for (int i = 0; i < n; i++) {
            if (grid.getElement(r, i) == num) {
                return false;
            }
        }

        // Check columns
        for (int i = 0; i < n; i++) {
            if (grid.getElement(i, c) == num) {
                return false;
            }
        }

        // Check sub-grids
        int boxRowStart = r - r % sqrt;
        int boxColStart = c - c % sqrt;
        for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
            for (int j = boxColStart; j < boxColStart + sqrt; j++) {
                if (grid.getElement(i, j) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
