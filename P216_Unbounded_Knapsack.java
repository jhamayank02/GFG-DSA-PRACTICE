import java.util.*;

class P216_Unbounded_Knapsack{

    // Memoization
    // Time complexity O(n * target) || Space complexity O(n * target) + O(target)
    public static int solve(int ind, int w, int[] profit, int[] weight, int dp[][]){
        // Base case
        if(ind == 0){
            return (w / weight[0])* profit[0];
        }

        if(dp[ind][w] != -1){
            return dp[ind][w];
        }

        int notTake = 0 + solve(ind-1, w, profit, weight, dp);

        int take = Integer.MIN_VALUE;
        if(weight[ind] <= w){
            take = profit[ind] + solve(ind, w-weight[ind], profit, weight, dp);
        }

        return dp[ind][w] = Math.max(take, notTake);
    }

    // Tabulation
    // Time complexity O(n * target) || Space complexity O(n * target)
    public static int solveTabulation(int n, int w, int[] profit, int[] weight){
        int dp[][] = new int[n][w+1];

        for(int i=0; i<=w; i++){
            dp[0][i] = ((int) i / weight[0]) * profit[0];
        }

        for(int ind=1; ind<n; ind++){
            for(int k=0; k<=w; k++){

                int notTake = 0 + dp[ind-1][k];

                int take = Integer.MIN_VALUE;
                if(weight[ind] <= k){
                    take = profit[ind] + dp[ind][k-weight[ind]];
                }

                dp[ind][k] = Math.max(take, notTake);
            }
        }

        return dp[n-1][w];

    }

    // Tabulation(Space optimized)
    // Time complexity O(n * target) || Space complexity O(target)
    public static int solveTabulationOptimized(int n, int w, int[] profit, int[] weight){
        int prev[] = new int[w+1];

        for(int i=0; i<=w; i++){
            prev[i] = ((int) i / weight[0]) * profit[0];
        }

        // **************** USing two 1D array ****************
        // for(int ind=1; ind<n; ind++){
        //     int current[] = new int[w+1];

        //     for(int k=0; k<=w; k++){

        //         int notTake = 0 + prev[k];

        //         int take = Integer.MIN_VALUE;
        //         if(weight[ind] <= k){
        //             take = profit[ind] + current[k-weight[ind]];
        //         }

        //        current[k] = Math.max(take, notTake);
        //     }
        //     prev = current;
        // }

        // **************** USing a single 1D array ****************
        for(int ind=1; ind<n; ind++){
            int current[] = new int[w+1];

            for(int k=0; k<=w; k++){

                int notTake = 0 + prev[k];

                int take = Integer.MIN_VALUE;
                if(weight[ind] <= k){
                    take = profit[ind] + prev[k-weight[ind]];
                }

               prev[k] = Math.max(take, notTake);
            }
        }

        return prev[w];

    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n][w+1];

        for(int a[]: dp){
            Arrays.fill(a, -1);
        }

        // return solve(n-1, w, profit, weight, dp);
        // return solveTabulation(n, w, profit, weight);
        return solveTabulationOptimized(n, w, profit, weight);
    }

    public static void main(String args[]){

    }
}