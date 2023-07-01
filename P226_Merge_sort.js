class Solution
{
    merge(arr, s, mid, e)
    {
         var len1 = mid - s + 1;
         var len2 = e - mid;
         
         var left = [];
         var right = [];
         
         // Indicating the main array index
         var ptr = s;
         
         for(var i=0; i<len1; i++){
             left[i] = arr[ptr];
             ptr++;
         }
         for(var i=0; i<len2; i++){
             right[i] = arr[ptr];
             ptr++;
         }
         
         var i = 0; // For left array
         var j = 0; // For right array
         ptr = s; // For main array
         
         while(i<len1 && j<len2){
             
             if(left[i] < right[j]){
                 arr[ptr] = left[i];
                 i++;
             }
             else if(left[i] >= right[j]){
                 arr[ptr] = right[j];
                 j++;
             }
             ptr++;
         }
         
         while(i<len1){
             arr[ptr] = left[i];
             ptr++;
             i++;
         }
         while(j<len2){
             arr[ptr] = right[j];
             ptr++;
             j++;
         }
    }
    
    // Time complexity O(nlogn) || Space complexity O(n)
    mergeSort(arr, s, e){
        if(s >= e){
            return;
        }
    
        var mid = s + parseInt((e-s)/2);
    
        this.mergeSort(arr, s, mid);
        this.mergeSort(arr, mid+1, e);
        this.merge(arr, s, mid, e);
    }
    
}