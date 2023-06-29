import java.util.*;

class P217_Rod_cutting_problem{

    // Memoization
    // Time complexity O(n^2) || Space complexity O(n^2)
    public static int solve(int ind, int tar, int price[], int dp[][]){
		// Base case
		if(ind == 0){
			int rod_length = ind + 1;
			return (tar / rod_length) * price[ind];
		}

		if(dp[ind][tar] != -1){
			return dp[ind][tar];
		}

		int notTake = 0 + solve(ind-1, tar, price, dp);

		int take = Integer.MIN_VALUE;
		int rod_length = ind + 1;

		if(rod_length <= tar){
			take = price[ind] + solve(ind, tar-rod_length, price, dp);
		}

		return dp[ind][tar] = Math.max(take, notTake);
	}

    // Tabulation
    // Time complexity O(n^2) || Space complexity O(n^2)
    public static int solveTabulation(int n, int price[]){

		int dp[][] = new int[n][n+1];

		for(int i=1; i<=n; i++){
			// As first index will always indicate the length 1
			// dp[0][i] = i * price[0];

			// Can also be written as
			int rod_length = 1;
			dp[0][i] = (i / rod_length) * price[0];
		}

		for(int ind=1; ind<n; ind++){
			for(int tar=0; tar<=n; tar++){

				int notTake = 0 + dp[ind-1][tar];

				int take = Integer.MIN_VALUE;
				int rod_length = ind + 1;

				if(rod_length <= tar){
					take = price[ind] + dp[ind][tar-rod_length];
				}

				dp[ind][tar] = Math.max(take, notTake);
			}
		}

		return dp[n-1][n];
	}


    // Tabulation(Space optimized)
    // Time complexity O(n^2) || Space complexity O(n)
	public static int solveTabulationOptimized(int n, int price[]){

		int prev[] = new int[n+1];

		for(int i=1; i<=n; i++){
			prev[i] = i * price[0];
		}

        // **************** USing two 1D array ****************

		// for(int ind=1; ind<n; ind++){
		// 	int current[] = new int[n+1];

		// 	for(int tar=0; tar<=n; tar++){

		// 		int notTake = 0 + prev[tar];

		// 		int take = Integer.MIN_VALUE;
		// 		int rod_length = ind + 1;

		// 		if(rod_length <= tar){
		// 			take = price[ind] + current[tar-rod_length];
		// 		}

		// 		current[tar] = Math.max(take, notTake);
		// 	}
		// 	prev = current;
		// }



        // **************** USing a single 1D array ****************

		for(int ind=1; ind<n; ind++){
			for(int tar=0; tar<=n; tar++){

				int notTake = 0 + prev[tar];

				int take = Integer.MIN_VALUE;
				int rod_length = ind + 1;

				if(rod_length <= tar){
					take = price[ind] + prev[tar-rod_length];
				}

				prev[tar] = Math.max(take, notTake);
			}
		}

		return prev[n];
	}


	public static int cutRod(int price[], int n) {
		int dp[][] = new int[n][n+1];
		for(int a[] : dp){
			Arrays.fill(a, -1);
		}

		return solve(n-1, n, price, dp);
	}

    public static void main(String args[]){

    }
}