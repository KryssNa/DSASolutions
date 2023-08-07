package Sorting;

public class bucketSort {
    //implement bucket sort


    static void bucketSort(int[] arr, int n, int max) {
        int[] bucket = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j <= max; j++) {
            while (bucket[j] > 0) {
                arr[i++] = j;
                bucket[j]--;
            }
        }
    }
}
