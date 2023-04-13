public class P158_Merge_two_binary_Max_heaps {
    
    // Time complexity O(logn) || Space complexity O(1)
    public static void Heapify(int arr[], int n, int i){
        int largest = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;

        if(leftChild < n && arr[largest] < arr[leftChild]){
            largest = leftChild;
        }
        if(rightChild < n && arr[largest] < arr[rightChild]){
            largest = rightChild;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            Heapify(arr, n, largest);
        }
    }
    
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // Step 1: Merge both arrays into one
        // Time complexity O(m+n) || Space complexity O(m+n)
        int ans[] = new int[n+m];
        
        int index = 0;
        
        for(int i=0; i<n; i++){
            ans[index] = a[i];
            index++;
        }
        
        for(int i=0; i<m; i++){
            ans[index] = b[i];
            index++;
        }
        
        // Step 2: Build heap using the merged array
        // Time complexity O((n+m)log(n+m)) || Space complexity O(1)
        int size = ans.length;
        for(int i = size/2-1; i>=0; i--){
           Heapify(ans, size, i);
        }
          
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
