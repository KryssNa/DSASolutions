package HW;

public class ImplementQuickSelectAlgorith {

    public static void main(String[] args) {
        int arr[]={7,10,4,3,20,15};
        int k=3;
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=quickSelect(arr,low,high,k);
        System.out.println(ans);
    }
    static int quickSelect(int arr[],int low,int high,int k){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<=high-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        if(i+1==k){
            return arr[i+1];
        }
        else if(i+1>k){
            return quickSelect(arr,low,i,k);
        }
        else{
            return quickSelect(arr,i+2,high,k);
        }
    }
    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
