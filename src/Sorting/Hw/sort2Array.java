package Sorting.Hw;

import java.util.Arrays;

public class sort2Array {
    // sorting two arrays A and B on the basis of A using merge sort

        public static void sortToArray(int[] A, int[] B, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                sortToArray(A, B, start, mid);
                sortToArray(A, B, mid + 1, end);
                merge(A, B, start, mid, end);
            }
        }

        public static void merge(int[] A, int[] B, int start, int mid, int end) {
            int n1 = mid - start + 1;
            int n2 = end - mid;

            int[] leftA = new int[n1];
            int[] leftB = new int[n1];
            int[] rightA = new int[n2];
            int[] rightB = new int[n2];

            // Copy elements to temporary arrays
            for (int i = 0; i < n1; i++) {
                leftA[i] = A[start + i];
                leftB[i] = B[start + i];
            }

            for (int j = 0; j < n2; j++) {
                rightA[j] = A[mid + 1 + j];
                rightB[j] = B[mid + 1 + j];
            }

            // Merge the temporary arrays back into A and B
            int i = 0, j = 0, k = start;
            while (i < n1 && j < n2) {
                if (leftA[i] <= rightA[j]) {
                    A[k] = leftA[i];
                    B[k] = leftB[i];
                    i++;
                } else {
                    A[k] = rightA[j];
                    B[k] = rightB[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements if any
            while (i < n1) {
                A[k] = leftA[i];
                B[k] = leftB[i];
                i++;
                k++;
            }

            while (j < n2) {
                A[k] = rightA[j];
                B[k] = rightB[j];
                j++;
                k++;
            }
        }

    public static void main(String[] args) {
        int[] A = {5, 2, 1, 3, 6, 4};
        int[] B = {10, 20, 30, 40, 50, 60};

        sortToArray(A, B, 0, A.length - 1);

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }


}
