package Sorting;

public class quickSort {

    int partition(int arr[], int start, int end) {
        int s=start;
        int e=end;
        int pivot=arr[s];
        while(s<e){
            while(arr[s]<=pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if(s<e){
                swap(arr,s,e);
            }
        }
        swap(arr,start,e);
        return e;
    }

    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void quickSort(int arr[],int start,int end){
        if(start<end){
            int p=partition(arr,start,end);
            quickSort(arr,start,p-1);
            quickSort(arr,p+1,end);
        }
    }

    void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]={7,10,4,3,20,15};
        int n=arr.length;
        quickSort qs=new quickSort();
        qs.quickSort(arr,0,n-1);
        qs.printArray(arr);
    }
}
