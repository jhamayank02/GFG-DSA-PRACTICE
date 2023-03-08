import java.util.LinkedList;
import java.util.Queue;

class P95_First_negative_integer_in_every_window_of_size_k{

    static public long[] printFirstNegativeInteger(long A[], int N, int K){
        // Time complexity O(n) || Space complexity O()
        Queue<Long> q = new LinkedList<Long>();
        int beg = 0;
        int end = K-1;

        while(end < N){

            int i;

            for(i=beg; i<=end; i++){
                if(A[i]<0){
                    q.add(A[i]);
                    break;
                }
            }

            // If no negative element found in the current window then add 0
            if(i == end+1){
                q.add(0L);
            }

            beg++;
            end++;
        }

        long ans[] = new long[q.size()];

        int index = 0;
        while(!q.isEmpty()){
            ans[index] = q.poll();
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {
        // int N = 5;
        // long A[] = {-8, 2, 3, -6, 10};
        // int K = 2;
        int N = 8;
        long A[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int K = 3;

        long ans[] = printFirstNegativeInteger(A, N, K);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}