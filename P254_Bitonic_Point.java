class P254_Bitonic_Point{

    int findMaximum(int[] arr, int n) {
        // Approach 1 : Bruteforce
        // T.C O(n) || S.C O(1)
        // for(int i=0; i<n-1; i++){
        //     if(arr[i] > arr[i+1]){
        //         return arr[i];
        //     }
        // }
        // return arr[n-1];
        
        
        // Approach 2 : Using Binary Search
        // T.C O(logn) || S.C O(1)
        
        int s = 0;
        int e = n-1;
        int mid = (s+e)/2;
        
        while(s<=e){
            
            if(mid > 0 && mid < n-1 && arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }
            else if(mid > 0 && arr[mid-1] < arr[mid]){
                s = mid+1;
            }
            else if(mid > 0 && arr[mid-1] > arr[mid]){
                e = mid-1;
            }
            
            mid = (s+e)/2;
        }
        
        return arr[n-1];
    }

    public static void main(String args[]){

    }
}