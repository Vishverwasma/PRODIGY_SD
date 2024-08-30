package SudokuSolver.solver;

import SudokuSolver.solver.SudokuGrid;
import SudokuSolver.solver.SudokuSolverService;
import SudokuSolver.solver.InputHandler;
import SudokuSolver.solver.Printer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of elements: ");
        int n = sc.nextInt();

        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n) {
            System.out.println("Invalid Sudoku size. The size must be a perfect square.");
            return;
        }

        SudokuGrid grid = InputHandler.readSudokuGrid(sc, n);
        SudokuSolverService solver = new SudokuSolverService();

        if (solver.solve(grid)) {
            System.out.println("Solved:");
            Printer.printGrid(grid);
        } else {
            System.out.println("No Solution Possible for This Sudoku, I guess!");
        }
    }
}
