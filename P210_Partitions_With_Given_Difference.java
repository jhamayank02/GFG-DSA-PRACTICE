import java.util.*;

class P210_Partitions_With_Given_Difference{

    	static int mod =(int)(Math.pow(10,9)+7);

	public static int solve(int ind, int target, int arr[], int dp[][]){
		// Base case
		if(ind == 0){
			if(target == 0 && arr[0]==0){
				return 2;
			}
			if(target == 0 || target == arr[0]){
				return 1;
			}
			return 0;
		}

		if(dp[ind][target] != -1){
			return dp[ind][target];
		}

		int notPick = solve(ind-1, target, arr, dp);
		int pick = 0;
		if(arr[ind] <= target){
			pick = solve(ind-1, (target-arr[ind]), arr, dp) ;
		}

		return dp[ind][target] = (pick + notPick) % mod;
	}

	public static int countPartitions(int n, int d, int[] arr) {

        // Memoization
        // Time complexity O(n * s2) || Space complexity O(n * s2)
		// int totalSum = 0;
		// for(int i=0; i<n; i++){
		// 	totalSum += arr[i];
		// }
		
		// if(totalSum-d < 0 || (totalSum-d) % 2 != 0){
		// 	return 0;
		// }

		// int s2 = (totalSum - d)/2;

		// int dp[][] = new int[n][s2+1];

		// for(int a[] : dp){
		// 	Arrays.fill(a, -1);
		// }

		// return solve(n-1, s2, arr, dp);






        // Tabulation
        // Time complexity O(n * s2) || Space complexity O(n * s2)
	}

    public static void main(String args[]){
        int a[] = {1, 0, 8, 5, 1, 4};
        System.out.println(countPartitions(6, 17, a));
    }
}