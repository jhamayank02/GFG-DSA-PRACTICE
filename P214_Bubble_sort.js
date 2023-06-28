// Time complexity O(n^2) || Space complexity O(1)
class Solution
{
   //Function to sort the array using bubble sort algorithm.
   bubbleSort(arr,n){
    
    for(let i=0; i<n; i++){
        for(let j=i+1; j<n; j++){
            if(arr[i] > arr[j]){
                let temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
   }
}