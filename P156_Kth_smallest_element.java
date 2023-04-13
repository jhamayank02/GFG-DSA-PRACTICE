import java.util.Collections;
import java.util.PriorityQueue;

public class P156_Kth_smallest_element {

    // Time complexity O(nlogk) || Space complexity O(k)
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=l; i<k; i++){
            pq.add(arr[i]);
        }
        
        for(int i=k; i<=r; i++){
            if(arr[i] < pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        
        return pq.peek();
    } 
    
    public static void main(String[] args) {
        
    }
}
