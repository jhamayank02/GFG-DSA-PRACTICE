import java.util.*;

class P233_Best_Time_to_Buy_and_Sell_Stock_3{

    // Recursion
    // Time complexity O(2^n) || Space complexity O(n)
    public static int solveRecursive(ArrayList<Integer> prices, int n, int ind, int buy, int cap){

		// Base case
		if(cap == 0 || ind == n){
			return 0;
		}

		int profit = 0;
		
		if(buy == 1){
			int buyIt = -prices.get(ind) + solveRecursive(prices, n, ind+1, 0, cap);
			int notBuy = 0 + solveRecursive(prices, n, ind+1, buy, cap);

			profit = Math.max(buyIt, notBuy);
		}
		else{
			int sell = prices.get(ind) + solveRecursive(prices, n, ind+1, 1, cap-1);
			int notSell = 0 + solveRecursive(prices, n, ind+1, buy, cap);

			profit = Math.max(sell, notSell);
		}

		return profit;
	}

    // Memoization
    // Time complexity O(n*2*3) || Space complexity O(n*2*3) + O(n)
	public static int solveMemoization(ArrayList<Integer> prices, int n, int ind, int buy, int cap, int dp[][][]){

		// Base case
		if(cap == 0 || ind == n){
			return 0;
		}

		if(dp[ind][buy][cap] != -1) {
			return dp[ind][buy][cap];
		}

		int profit = 0;
		
		if(buy == 1){
			int buyIt = -prices.get(ind) + solveMemoization(prices, n, ind+1, 0, cap, dp);
			int notBuy = 0 + solveMemoization(prices, n, ind+1, buy, cap, dp);

			profit = Math.max(buyIt, notBuy);
		}
		else{
			int sell = prices.get(ind) + solveMemoization(prices, n, ind+1, 1, cap-1, dp);
			int notSell = 0 + solveMemoization(prices, n, ind+1, buy, cap, dp);

			profit = Math.max(sell, notSell);
		}

		return dp[ind][buy][cap] = profit;
	}

    // Tabulation
    // Time complexity O(n*2*3) || Space complexity O(n*2*3)
	public static int solveTabulation(ArrayList<Integer> prices, int n){

		int dp[][][] = new int[n+1][2][3];

		for(int ind=n-1; ind>=0; ind--){
			for(int buy=0; buy<=1; buy++){
				for(int cap=1; cap<=2; cap++){

					int profit = 0;
		
					if(buy == 1){
						int buyIt = -prices.get(ind) + dp[ind+1][0][cap];
						int notBuy = 0 + dp[ind+1][buy][cap];

						profit = Math.max(buyIt, notBuy);
					}
					else{
						int sell = prices.get(ind) + dp[ind+1][1][cap-1];
						int notSell = 0 + dp[ind+1][buy][cap];

						profit = Math.max(sell, notSell);
					}

					dp[ind][buy][cap] = profit;

				}
			}
		}

		return dp[0][1][2];
	}

    // Tabulation(Space optimized)
    // Time complexity O(n*2*3) || Space complexity O(2*3)
	public static int solveTabulationOptimized(ArrayList<Integer> prices, int n){

		int after[][] = new int[2][3];

		for(int ind=n-1; ind>=0; ind--){
			int current[][] = new int[2][3];

			for(int buy=0; buy<=1; buy++){
				for(int cap=1; cap<=2; cap++){

					int profit = 0;
		
					if(buy == 1){
						int buyIt = -prices.get(ind) + after[0][cap];
						int notBuy = 0 + after[buy][cap];

						profit = Math.max(buyIt, notBuy);
					}
					else{
						int sell = prices.get(ind) + after[1][cap-1];
						int notSell = 0 + after[buy][cap];

						profit = Math.max(sell, notSell);
					}

					current[buy][cap] = profit;

				}
			}
			after = current;
		}

		return after[1][2];
	}

	public static int maxProfit(ArrayList<Integer> prices, int n) {
		// int dp[][][] = new int[n][2][3];

		// for(int a[][] : dp){
		// 	for(int b[] : a){
		// 		Arrays.fill(b, -1);
		// 	}
		// }

		// return solveMemoization(prices, n, 0, 1, 2, dp);
		// return solveRecursive(prices, n, 0, 1, 2);
		// return solveTabulation(prices, n);
		return solveTabulationOptimized(prices, n);
	}

    public static void main(String args[]){

    }
}