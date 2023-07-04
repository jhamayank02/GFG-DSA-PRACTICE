import java.util.*;

class P232_Best_Time_to_Buy_and_Sell_Stock_2{

    // buy = 0 -> Can't buy it we have to sell it
    // buy = 1 -> Either buy it or don't buy it

    // Recursion
    // Time complexity O(2^n) || Space complexity O(n)
    public static long solveRecursive(int n, long values[], int ind, int buy){

        // Base case
        if(ind == n){
            return 0;
        }

        long profit = 0;

        if(buy == 1){
            long buyIt = -values[ind] + solveRecursive(n, values, ind+1, 0);
            long notBuy = 0 + solveRecursive(n, values, ind+1, 1);

            profit = Math.max(notBuy, buyIt);
        }
        else{
            long sell = values[ind] + solveRecursive(n, values, ind+1, 1);
            long notSell = 0 + solveRecursive(n, values, ind+1, 0);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }

    // Memoization
    // Time complexity O(n*2) || Space complexity O(n*2) + O(n)
    public static long solveMemoization(int n, long values[], int ind, int buy, long dp[][]){

        // Base case
        if(ind == n){
            return 0;
        }

        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }

        long profit = 0;

        if(buy == 1){
            long buyIt = -values[ind] + solveMemoization(n, values, ind+1, 0, dp);
            long notBuy = 0 + solveMemoization(n, values, ind+1, 1, dp);

            profit = Math.max(notBuy, buyIt);
        }
        else{
            long sell = values[ind] + solveMemoization(n, values, ind+1, 1, dp);
            long notSell = 0 + solveMemoization(n, values, ind+1, 0, dp);

            profit = Math.max(sell, notSell);
        }

        return dp[ind][buy] = profit;
    }

    // Tabulation
    // Time complexity O(n*2) || Space complexity O(n*2)
    public static long solveTabulation(int n, long[] values){

        long dp[][] = new long[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){

                long profit = 0;

                if(buy == 1){
                    long buyIt = -values[ind] + dp[ind+1][0];
                    long notBuy = 0 + dp[ind+1][1];

                    profit = Math.max(notBuy, buyIt);
                }
                else{
                    long sell = values[ind] + dp[ind+1][1];
                    long notSell = 0 + dp[ind+1][0];

                    profit = Math.max(sell, notSell);
                }

                dp[ind][buy] = profit;

            }
        }

        return dp[0][1];
    }

    // Tabulation(Space optimized)
    // Time complexity O(n*2) || Space complexity O(2)
    public static long solveTabulationOptimized(int n, long[] values){

        long ahead[] = new long[2];

        ahead[0] = 0;
        ahead[1] = 0;

        for(int ind=n-1; ind>=0; ind--){

            long current[] = new long[2];

            for(int buy=0; buy<=1; buy++){

                long profit = 0;

                if(buy == 1){
                    long buyIt = -values[ind] + ahead[0];
                    long notBuy = 0 + ahead[1];

                    profit = Math.max(notBuy, buyIt);
                }
                else{
                    long sell = values[ind] + ahead[1];
                    long notSell = 0 + ahead[0];

                    profit = Math.max(sell, notSell);
                }

                current[buy] = profit;

            }
            ahead = current;
        }

        return ahead[1];
    }

    public static long getMaximumProfit (int n, long[] values) {
        
        if(n==0 || n==1){
            return 0;
        }

        // return solveRecursive(n, values, 0, 1);

        // long dp[][] = new long[n][2];
        // for(long a[] : dp){
        //     Arrays.fill(a, -1);
        // }
        // return solveMemoization(n, values, 0, 1, dp);

        // return solveTabulation(n, values);

        return solveTabulationOptimized(n, values);

    }

    public static void main(String args[]){

    }
}