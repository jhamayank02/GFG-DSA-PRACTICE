import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class P160_Kth_largest_subarray_sum {
    
    // Approach 1: Brute Force
    // Time complexity O(n^2logn) || Space complexity O(n^2)
    public static int getKthLargest(int arr[], int k){

        ArrayList<Integer> sumStore = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                sumStore.add(sum);
            }
        }

        Collections.sort(sumStore);

        return sumStore.get(sumStore.size()-k);
    }

    // Approach 2: Min Heap
    // Time complexity O(n^2logn) || Space complexity O(k)
    public static int getKthLargest2(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                if(pq.size() < k){
                    pq.add(sum);
                }
                else{
                    if(sum > pq.peek()){
                        pq.poll();
                        pq.add(sum);
                    }
                }
            }
        }

        return pq.poll();
    }


    public static void main(String[] args) {
        int arr[] = {1,2,6,4,3};

        System.out.println(getKthLargest(arr, 2));
        System.out.println(getKthLargest2(arr, 2));
    }
}

