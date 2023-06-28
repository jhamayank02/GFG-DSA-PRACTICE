import java.util.*;

class P212_Minimum_Elements{

        public static int solve(int ind, int tar, int num[], int dp[][]){

        // Base case
        if(ind == 0){
            if(tar % num[0] == 0){
                return tar / num[0];
            }
            
            return (int)1e9;
        }

        if(dp[ind][tar] != -1){
            return dp[ind][tar];
        }

        int notTake = 0 + solve(ind-1, tar, num, dp);

        int take = Integer.MAX_VALUE;
        if(num[ind] <= tar){
            take = 1 + solve(ind, tar-num[ind], num, dp);
        }

        return dp[ind][tar] = Math.min(take, notTake);
    }

    public static int solveTabulation(int num[], int x){
        int n = num.length;

        int dp[][] = new int[n][x+1];

        for(int i=0; i<=x; i++){
            if(i % num[0] == 0){
                dp[0][i] = i/num[0];
            }
            else{
                dp[0][i] = (int)1e9;
            }
        }

        for(int ind=1; ind<n; ind++){
            for(int tar=0; tar<=x; tar++){

                int notTake = 0 + dp[ind-1][tar];

                int take = Integer.MAX_VALUE;
                if(num[ind] <= tar){
                    take = 1 + dp[ind][tar-num[ind]];
                }

                dp[ind][tar] = Math.min(take, notTake);
            }
        }

        // If not possible
        int ans = dp[n-1][x];
        if(ans >= (int)1e9){
            return -1;
        }

        return ans;

    }

    public static int solveTabulationOptimized(int num[], int x){
        int n = num.length;

        int prev[] = new int[x+1];

        for(int i=0; i<=x; i++){
            if(i % num[0] == 0){
                prev[i] = i/num[0];
            }
            else{
                prev[i] = (int)1e9;
            }
        }

        for(int ind=1; ind<n; ind++){

            int current[] = new int[x+1];

            for(int tar=0; tar<=x; tar++){

                int notTake = 0 + prev[tar];

                int take = Integer.MAX_VALUE;
                if(num[ind] <= tar){
                    take = 1 + prev[tar-num[ind]];
                }

                prev[tar] = Math.min(take, notTake);
            }
        }

        // If not possible
        int ans = prev[x];
        if(ans >= (int)1e9){
            return -1;
        }

        return ans;

    }

    public static int minimumElements(int num[], int x) {

        // Memoization
        // Time complexity O(n*target) || Space complexity O(n*target) + O(target)
        // int n = num.length;
        // int dp[][] = new int[n][x+1];

        // for(int a[] : dp){
        //     Arrays.fill(a, -1);
        // }

        // int ans = solve(n-1, x, num, dp);
        // if(ans >= (int)1e9){
        //     return -1;
        // }

        // return ans;



        
        // Tabulation
        // Time complexity O(n*target) || Space complexity O(n*target)
        return solveTabulation(num, x);



        
        // Tabulation(Space optimized)
        // Time complexity O(n*target) || Space complexity O(target)
        return solveTabulationOptimized(num, x);



    }

    public static void main(String args[]){

    }
}