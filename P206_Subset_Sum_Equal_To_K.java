import java.util.*;

class P206_Subset_Sum_Equal_To_K{

    public static boolean solve(int ind, int target, int arr[], int dp[][]){

        // Base case
        if(target == 0){
            return true;
        }
        if(ind == 0){
            return (arr[0] == target);
        }

        if(dp[ind][target] != -1){
            return dp[ind][target]==0?false:true;
        }

        boolean not_take = solve(ind-1, target, arr, dp);

        boolean take = false;
        if(target >= arr[ind]){
            take = solve(ind-1, target-arr[ind], arr, dp);
        }

        dp[ind][target] = not_take||take?1:0;

        return take || not_take;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Memoization
        // Time complexity O(n * target) || Space complexity O(n * target)
        // int dp[][] = new int[n][k+1];

        // for(int a[] : dp){
        //     Arrays.fill(a, -1);
        // }

        // return solve(n-1, k, arr, dp);


        // Tabulation
        // Time complexity O(n * target) || Space complexity O(n * target)
        // boolean dp[][] = new boolean[n][k+1];

        // for(int i=0; i<n; i++){
        //     dp[i][0] = true;
        // }

        // if(arr[0] <= k){
        //     dp[0][arr[0]] = true;
        // }

        // for(int ind=1; ind<n; ind++){
        //     for(int target=1; target<=k; target++){

        //         boolean not_take = dp[ind-1][target];

        //         boolean take = false;
        //         if(target >= arr[ind]){
        //             take = dp[ind-1][target-arr[ind]];
        //         }

        //         dp[ind][target] = not_take||take;

        //     }
        // }


        // return dp[n-1][k];



        // Tabulation
        // Time complexity O(n * target) || Space complexity O(target)
        boolean prev[] = new boolean[k+1];

        prev[0] = true;

        if(arr[0] <= k){
            prev[arr[0]] = true;
        }

        for(int ind=1; ind<n; ind++){
            boolean current[] = new boolean[k+1];
            current[0] = true;

            for(int target=1; target<=k; target++){

                boolean not_take = prev[target];

                boolean take = false;
                if(target >= arr[ind]){
                    take = prev[target-arr[ind]];
                }

                current[target] = not_take||take;

            }

            prev = current;
        }


        return prev[k];
    }

    public static void main(String args[]){

    }
}