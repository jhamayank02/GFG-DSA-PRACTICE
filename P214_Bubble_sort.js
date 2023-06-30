// Time complexity O(n^2) || Space complexity O(1)
class Solution
{
   //Function to sort the array using bubble sort algorithm.
   bubbleSort(arr,n){
    
    for(let i=0; i<n-1; i++){
        for(let j=0; j<n-i-1; j++){
            if(arr[j] > arr[j+1]){
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
   }
}