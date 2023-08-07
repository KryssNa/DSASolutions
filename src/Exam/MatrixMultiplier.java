package Exam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplier {
    // Get the number of available processors
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    // Define a nested class to represent the matrix multiplication task
    private static class MatrixMultiplierTask implements Runnable {
        private final int[][] result;     // Result matrix
        private final int[][] matrix1;    // Input matrix 1
        private final int[][] matrix2;    // Input matrix 2
        private final int row;            // Starting row index
        private final int col;            // Starting column index
        private final int size;           // Size of the sub-matrix

        // Constructor to initialize the task
        public MatrixMultiplierTask(int[][] result, int[][] matrix1, int[][] matrix2, int row, int col, int size) {
            this.result = result;
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.row = row;
            this.col = col;
            this.size = size;
        }

        // Run method to perform the matrix multiplication
        @Override
        public void run() {
            // Compute the matrix multiplication for the assigned portion
            int endRow = row + size;
            int endCol = col + size;
            for (int i = row; i < endRow; i++) {
                for (int j = col; j < endCol; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }
    }

    // Method to perform matrix multiplication using multithreading
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        // Check if the matrices are compatible for multiplication
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrices are not compatible for multiplication");

        }
        int size = matrix1.length;
        int[][] result = new int[size][size];

        // Create a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Determine the block size to divide the matrix computation equally among threads
        int blockSize = (int) Math.ceil((double) size / NUM_THREADS);

        // Divide the matrix multiplication task into smaller tasks and assign to threads
        for (int row = 0; row < size; row += blockSize) {
            for (int col = 0; col < size; col += blockSize) {
                executor.execute(new MatrixMultiplierTask(result, matrix1, matrix2, row, col, blockSize));
            }
        }

        // Shut down the executor and wait until all tasks are completed
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Main method to test the matrix multiplication
    public static void main(String[] args) {
        // Input matrices
        int matrix1[][]={{1,2,3},{4,5,6},{7,8,9}};
        int matrix2[][]={{1,2,3},{4,5,6},{7,8,9}};

        // Perform matrix multiplication
        int[][] result = multiply(matrix1, matrix2);

        // Print the result
        System.out.println("Matrix multiplication result:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
