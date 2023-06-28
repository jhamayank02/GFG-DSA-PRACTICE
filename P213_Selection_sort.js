
// Time complexity O(n^2) || Space complexity O(1)
class Solution
{
  select(arr,i){
     // code here such that selectionSort() sorts arr[]
     let min = i;
     for(let j=i; j<arr.length; j++){
        if(arr[min] > arr[j]){
            min = j;
        }
     }
     
     return min;
  }

  //Function to sort the array using selection sort algorithm.
  selectionSort(arr,n){
    for(let i=0; i<n; i++){
        let minElem = this.select(arr, i);
        
        let temp = arr[i];
        arr[i] = arr[minElem];
        arr[minElem] = temp;
    }
  }
}