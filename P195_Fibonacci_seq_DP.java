import java.util.*;

class P195_Fibonacci_seq_DP{

    public static int fibDP(int n, int dp[]){
        if(n<=1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = fibDP(n-1, dp) + fibDP(n-2, dp);
    }

    public static void main(String args[]){
        // Using Memoization
        // Time complexity O(n) || Space complexity O(n)
        // int n = 5;
        // int dp[] = new int[n+1]; // n+1 as the index is starting from 0 and goes till 5
        // Arrays.fill(dp, -1);
        // System.out.println(fibDP(n, dp));


        // // Using Tabulation

        // Time complexity O(n) || Space complexity O(n)
        // int n = 5;
        // int dp[] = new int[n+1]; // n+1 as the index is starting from 0 and goes till 5
        
        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i=2; i<=n; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // System.out.println(dp[5]);

        // Space optimized tabulation
        // Time complexity O(n) || Space complexity O(1)
        int n = 5;
        
        int prev2 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++){
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        System.out.println(prev);
    }

}