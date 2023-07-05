import java.util.*;

class P234_Best_Time_to_Buy_and_Sell_Stock_4{

    // *************** USING 2 ARRAYS ***************

    // Memoization
    // Time complexity O(n*2k) || Space complexity O(n*2k) + O(n)
    public static int solveMemoization(int prices[], int n, int k, int transactionNum, int ind, int dp[][]){

        // Base case
        if(ind == n || transactionNum == 2*k){
            return 0;
        }

        if(dp[ind][transactionNum] != -1){
            return dp[ind][transactionNum];
        }

        int profit = 0;

        if(transactionNum % 2 == 0){
            int buyIt = -prices[ind] + solveMemoization(prices, n, k, transactionNum+1, ind+1, dp);
            int notBuy = 0 + solveMemoization(prices, n, k, transactionNum, ind+1, dp);

            profit = Math.max(buyIt, notBuy);
        }
        else{
            int sell = prices[ind] + solveMemoization(prices, n, k, transactionNum+1, ind+1, dp);
            int notSell = 0 + solveMemoization(prices, n, k, transactionNum, ind+1, dp);

            profit = Math.max(sell, notSell);
        }

        return dp[ind][transactionNum] = profit;
    }

    // Tabulation
    // Time complexity O(n*2k) || Space complexity O(n*2k)
    public static int solveTabulation(int prices[], int n, int k){

        int dp[][] = new int[n+1][2*k+1];

        for(int ind=n-1; ind>=0; ind--){
            for(int tranNo=2*k-1; tranNo>=0; tranNo--){

                int profit = 0;

                if(tranNo % 2 == 0){
                    int buyIt = -prices[ind] + dp[ind+1][tranNo+1];
                    int notBuy = 0 + dp[ind+1][tranNo];

                    profit = Math.max(buyIt, notBuy);
                }
                else{
                    int sell = prices[ind] + dp[ind+1][tranNo+1];
                    int notSell = 0 + dp[ind+1][tranNo];
;

                    profit = Math.max(sell, notSell);
                }

                dp[ind][tranNo] = profit;

            }
        }
        
        return dp[0][0];
    }

    // Tabulation(Space optimized)
    // Time complexity O(n*2k) || Space complexity O(2k)
    public static int solveTabulationOptimized(int prices[], int n, int k){

        int ahead[] = new int[2*k+1];

        for(int ind=n-1; ind>=0; ind--){
            int current[] = new int[2*k+1];

            for(int tranNo=2*k-1; tranNo>=0; tranNo--){

                int profit = 0;

                if(tranNo % 2 == 0){
                    int buyIt = -prices[ind] + ahead[tranNo+1];
                    int notBuy = 0 + ahead[tranNo];

                    profit = Math.max(buyIt, notBuy);
                }
                else{
                    int sell = prices[ind] + ahead[tranNo+1];
                    int notSell = 0 + ahead[tranNo];
;

                    profit = Math.max(sell, notSell);
                }

                current[tranNo] = profit;

            }

            ahead = current;
        }
        
        return ahead[0];
    }

public static int maximumProfit(int[] prices, int n, int k){

        // By using only 2 arrays
        // int dp[][] = new int[n][2*k];

        // for(int a[] : dp){
        //     Arrays.fill(a, -1);
        // }

        // return solveMemoization(prices, n, k, 0, 0, dp);

        // return solveTabulation(prices, n, k);
        return solveTabulationOptimized(prices, n, k);
    }

    public static void main(String args[]){

    }
}