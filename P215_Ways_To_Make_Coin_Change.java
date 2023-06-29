import java.util.*;

class P215_Ways_To_Make_Coin_Change{

    // Recursion
    // Time complexity >>O(2^n) || Space complexity O(target)
	public static int solveRecusrsive(int ind, int tar, int arr[]){

		// Base case
		if(ind == 0){
			if(tar % arr[0] == 0){
				return 1;
			}
			return 0;
		}

		int notTake = solveRecusrsive(ind-1, tar, arr);

		int take = 0;
		if(arr[ind] <= tar){
			take = solveRecusrsive(ind, tar-arr[ind], arr);
		}

		return take + notTake;
	}
    
    // Memoization
    // Time complexity O(n * target) || Space complexity O(n * target) + O(target)
	public static int solveDP(int ind, int tar, int arr[], int dp[][]){

		// Base case
		if(ind == 0){
			if(tar % arr[0] == 0){
				return 1;
			}
			return 0;
		}

		if(dp[ind][tar] != -1){
			return dp[ind][tar];
		}

		int notTake = solveRecusrsive(ind-1, tar, arr);

		int take = 0;
		if(arr[ind] <= tar){
			take = solveRecusrsive(ind, tar-arr[ind], arr);
		}

		return dp[ind][tar] = take + notTake;
	}

    // Tabulation
    // Time complexity O(n * target) || Space complexity O(n * target)
	public static long solveTabulation(int tar, int arr[]){

		int n = arr.length;

		long dp[][] = new long[n][tar+1];

		// for(int i=arr[0]; i<=tar; i++){
		// 	dp[0][i] = 1;
		// }
		for(int i=0; i<=tar; i++){
			if(i % arr[0] == 0){
				dp[0][i] = 1;
			}
		}

		for(int ind=1; ind<n; ind++){
			for(int k=0; k<=tar; k++){
				long notTake = dp[ind-1][k];

				long take = 0;
				if(arr[ind] <= k){
					take = dp[ind][k-arr[ind]];
				}

				dp[ind][k] = take + notTake;
			}
		}

		return dp[n-1][tar];
	}

    // Tabulation(Space optimized)
    // Time complexity O(n * target) || Space complexity O(target)
	public static long solveTabulationOptimized(int tar, int arr[]){

		int n = arr.length;

		long prev[] = new long[tar+1];

		// for(int i=arr[0]; i<=tar; i++){
		// 	dp[0][i] = 1;
		// }
		for(int i=0; i<=tar; i++){
			if(i % arr[0] == 0){
				prev[i] = 1;
			}
		}

        for(int ind=1; ind<n; ind++){
			long current[] = new long[tar+1];
			for(int k=0; k<=tar; k++){
				long notTake = prev[k];

				long take = 0;
				if(arr[ind] <= k){
					take = current[k-arr[ind]];
				}

				current[k] = take + notTake;
			}
			prev = current;
		}

		return prev[tar];

		return prev[tar];
	}

	public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;

		int dp[][] = new int[n][value+1];
		for(int a[] : dp){
			Arrays.fill(a, -1);
		}
		 
		// return solveRecusrsive(n-1, value, denominations);
		// return solveDP(n-1, value, denominations, dp);
		// return solveTabulation(value, denominations);
        return solveTabulationOptimized(value, denominations);
	}

    public static void main(String args[]){

    }
}