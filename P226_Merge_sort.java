class P226_Merge_sort{

    public static void merge(int arr[], int l, int m, int r){
         int len1 = m - l + 1;
         int len2 = r - m;
         
         int left[] = new int[len1];
         int right[] = new int[len2];
         
         // Indicating the main array index
         int ptr = l;
         
         for(int i=0; i<len1; i++){
             left[i] = arr[ptr];
             ptr++;
         }
         for(int i=0; i<len2; i++){
             right[i] = arr[ptr];
             ptr++;
         }
         
         int i = 0; // For left array
         int j = 0; // For right array
         ptr = l; // For main array
         
         while(i<len1 && j<len2){
             
             if(left[i] < right[j]){
                 arr[ptr++] = left[i++];
             }
             else if(left[i] >= right[j]){
                 arr[ptr++] = right[j++];
             }
             
         }
         
         while(i<len1){
             arr[ptr++] = left[i++];
         }
         while(j<len2){
             arr[ptr++] = right[j++];
         }
    }

    // Time complexity O(nlogn) || Space complexity O(n)
    public static void mergeSort(int arr[], int l, int r){
        if(l >= r){
            return;
        }
        
        int mid = l + (r-l)/2;
        
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        
        merge(arr, l, mid, r);
    }

    public static void main(String args[]){

    }
}