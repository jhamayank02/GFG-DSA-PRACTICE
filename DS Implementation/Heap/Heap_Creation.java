
class HEAP{
    int arr[] = new int[100];
    // arr[0] = -1;
    int size = 0;

    HEAP(){
        arr[0] = -1;
        // size = 0;
    }

    public void insert(int val){
        size++;
        int index = size;
        arr[index] = val;

        while(index > 1){
            int parent = index/2;

            if(arr[parent] < arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else{
                return;
            }
        }
    }

    public void delete(){

        if(size == 0){
            System.out.println("Nothing to delete");
            return;
        }

        arr[1] = arr[size];
        size--;

        // Take root node to its correct position
        int i = 1;
        while(i <= size){
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;

            if(leftIndex <= size && arr[i] < arr[leftIndex] && rightIndex <= size && arr[leftIndex] > arr[rightIndex]){
                int temp = arr[i];
                arr[i] = arr[leftIndex];
                arr[leftIndex] = temp;
                i = leftIndex;
            }

            else if(rightIndex <= size && arr[i] < arr[rightIndex]){
                int temp = arr[i];
                arr[i] = arr[rightIndex];
                arr[rightIndex] = temp;
                i = rightIndex;
            }

            else{
                return;
            }
        }

    }

    
    public void print(){
        System.out.print("HEAP : ");
        for(int i=1; i<=size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

public class Heap_Creation{

    // For creating a Max Heap
    // Time complexity O(logn) || Space complexity O(1)
    public static void Heapify(int arr[], int n, int i){
        int largest = i;
        int leftChild = 2*i;
        int rightChild = 2*i + 1;

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

    // For creating a Min Heap
    // Time complexity O(logn) || Space complexity O(1)
    public static void HeapifyMinHeap(int arr[], int n, int i){
        int smallest = i;
        int leftChild = 2*i;
        int rightChild = 2*i + 1;

        if(leftChild < n && arr[smallest] > arr[leftChild]){
            smallest = leftChild;
        }
        if(rightChild < n && arr[smallest] > arr[rightChild]){
            smallest = rightChild;
        }

        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            HeapifyMinHeap(arr, n, smallest);
        }
    //   System.out.print("\nPrinting the array : ");
    //   for(int j=1;j<arr.length; j++){
    //     System.out.print(arr[j] + " ");
    //   }
    }

    // Time complexity O(nlogn) || Space complexity O(1)
    public static void heapSort(int arr[], int n){
        int size = n;

        while(size > 1){
            // step 1: Swap
            int temp = arr[1];
            arr[1] = arr[size];
            arr[size] = temp;
            size--;

            // Take root node to its correct position - Heapify
            Heapify(arr, size, 1);
        }
    }

    public static void main(String[] args) {
      HEAP h = new HEAP();
      h.insert(60);
      h.insert(30);
      h.insert(20);
      h.insert(40);
      h.insert(70);
      h.insert(55);

      h.print();

      h.delete();
      System.out.println();

      h.print();


    //   int arr[] = {-1,54,55,53,52,50};

    //   int n = arr.length;

    //   // Time complexity O(n) || Space complexity O(1)
    //   for(int i = n/2; i>0; i--){
    //       Heapify(arr, n, i);
    //   }

    //   System.out.print("\nPrinting the array : ");
    //   for(int i=1; i<n; i++){
    //     System.out.print(arr[i] + " ");
    //   }

    //   int arr2[] = {-1,54,55,53,52,50};

    //   int k = arr2.length;

    //   // Time complexity O(n) || Space complexity O(1)
    //   for(int i = k/2; i>0; i--){
    //       HeapifyMinHeap(arr2, n, i);
    //   }

    //   System.out.print("\nPrinting the array : ");
    //   for(int i=1; i<k; i++){
    //     System.out.print(arr2[i] + " ");
    //   }


    int arr[] = {-1, 70, 60, 55, 45, 50};

    // Build Heap
    // Time complexity O(n) || Space complexity O(1)
    for(int i = arr.length/2; i>0; i--){
        Heapify(arr, arr.length-1, i);
    }

    System.out.print("\nPrinting the array : ");
    for(int i=1; i<arr.length; i++){
    System.out.print(arr[i] + " ");
    }

    // Sort the heap
    heapSort(arr, arr.length-1);

    System.out.print("\nPrinting the array : ");
    for(int i=1; i<arr.length; i++){
    System.out.print(arr[i] + " ");
    }

    }



}