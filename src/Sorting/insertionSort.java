package Sorting;

public class insertionSort {
   // implement insertion sort

    public static int[] insertionSort(int[] arr) {
        int key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                //swap elements
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };
        int[] sortedArr = insertionSort(arr);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }
}
