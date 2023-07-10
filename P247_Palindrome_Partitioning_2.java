import java.util.*;

class P247_Palindrome_Partitioning_2{

    // Time complexity O(n) || Space complexity O(1)
    public static boolean isPalindrome(int i, int j, String str){
		while(i<j){
			if(str.charAt(i) != str.charAt(j)){
				return false;
			}
			i++;
			j--;
		}

		return true;
	}
    
    // Recursion
    // Time complexity Exponential || Space complexity O(n)
	public static int solveRecursive(int i, int n, String str){
		// Base case
		if(i==n){
			return 0;
		}
		
		int minCost = Integer.MAX_VALUE;

		for(int j=i; j<n; j++){

			if(isPalindrome(i, j, str)){
				int cost = 1 + solveRecursive(j+1, n, str);
				minCost = Math.min(minCost, cost);
			}
		}

		return minCost;
	}


    // Memoization
    // Time complexity O(n^2) || Space complexity O(n) + O(n)
	public static int solveMemoization(int i, int n, String str, int dp[]){
		// Base case
		if(i==n){
			return 0;
		}

		if(dp[i] != -1){
			return dp[i];
		}
		
		int minCost = Integer.MAX_VALUE;

		for(int j=i; j<n; j++){

			if(isPalindrome(i, j, str)){
				int cost = 1 + solveMemoization(j+1, n, str, dp);
				minCost = Math.min(minCost, cost);
			}
		}

		return dp[i] = minCost;
	}

    // Tabulation
    // Time complexity O(n^2) || Space complexity O(n)
	public static int solveTabulation(String str, int n){
		int dp[] = new int[n+1];

		dp[n] = 0;

		for(int i=n-1; i>=0; i--){

			int minCost = Integer.MAX_VALUE;

			for(int j=i; j<n; j++){

			if(isPalindrome(i, j, str)){
				int cost = 1 + dp[j+1];
				minCost = Math.min(minCost, cost);
			}

			}

			dp[i] = minCost;
		}

		return dp[0];
	}

	public static int palindromePartitioning(String str) {
	    int n = str.length();
		// - 1 because the code is also doing a partition at n, which is of no use
		// return solveRecursive(0, n, str) - 1;

		// int dp[] = new int[n];

		// Arrays.fill(dp, -1);

		// - 1 because the code is also doing a partition at n, which is of no use
		// return solveMemoization(0, n, str, dp) - 1;

		// - 1 because the code is also doing a partition at n, which is of no use
		return solveTabulation(str, n)-1;
	}

    public static void main(String args[]){

    }
}