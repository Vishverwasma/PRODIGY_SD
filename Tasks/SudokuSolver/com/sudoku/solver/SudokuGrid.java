package SudokuSolver.com.sudoku.solver;

public class SudokuGrid {
    private int[][] grid;

    public SudokuGrid(int n) {
        grid = new int[n][n];
    }

    public int getElement(int row, int col) {
        return grid[row][col];
    }

    public void setElement(int row, int col, int value) {
        grid[row][col] = value;
    }

    public int getSize() {
        return grid.length;
    }

    // Add other necessary methods
}
