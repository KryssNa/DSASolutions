package Sorting;

import java.util.Collection;
import java.util.Collections;

public class countingSort {
    //implement counting sort
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
         countingSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void countingSort(int[] arr) {

        int j=0,i=0;

        int max = arr[0];
        for ( i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        int[] countArr = new int[max+1];

        for( i=0;i<max+1;i++){
            countArr[i]=0;
        }
        for ( i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        i=0;
        j=0;
        while(i<=max){
            if(countArr[i]>0){
                arr[j]=i;
                countArr[i]--;
                j++;
            }
            else{
                i++;
            }
        }

    }

}