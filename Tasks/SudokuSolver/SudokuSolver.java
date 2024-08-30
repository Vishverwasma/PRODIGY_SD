package PrdoigyInfotech;

import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of elements : ");
        int n = sc.nextInt();
        int sqrt = (int)Math.sqrt(n);

        if(sqrt*sqrt!=n){
            System.out.println("Invalid Sudoku size. The size must be a perfect square (e.g., 4, 9, 16). Exiting.");
            sc.close();
            return;
        }

            int [][]sudoku = new int[n][n];
            System.out.println("Enter the Sudoku grid row by row. Use 0 for blank spaces:");
            valuesInSudoku(sudoku, n);

            if(solveSudoku(sudoku,n)){
                System.out.println("Solved : ");
                printSudoku(sudoku ,n );

            } else {
                System.out.println("No Solution Possible for This Sudoku , i guess!");
            }
            sc.close();
    }
    public static void valuesInSudoku(int[][] sudoku,int elements){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < elements; i++) {
            for (int j = 0; j < elements; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
    }
    public static boolean solveSudoku(int[][] sudoku,int n){
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){
                if(sudoku[r][c] == 0){
                    for(int num = 1 ; num <= n ; num++){
                        if(isValid(sudoku, r ,c ,n ,num)){
                            sudoku[r][c] = num;
                            if(solveSudoku(sudoku ,n)){
                                return true;
                            }
                            sudoku[r][c] = 0;
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // Puzzle Solved
    }
    public static boolean isValid(int[][]sudoku,int r,int c,int n,int num){
        int sqrt = (int)Math.sqrt(n);
        // Checking rows
        for(int i=0;i<n;i++){
            if(sudoku[r][i]==num){
                return false;
            }
        }
        //Checking Columns
        for(int i=0;i<n;i++){
            if(sudoku[i][c] == num){
                return false;
            }
        }
        // To Check Sub-Grids
        int boxRowStart = r - r % sqrt;
        int boxColStart = c - c % sqrt;
        for(int i = boxRowStart;i<boxRowStart + sqrt ; i++){
            for(int j=boxColStart;j<boxColStart + sqrt ; j++){
                if(sudoku[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void printSudoku(int[][] sudoku, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

}
