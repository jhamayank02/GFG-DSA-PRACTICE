import java.util.*;

class P207_Partition_Equal_Subset_Sum{

    public static boolean solve(int ind, int target, int arr[]){

		// Base case
		if(target == 0){
			return true;
		}
		if(ind == 0){
			return (arr[ind] == target);
		}

		boolean not_take = solve(ind-1, target, arr);

		boolean take = false;
		if(target >= arr[ind]){
			take = solve(ind-1, (target-arr[ind]), arr);
		}

		return take || not_take;
	}

    public static boolean solveDP(int ind, int target, int arr[], int dp[][]){

		// Base case
		if(target == 0){
			return true;
		}
		if(ind == 0){
			return (arr[ind] == target);
		}

		if(dp[ind][target] != -1){
			return (dp[ind][target] == 1 ? true:false);
		}

		boolean not_take = solveDP(ind-1, target, arr, dp);

		boolean take = false;
		if(target >= arr[ind]){
			take = solveDP(ind-1, (target-arr[ind]), arr, dp);
		}

		dp[ind][target] = (take || not_take ? 1:0);
		return take || not_take;
	}

	public static boolean canPartition(int[] arr, int n) {
        // Recursion
        // Time complexity O(2^n) || Space complexity O(n)
		// int S = 0;

		// for(int i=0; i<n; i++){
		// 	S += arr[i];
		// }

		// if(S%2 != 0){
		// 	return false;
		// }

		// return solve(n-1, S/2, arr);




        // Memoization
        // Time complexity O(n*target) || Space complexity O(n*target)

        // dp[ind][target] = 0 -> false
        // dp[ind][target] = 1 -> true
        // dp[ind][target] = -1 -> not visited

        // int S = 0;

		// for(int i=0; i<n; i++){
		// 	S += arr[i];
		// }

		// if(S%2 != 0){
		// 	return false;
		// }

		// int dp[][] = new int[n][S/2+1];
		
		// for(int i=0; i<n; i++){
		// 	for(int j=0; j<(S/2+1); j++){
		// 		dp[i][j] = -1;
		// 	}
		// }

		// return solve(n-1, S/2, arr, dp);




        // Tabulation
        // Time complexity O(n*target) || Space complexity O(n*target)
        // int S = 0;

		// for(int i=0; i<n; i++){
		// 	S += arr[i];
		// }

		// if(S%2 != 0){
		// 	return false;
		// }

		// boolean dp[][] = new boolean[n][S/2+1];
		
		// for(int i=0; i<n; i++){
		// 	dp[i][0] = true;
		// }


		// for(int ind=1; ind<n; ind++){
		// 	for(int target=0; target<=(S/2); target++){

		// 		boolean not_take = dp[ind-1][target];

		// 		boolean take = false;
		// 		if(target >= arr[ind]){
		// 			take = dp[ind-1][target-arr[ind]];
		// 		}

		// 		dp[ind][target] = take || not_take;
		// 	}
		// }


		// return dp[n-1][S/2];




        // Tabulation(Space optimized)
        // Time complexity O(n*target) || Space complexity O(target/2 + 1) = O(target)
        int S = 0;

		for(int i=0; i<n; i++){
			S += arr[i];
		}

		if(S%2 != 0){
			return false;
		}

		boolean prev[] = new boolean[S/2+1];
		
		prev[0] = true;

		if(arr[0] <= S/2){
			prev[arr[0]] = true;
		}

		for(int ind=1; ind<n; ind++){
			boolean current[] = new boolean[S/2+1];		

			for(int target=0; target<=(S/2); target++){

				boolean not_take = prev[target];

				boolean take = false;
				if(target >= arr[ind]){
					take = prev[target-arr[ind]];
				}

				current[target] = take || not_take;
			}

			prev = current;
		}


		return prev[S/2];
	}

    public static void main(String args[]){

    }
}