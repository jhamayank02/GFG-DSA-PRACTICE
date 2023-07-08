import java.util.*;

class P243_Matrix_Chain_Multiplication{

    // Recursion
    // Time complexity Exponential || Space complexity O(N)
    public static int solve(int arr[], int i, int j){

		// Base case
		if(i == j){
			return 0;
		}

		int mini = Integer.MAX_VALUE;

		for(int k=i; k<=j-1; k++){
			int steps = arr[i-1]*arr[k]*arr[j] + solve(arr, i, k) + solve(arr, k+1, j);

			mini = Math.min(mini, steps);
		}

		return mini;
	}

    // Memoization
    // Time complexity O(N^3) || Space complexity O(N^2) + O(N)
	public static int solveMemoization(int arr[], int i, int j, int dp[][]){
		// Base case
		if(i == j){
			return 0;
		}

		if(dp[i][j] != -1){
			return dp[i][j];
		}

		int mini = Integer.MAX_VALUE;

		for(int k=i; k<=j-1; k++){
			int steps = arr[i-1]*arr[k]*arr[j] + solveMemoization(arr, i, k, dp) + solveMemoization(arr, k+1, j, dp);

			mini = Math.min(mini, steps);
		}

		return dp[i][j] = mini;
	}

	public static int matrixMultiplication(int[] arr , int N) {
		
		// return solve(arr, 1, N-1);

		int dp[][] = new int[N][N];
		for(int a[] : dp){
			Arrays.fill(a, -1);
		}

		return solveMemoization(arr, 1, N-1, dp);
	}

    public static void main(String args[]){

    }
}