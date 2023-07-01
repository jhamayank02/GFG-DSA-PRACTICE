import java.util.*;

class P222_Insertion_sort{

   static void insert(int arr[],int i){
       int prev = i-1;
       int key = arr[i];
       
       while(prev >= 0 && key < arr[prev]){
           arr[prev+1] = arr[prev];
           prev--;
       }
       
       arr[prev+1] = key;
  }

  // Time complexity -> Worst and Average case O(n^2) || Best case O(n)
  // Space complexity -> O(1)
  public void insertionSort(int arr[], int n){
      for(int i=1; i<n; i++){
          insert(arr, i);
      }
  }

    public static void main(String args[]){

    }
}