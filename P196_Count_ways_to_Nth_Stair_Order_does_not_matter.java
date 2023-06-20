import java.util.*;

class P196_Count_ways_to_Nth_Stair_Order_does_not_matter{

    public static int solve(int n, int dp[]){
        if(n<=1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = 1 + solve(n-2, dp);
    }
    
    public static int recursion(int n){
        if(n<=1){
            return 1;
        }
        return 1 + recursion(n-2);
    }
    
    public long nthStair(int n)
    {
        
        // Recursion
        // T.C O(n) || S.C O(n)
        return recursion(n);
        
        // Memoization
        // T.C O(n) || S.C O(n)
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        
        // return solve(n, dp);
        
        // Tabulation
        // T.C O(n) || S.C O(n)
        // int dp[] = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        
        // for(int i=2; i<=n; i++){
        //     dp[i] = 1 + dp[i-2];
        // }
        
        // return dp[n];
        
        // Tabulation
        // T.C O(n) || S.C O(1)
        // int prev2 = 1;
        // int prev = 1;
        
        // for(int i=2; i<=n; i++){
        //     int curri = prev2 + 1;
        //     prev2 = prev;
        //     prev = curri;
        // }
        
        // return prev;
    }

    public static void main(String args[]){

    }
}