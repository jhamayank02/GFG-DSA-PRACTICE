import java.util.*;

class P209_Count_Subsets_with_Sum_K{

    public static int solve(int ind, int tar, int num[], int dp[][]){
        // Base case
        if(tar == 0){
            return 1;
        }
        if(ind == 0){
            if(num[ind] == tar){
                return 1;
            }
            return 0;
        }

        if(dp[ind][tar] != -1){
            return dp[ind][tar];
        }

        int notPick = solve(ind-1, tar, num, dp);

        int pick = 0;
        if(num[ind] <= tar){
            pick = solve(ind-1, (tar-num[ind]), num, dp);
        }

        return dp[ind][tar] = pick + notPick;
    }
    
    public static int findWays(int num[], int tar) {
        // Memoization
        // Time complexity O(n*tar) || Space complexity O(n*tar)

        // int n = num.length;

        // int dp[][] = new int[n][tar+1];
        
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<=tar; j++){
        //         dp[i][j] = -1;
        //     }
        // }
    

        // return solve(n-1, tar, num, dp);



        // Tabulation
        // Time complexity O(n*tar) || Space complexity O(n*tar)
        // int n = num.length;

        // int dp[][] = new int[n][tar+1];
        
        // for(int i=0; i<n; i++){
        //     dp[i][0] = 1;
        // }

        // if(num[0] <= tar){
        //     dp[0][num[0]] = 1;
        // }

        // for(int ind=1; ind<n; ind++){
        //     for(int target=0; target<=tar; target++){

        //         int notPick = dp[ind-1][target];

        //         int pick = 0;
        //         if(num[ind] <= target){
        //             pick = dp[ind-1][target-num[ind]];
        //         }

        //         dp[ind][target] = pick + notPick;
        //     }
        // }

        // return dp[n-1][tar];




        // Tabulation(Space optimized)
        // Time complexity O(n*tar) || Space complexity O(tar)
        int n = num.length;

        int prev[] = new int[tar+1];
        
        prev[0] = 1;

        if(num[0] <= tar){
            prev[num[0]] = 1;
        }

        for(int ind=1; ind<n; ind++){
            int current[] = new int[tar+1];

            for(int target=0; target<=tar; target++){

                int notPick = prev[target];

                int pick = 0;
                if(num[ind] <= target){
                    pick = prev[target-num[ind]];
                }

                current[target] = pick + notPick;
            }

            prev = current;
        }

        return prev[tar];
    }

    public static void main(String args[]){

    }
}