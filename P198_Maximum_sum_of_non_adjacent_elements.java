import java.util.*;

class P198_Maximum_sum_of_non_adjacent_elements{

    public static int solve(int ind, ArrayList<Integer> nums, int dp[]){
		if(ind < 0){
			return 0;
		}
		if(ind == 0){
			return nums.get(0);
		}

		if(dp[ind] != -1){
			return dp[ind];
		}

		int pick = nums.get(ind) + solve(ind-2, nums, dp);
		int notPick = 0 + solve(ind-1, nums, dp);

		return dp[ind] = Math.max(pick, notPick);
	}

    public static int solveRecursion(int ind, ArrayList<Integer> nums){
		if(ind < 0){
			return 0;
		}
		if(ind == 0){
			return nums.get(0);
		}

		int pick = nums.get(ind) + solveRecursion(ind-2, nums);
		int notPick = 0 + solveRecursion(ind-1, nums);

		return Math.max(pick, notPick);
	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		
        // Using Recursion
        // Time complexity O(2^n) || Space complexity O(n)
		// int n = nums.size();
        // return solveRecursion(n-1, nums)

        // Using Memoization
        // Time complexity O(n) || Space complexity O(n)
		// int n = nums.size();
		// int dp[] = new int[n];
		// Arrays.fill(dp, -1);

		// return solve(n-1, nums, dp);


        // Using Tabulation
        // Time complexity O(n) || Space complexity O(n)
		// int n = nums.size();
		// int dp[] = new int[n];
		// Arrays.fill(dp, -1);

		// dp[0] = nums.get(0);

		// for(int i=1; i<n; i++){

		// 	int pick = nums.get(i);
		// 	if(i>1){
		// 		pick += dp[i-2];
		// 	}

		// 	int notPick = 0 + dp[i-1];

		// 	dp[i] = Math.max(pick, notPick);

		// }
		// return dp[n-1];

        // Using Tabulation (Space optimized)
        // Time complexity O(n) || Space complexity O(1)
        int n = nums.size();

		int prev1 = nums.get(0);
		int prev2 = 0;

		for(int i=1; i<n; i++){

			int pick = nums.get(i) + prev2;

			int notPick = 0 + prev1;

			int curri = Math.max(pick, notPick);

			prev2 = prev1;
			prev1 = curri;
		}

		return prev1;
	}

    public static void main(String args[]){

    }
}