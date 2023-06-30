import java.util.*;

class P218_Longest_Common_Subsequence{

    // Recursion
    // Time complexity O(2^n * 2^m) || Space complexity O(n+m)
    public static int solve(int ind1, int ind2, String s1, String s2){

		// Base case
		if(ind1 < 0 || ind2 < 0){
			return 0;
		}


		// If match
		if(s1.charAt(ind1) == s2.charAt(ind2)){
			return 1 + solve(ind1-1, ind2-1, s1, s2);
		}

		// If not match
		return 0 + Math.max(solve(ind1-1, ind2, s1, s2), solve(ind1, ind2-1, s1, s2));
	}


    // Memoization
    // Time complexity O(n * m) || Space complexity O(n*m) + O(n+m)
	public static int solveMemoization(int ind1, int ind2, String s1, String s2, int dp[][]){

		// Base case
		if(ind1 < 0 || ind2 < 0){
			return 0;
		}

		if(dp[ind1][ind2] != -1){
			return dp[ind1][ind2];
		}

		// If match
		if(s1.charAt(ind1) == s2.charAt(ind2)){
			return dp[ind1][ind2] = 1 + solveMemoization(ind1-1, ind2-1, s1, s2, dp);
		}

		// If not match
		return dp[ind1][ind2] = 0 + Math.max(solveMemoization(ind1-1, ind2, s1, s2, dp), solveMemoization(ind1, ind2-1, s1, s2, dp));
	}

    // Tabulation
    // Time complexity O(n * m) || Space complexity O(n*m)
	public static int solveTabulation(int n, int m, String s1, String s2){

		int dp[][] = new int[n+1][m+1];

		for(int j=0; j<=m; j++){
			dp[0][j] = 0;
		}
		for(int i=0; i<=n; i++){
			dp[i][0] = 0;
		}

		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){

				// If match
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				// If not match
				else{
					dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
				}

			}
		}

		return dp[n][m];
	}

    
    // Tabulation(Space Optimized)
    // Time complexity O(n * m) || Space complexity O(m)
    public static int solveTabulationOptimized(int n, int m, String s1, String s2){

		int prev[] = new int[m+1];

		for(int j=0; j<=m; j++){
			prev[j] = 0;
		}
		

		for(int i=1; i<=n; i++){
			int current[] = new int[m+1];


			for(int j=1; j<=m; j++){

				// If match
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					current[j] = 1 + prev[j-1];
				}
				// If not match
				else{
					current[j] = 0 + Math.max(prev[j], current[j-1]);
				}

			}

			prev = current;
		}

		return prev[m];
	}

    public static int lcs(String s, String t) {
		int n = s.length();
		int m = t.length();

		int dp[][] = new int[n+1][m+1];
		for(int arr[] : dp){
			Arrays.fill(arr, -1);
		}

		// return solve(n-1, m-1, s, t);
		// return solveMemoization(n-1, m-1, s, t, dp);
		// return solveTabulation(n, m, s, t);
		return solveTabulationOptimized(n, m, s, t);
    }

    public static void main(String args[]){

    }
}