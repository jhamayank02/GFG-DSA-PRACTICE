class P166_k_largest_elements{

    int[] kLargest(int[] arr, int n, int k) {
        // Using max heap
        // Time complexity O(nlogn) || Space complexity O(n)
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // int ans[] = new int[k];
        
        // // T.C O(nlogn)
        // for(int i=0; i<n; i++){
        //     maxHeap.add(arr[i]);
        // }
        
        // // T.C O(klogn)
        // for(int i=0; i<k; i++){
        //     ans[i] = maxHeap.poll();
        // }
        
        // return ans;



        // Approach 2: Using Min heap
        // Time complexity: O(nlogk) || Space complexity: O(k)
        int ans[] = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int i=0;
        for(; i<k; i++){
            minHeap.add(arr[i]);
        }
        
        for(; i<n; i++){
            if(minHeap.peek() < arr[i]){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        
        for(int j=k-1; j>=0; j--){
            ans[j] = minHeap.poll();
        }
        
        return ans;
    }

    public static void main(String[] args) {
    
    }
}