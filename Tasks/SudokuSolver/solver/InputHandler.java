package SudokuSolver.solver;

import SudokuSolver.solver.SudokuGrid;
import java.util.Scanner;

public class InputHandler {
    public static SudokuGrid readSudokuGrid(Scanner sc, int size) {
        SudokuGrid grid = new SudokuGrid(size);
        System.out.println("Enter the Sudoku grid row by row. Use 0 for blank spaces:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid.setElement(i, j, sc.nextInt());
            }
        }
        return grid;
    }
}