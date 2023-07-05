import java.util.*;

class P235_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_5{

    // Recursion
    // Time complexity O(2^n) || Space complexity O(n)
    public static int solveRecursive(int ind, int buy, int n, int[] prices){

		// Base case
		if(ind>=n){
			return 0;
		}

		int profit = 0;

		if(buy==1){
			int buyIt = -prices[ind] + solveRecursive(ind+1, 0, n, prices);
			int notBuy = 0 + solveRecursive(ind+1, 1, n, prices);

			profit = Math.max(buyIt, notBuy);
		}
		else{
			int sell = prices[ind] + solveRecursive(ind+2, 1, n, prices);
			int notSell = 0 + solveRecursive(ind+1, 0, n, prices);

			profit = Math.max(sell, notSell);
		}

		return profit;
	}

    // Memoization
    // Time complexity O(n*2) || Space complexity O(n*2) + O(n)
	public static int solveMemoization(int ind, int buy, int n, int[] prices, int dp[][]){

		// Base case
		if(ind>=n){
			return 0;
		}

		if(dp[ind][buy] != -1){
			return dp[ind][buy];
		}

		int profit = 0;

		if(buy==1){
			int buyIt = -prices[ind] + solveMemoization(ind+1, 0, n, prices, dp);
			int notBuy = 0 + solveMemoization(ind+1, 1, n, prices, dp);

			profit = Math.max(buyIt, notBuy);
		}
		else{
			int sell = prices[ind] + solveMemoization(ind+2, 1, n, prices, dp);
			int notSell = 0 + solveMemoization(ind+1, 0, n, prices, dp);

			profit = Math.max(sell, notSell);
		}

		return dp[ind][buy] = profit;
	}

    // Tabulation
    // Time complexity O(n*2) || Space complexity O(n*2)
	public static int solveTabulation(int n, int prices[]){

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
					int sell = prices[ind] + dp[ind+2][1];
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
	public static int solveTabulationOptimized(int n, int prices[]){

		int ahead2[] = new int[2];
		int ahead1[] = new int[2];

		for(int ind=n-1; ind>=0; ind--){
			int curr[] = new int[2];

			for(int buy=0; buy<=1; buy++){

				int profit = 0;

				if(buy==1){
					int buyIt = -prices[ind] + ahead1[0];
					int notBuy = 0 + ahead1[1];

					profit = Math.max(buyIt, notBuy);
				}
				else{
					int sell = prices[ind] + ahead2[1];
					int notSell = 0 + ahead1[0];

					profit = Math.max(sell, notSell);
				}

				curr[buy] = profit;
			}
			ahead2 = ahead1;
			ahead1 = curr;
		}

		return ahead1[1];
	}

	public static int stockProfit(int[] prices) {
		int n = prices.length;
		// return solveRecursive(0, 1, n, prices);

		// int dp[][] = new int[n][2];
		// for(int a[] : dp){
		// 	Arrays.fill(a, -1);
		// }
		// return solveMemoization(0, 1, n, prices, dp);

		// return solveTabulation(n, prices);
		return solveTabulationOptimized(n, prices);
	}

    public static void main(String args[]){

    }
}