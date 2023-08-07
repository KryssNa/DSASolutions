package Sorting;

public class mergeSort {

    public static  void mergeSort(int ar[],int start, int end){
        int s=start;
        int e=end;
        if(s<e){
            int m=(s+e)/2;
            mergeSort(ar, start, m);
            mergeSort(ar,m+1,e);

            merge(ar,s,m,e);
        }
    }
    static void merge(int[] arr, int s, int m, int e){
        int n1=m-s+1;
        int n2=e-m;
        int[] l =new int[n1];
        int[] r =new int[n2];

        for(int i=0;i<n1;i++){
            l[i]=arr[i+s];
        }
        for(int i=0;i<n2;i++){
            r[i]=arr[m+1+i];
        }
        int i=0,j=0,k=s;

        while(i<n1 && j<n2){
            if ((l[i]<=r[j])){
                arr[k]=l[i];
                i++;
                k++;
            }else {
                arr[k]=r[j];
                k++;
                j++;
            }
        }
        while(i>=n1 && j<n2){
            arr[k]=r[j];
            j++;
            k++;
        }
        while (i<n1 && j>=n2){
            arr[k]=l[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 6, 4 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
