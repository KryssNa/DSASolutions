package Exam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        // Create a fixed thread pool with the number of available processors
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Perform multithreaded merge sort on the array
        mergeSort(arr, 0, arr.length - 1, executor);

        // Shut down the executor and wait until all tasks are completed
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] arr, int left, int right, ExecutorService executor) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Create tasks for the left and right halves and submit them to the executor
            executor.submit(() -> mergeSort(arr, left, mid, executor)); // Left half
            executor.submit(() -> mergeSort(arr, mid + 1, right, executor)); // Right half

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays for the left and right halves
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }


        // Merge the temporary arrays back into the original array
        int i = 0; // Index for the left array
        int j = 0; // Index for the right array
        int k = left; // Index for the merged array

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of the left array, if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of the right array, if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9, 4,3 };

        System.out.println("Original Array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
