package GreedyAlgorithm;

import static Sorting.Hw.sort2Array.sortToArray;

public class TaskSelection {
    static  void ActivitySelection(int[] start, int[] finish, int n) {
        int i = 0;
        System.out.print(i + " ");
        for (int j = 1; j < n; j++) {
            if (start[j] >= finish[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {5,1,8,3,0,5};
        int[] B = {7,2,9,4,6,9};

        sortToArray(B, A, 0, A.length - 1); //sorting array A on the basis of B

        ActivitySelection(A, B, A.length);
    }
}
