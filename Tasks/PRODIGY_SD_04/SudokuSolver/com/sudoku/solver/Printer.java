package SudokuSolver.com.sudoku.solver;

import SudokuSolver.com.sudoku.solver.SudokuGrid;

public class Printer {
    public static void printGrid(SudokuGrid grid) {
        int size = grid.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid.getElement(i, j) + " ");
            }
            System.out.println();
        }
    }
}
