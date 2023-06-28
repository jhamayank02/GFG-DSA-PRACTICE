import java.util.*;

class P211_0_1_Knapsack{

    public static int solveRecursive(int ind, int W, int wt[], int val[]){
        // Base case
        if(ind == 0){
            if(wt[ind] <= W){
                return val[ind];
            }
            return 0;
        }

        int notTake = 0 + solveRecursive(ind-1, W, wt, val);

        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + solveRecursive(ind-1, W-wt[ind], wt, val);
        }

        return Math.max(take, notTake);
    }

    public static int solveTabulation(int W, int wt[], int val[]){
        int n = val.length;
        int dp[][] = new int[n][W+1];
        // As we will only take 0 the val when the weight required will be greater than or equal to the weitht of 0th element
        for(int ind=wt[0]; ind<=W; ind++){
            dp[0][ind] = val[0];
        }


        for(int ind=1; ind<n; ind++){
            for(int weight=0; weight<=W; weight++){

                int notTake = 0 + dp[ind-1][weight];

                int take = Integer.MIN_VALUE;
                if(wt[ind] <= weight){
                    take = val[ind] + dp[ind-1][weight-wt[ind]];
                }

                dp[ind][weight] = Math.max(take, notTake);
            }
        }

        return dp[n-1][W];
    }

    
    public static int solveTabulationOptimized(int W, int wt[], int val[]){
        int prev[] = new int[W+1];

        // As we will only take 0 the val when the weight required will be greater than or equal to the weitht of 0th element
        for(int ind=wt[0]; ind<=W; ind++){
            prev[ind] = val[0];
        }

        int n = val.length;

        // for(int ind=1; ind<n; ind++){

        //     int current[] = new int[W+1];

        //     for(int weight=0; weight<=W; weight++){

        //         int notTake = 0 + prev[weight];

        //         int take = Integer.MIN_VALUE;
        //         if(wt[ind] <= weight){
        //             take = val[ind] + prev[weight-wt[ind]];
        //         }

        //         current[weight] = Math.max(take, notTake);
        //     }

        //     prev = current;
        // }


        // ******* ONE ARRAY OPTIMIZATION *******
         for(int ind=1; ind<n; ind++){

            for(int weight=W; weight>=0; weight--){

                int notTake = 0 + prev[weight];

                int take = Integer.MIN_VALUE;
                if(wt[ind] <= weight){
                    take = val[ind] + prev[weight-wt[ind]];
                }

                prev[weight] = Math.max(take, notTake);
            }
        }

        return prev[W];

        return prev[W];
    }  

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // Recursion
        // Time complexity O(2^n) || Space complexity O(n)
        // return solveRecursive(n-1, maxWeight, weight, value);





        // Memoization
        // Time complexity O(n * weight) || Space complexity O(n * weight)
        // int dp[][] = new int[n][maxWeight+1];

        // for(int[] a : dp){
        //     Arrays.fill(a, -1);
        // }

        // return solveDP(n-1, maxWeight, weight, value, dp);


        // Tabulation
        // Time complexity O(n * weight) || Space complexity O(n * weight)
        // return solveTabulation(maxWeight, weight, value, dp);

        // Tabulation
        // Time complexity O(n * weight) || Space complexity O(weight)
        return solveTabulationOptimized(maxWeight, weight, value);
    }


    public static void main(String args[]){

    }
}