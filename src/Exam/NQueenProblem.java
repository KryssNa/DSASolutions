package Exam;

public class NQueenProblem {

    private static int N; // Size of the chessboard

    // Function to check if a queen can be placed in a given cell
    private static boolean isSafe(int[][] board, int row, int col) {
        // Check left side of the row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve the N-Queen problem using backtracking
    private static boolean solveNQueens(int[][] board, int col) {
        // Base case: All queens are placed
        if (col == N) {
            return true;
        }

        // Try placing the queen in each row of the current column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                // Recur to place rest of the queens
                if (solveNQueens(board, col + 1)) {
                    return true;
                }

                // If placing the queen at board[i][col] doesn't lead to a solution,
                // then remove the queen from board[i][col]
                board[i][col] = 0;
            }
        }

        // If a queen cannot be placed in any row of the current column, return false
        return false;
    }

    // Function to print the board
    private static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        N = 4; // Size of the chessboard

        int[][] board = new int[N][N];

        if (solveNQueens(board, 0)) {
            System.out.println("Solution found:");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }
    }
}
