package Sorting;

public class selectionSort {
    // implement selection sort

    public static int[] selectionSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int min = i; // index of smallest element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) { // if smaller element found
                    min = j; // update index of smallest element
                }
            }
            // swap elements
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };
        int[] sortedArr = selectionSort(arr);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }
}
