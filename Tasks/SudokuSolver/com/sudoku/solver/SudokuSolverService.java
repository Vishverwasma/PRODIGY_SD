package SudokuSolver.com.sudoku.solver;

import SudokuSolver.com.sudoku.solver.SudokuGrid;

public class SudokuSolverService {

    public boolean solve(SudokuGrid grid) {
        int n = grid.getSize();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.getElement(r, c) == 0) {
                    for (int num = 1; num <= n; num++) {
                        if (isValid(grid, r, c, num)) {
                            grid.setElement(r, c, num);
                            if (solve(grid)) {
                                return true;
                            }
                            grid.setElement(r, c, 0); // Backtrack
                        }
                    }
                    return false; // Trigger backtracking
                }
            }
        }
        return true; // Solved
    }

    private boolean isValid(SudokuGrid grid, int r, int c, int num) {
        int n = grid.getSize();
        int sqrt = (int) Math.sqrt(n);

        for (int i = 0; i < n; i++) {
            if (grid.getElement(r, i) == num || grid.getElement(i, c) == num) {
                return false;
            }
        }

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
