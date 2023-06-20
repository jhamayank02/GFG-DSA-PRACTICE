import java.util.*;

class P197_Frog_Jump{

    public static int solveRecursion(int n, int heights[]){
        if(n == 0){
            return 0;
        }

        int oneStep = solveRecursion(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        
        int twoStep = Integer.MAX_VALUE;
        if(n>1){
            twoStep = solveRecursion(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        }

        return Math.min(oneStep, twoStep);
    }

    public static int solve(int n, int dp[], int heights[]){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int oneStep = solve(n-1, dp, heights) + Math.abs(heights[n] - heights[n-1]);
        
        int twoStep = Integer.MAX_VALUE;
        if(n>1){
            twoStep = solve(n-2, dp, heights) + Math.abs(heights[n] - heights[n-2]);
        }

        return dp[n] = Math.min(oneStep, twoStep);
    }

    public static int frogJump(int n, int heights[]) {

        // Using Recursion
        // Time complexity O(n) || Space complexity O(n)
        // return solveRecursion(n-1, heights);

        // Using Memoization
        // Time complexity O(n) || Space complexity O(n)
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);

        // return solve(n-1, dp, heights);


        
        // Using Tabulation
        // Time complexity O(n) || Space complexity O(n)
        // int dp[] = new int[n];

        // // Base case
        // dp[0] = 0;

        // for(int i=1; i<n; i++){
        //     int oneStep = dp[i-1] + Math.abs(heights[i] - heights[i-1]);

        //     int twoStep = Integer.MAX_VALUE;
        //     if(i>1){
        //         twoStep = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
        //     }

        //     dp[i] = Math.min(oneStep, twoStep);
        // }

        // return dp[n-1];

        
        // Using Tabulation
        // Time complexity O(n) || Space complexity O(1)

        int prev1 = 0;
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int oneStep = prev1 + Math.abs(heights[i] - heights[i-1]);

            int twoStep = Integer.MAX_VALUE;
            if(i>1){
                twoStep = prev2 + Math.abs(heights[i] - heights[i-2]);
            }

            int curri = Math.min(oneStep, twoStep);

            prev2 = prev1;
            prev1 = curri;
        }

        return prev1;
    }

    public static void main(String args[]){

    }
}