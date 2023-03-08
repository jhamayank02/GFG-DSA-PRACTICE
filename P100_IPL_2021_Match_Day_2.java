import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class P100_IPL_2021_Match_Day_2 {
    
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        
        // Time complexity O(n*k) || Space complexity O(1)
        // ArrayList<Integer> ans = new ArrayList<>();

        // for(int i=0; i<n; i++){
        //     int max = Integer.MIN_VALUE;
        //     for(int j=i; j<i+k; j++){
        //         if(arr[j] > max){
        //             max = arr[j];
        //         }
        //     }
        //     ans.add(max);

        //     if(i+k == n){
        //         break;
        //     }
        // }

        // return ans;



        // Time complexity O(n) || Space complextity O(k)
        // Approach -> Using priority queue
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){

            while(q.size()>0 && i-q.peek()>=k){
                q.removeFirst();
            }

            while(q.size()>0 && arr[q.getLast()]<=arr[i]){
                q.removeLast();
            }

            q.addLast(i);
            if(i>=k-1){
                ans.add(arr[q.peek()]);
            }
        }


        return ans;
    }
    
    public static void main(String[] args) {
        int N = 9, K = 3;
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};

        System.out.println(max_of_subarrays(arr, N, K));
    }
}
