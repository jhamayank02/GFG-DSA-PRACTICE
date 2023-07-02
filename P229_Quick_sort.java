import java.util.*;

class P229_Quick_sort{
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Time complexity Best and average case O(nlogn) and in worst case O(n^2) || Space complexity O(logn)
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low >= high){
            return;
        }
        
        int p = partition(arr, low, high);
        
        // left part sort
        quickSort(arr, low, p-1);
        
        // right part sort
        quickSort(arr, p+1, high);
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        
        // No. of elements less than the pivot
        int cnt = 0;
        for(int i=low+1; i<=high; i++){
            if(arr[i] <= pivot){
                cnt++;
            }
        }
        
        // Right index of pivot
        int pivotIndex = low + cnt;
        swap(arr, pivotIndex, low);
        
        int i = low;
        int j = high;
        
        while(i<pivotIndex && j>pivotIndex){
            
            while(arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            
            if(i<pivotIndex && j>pivotIndex){
                swap(arr, i, j);
                i++;
                j--;
            }
            
        }
        
        return pivotIndex;
    } 

    public static void main(String args[]){

    }
}