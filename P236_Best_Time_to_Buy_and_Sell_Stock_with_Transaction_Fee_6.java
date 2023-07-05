import java.util.*;

class P236_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_6{

    // Recursion
    // Time complexity O(2^n) || Space complexity O(n)
    public static int solveRecursive(int ind, int buy, int n, int fee, int[] prices){

		// Base case
		if(ind==n){
			return 0;
		}

		int profit = 0;

		if(buy==1){
			int buyIt = -prices[ind] + solveRecursive(ind+1, 0, n, fee, prices);
			int notBuy = 0 + solveRecursive(ind+1, 1, n, fee, prices);

			profit = Math.max(buyIt, notBuy);
		}
		else{
			int sell = prices[ind] - fee + solveRecursive(ind+1, 1, n, fee, prices);
			int notSell = 0 + solveRecursive(ind+1, 0, n, fee, prices);

			profit = Math.max(sell, notSell);
		}

		return profit;
	}

    // Memoization
    // Time complexity O(n*2) || Space complexity O(n*2) + O(n)
	public static int solveMemoization(int ind, int buy, int n, int fee, int[] prices, int dp[][]){

		// Base case
		if(ind==n){
			return 0;
		}

		if(dp[ind][buy] != -1){
			return dp[ind][buy];
		}

		int profit = 0;

		if(buy==1){
			int buyIt = -prices[ind] + solveMemoization(ind+1, 0, n, fee, prices, dp);
			int notBuy = 0 + solveMemoization(ind+1, 1, n, fee, prices, dp);

			profit = Math.max(buyIt, notBuy);
		}
		else{
			int sell = prices[ind] - fee + solveMemoization(ind+1, 1, n, fee, prices, dp);
			int notSell = 0 + solveMemoization(ind+1, 0, n, fee, prices, dp);

			profit = Math.max(sell, notSell);
		}

		return dp[ind][buy] = profit;
	}

    // Tabulation
    // Time complexity O(n*2) || Space complexity O(n*2)
    public static int solveTabulation(int n, int fee, int prices[]){

		int dp[][] = new int[n+2][2];

		for(int ind=n; ind<=n+1; ind++){
			for(int buy=0; buy<=1; buy++){
				dp[ind][buy] = 0;
			}
		}

		for(int ind=n-1; ind>=0; ind--){
			for(int buy=0; buy<=1; buy++){

				int profit = 0;

				if(buy==1){
					int buyIt = -prices[ind] + dp[ind+1][0];
					int notBuy = 0 + dp[ind+1][1];

					profit = Math.max(buyIt, notBuy);
				}
				else{
					int sell = prices[ind] - fee + dp[ind+1][1];
					int notSell = 0 + dp[ind+1][0];

					profit = Math.max(sell, notSell);
				}

				dp[ind][buy] = profit;
			}
		}

		return dp[0][1];
	}

    // Tabulation(Space optimized)
    // Time complexity O(n*2) || Space complexity O(2)
    public static int solveTabulationOptimized(int n, int fee, int prices[]){

		int ahead[] = new int[2];

		for(int ind=n-1; ind>=0; ind--){
			int curr[] = new int[2];

			for(int buy=0; buy<=1; buy++){

				int profit = 0;

				if(buy==1){
					int buyIt = -prices[ind] + ahead[0];
					int notBuy = 0 + ahead[1];

					profit = Math.max(buyIt, notBuy);
				}
				else{
					int sell = prices[ind] - fee + ahead[1];
					int notSell = 0 + ahead[0];

					profit = Math.max(sell, notSell);
				}

				curr[buy] = profit;
			}
			ahead = curr;
		}

		return ahead[1];
	}

	public static int maximumProfit(int n, int fee, int[] prices) {
		// return solveRecursive(0, 1, n, fee, prices);

		int dp[][] = new int[n][2];
		for(int a[] : dp){
			Arrays.fill(a, -1);
		}
		return solveMemoization(0, 1, n, fee, prices, dp);

		// return solveTabulation(n, fee, prices);
		// return solveTabulationOptimized(n, fee, prices);
	}

    public static void main(String args[]){

    }
}