import java.util.ArrayDeque;
import java.util.ArrayList;

public class P85_First_negative_integer_in_every_window_of_size_k {
    public static long[] printFirstNegativeInteger(long A[], int N, int K){
        // Time complexity O(n) || Space complexity O(n)

        ArrayList<Long> ans = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // Process the first window
        for(int i=0; i<K; i++){
            if(A[i]<0){
                q.add(i);
            }
        }

        // Store ans of first k sized window
        if(q.size() > 0){
            ans.add(A[q.peek()]);
        }
        else{
            ans.add((long) 0);
        }

        // Process for remaining windows
        for(int i=K; i<N; i++){
            // Removal
            if(!q.isEmpty() && i - q.peek() >= K ){
                q.removeFirst();
            }

            // Addition
            if(A[i] < 0){
                q.add(i);
            }

            // ans store
            if(q.size() > 0){
                ans.add(A[q.peekFirst()]);
            }
            else{
                ans.add((long) 0);
            }

        }

        long ansArray[] = new long[N-1];

        for(int i=0; i<ans.size(); i++){
            ansArray[i] = ans.get(i);
        }

        return ansArray;
    }

    public static void main(String[] args) {
        long arr[] = {-8, 2, 3, -6, 10};
        long ans[] = printFirstNegativeInteger(arr, arr.length, 2);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
