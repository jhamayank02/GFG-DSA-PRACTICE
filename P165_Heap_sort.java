class P165_Heap_sort{
    //Function to build a Heap from array.
    // Time complexity O(nlogn) || Space complexity O(1)
    void buildHeap(int arr[], int n)
    {
        for(int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
    }
 
    //Heapify function to maintain heap property.
    // Time complexity O(logn) || Space complexity O(1)
    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        
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
            
            heapify(arr, n, largest);
        }
        
    }
    
    //Function to sort an array using Heap Sort.
    // Time complexity O(nlogn) || Space complexity O(1)
    public void heapSort(int arr[], int n)
    {
        buildHeap(arr, n);
        
        int size = n;
        
        while(size > 1){
            int temp = arr[size-1];
            arr[size-1] = arr[0];
            arr[0] = temp;
            size--;
            heapify(arr, size, 0);
        }
    }

    public static void main(String[] args) {
        
    }
}