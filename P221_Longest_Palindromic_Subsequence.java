import java.util.*;

class P221_Longest_Palindromic_Subsequence{

    // Tabulation
    // Time complexity O(n * n) || Space complexity O(n*n)
    public static int lcs(int n, String s1, String s2){
		int dp[][] = new int[n+1][n+1];

		// As we are using 1-based indexing we don't need the 0th row and col
		for(int i=0; i<=n; i++){
			dp[0][i] = 0;
		}
		for(int i=0; i<=n; i++){
			dp[i][0] = 0;
		}

		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){

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

		return dp[n][n];
	}

    // Tabulation(Space optimized)
    // Time complexity O(n * n) || Space complexity O(n)
	public static int lcsOptimized(int n, String s1, String s2){
		int prev[] = new int[n+1];

		// As we are using 1-based indexing we don't need the 0th row
		for(int i=0; i<=n; i++){
			prev[i] = 0;
		}

		for(int i=1; i<=n; i++){
			int current[] = new int[n+1];

			for(int j=1; j<=n; j++){

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

		return prev[n];
	}

	public static int longestPalindromeSubsequence(String s) {
		int n = s.length();

		String s2 = "";
		for(int i=n-1; i>=0; i--){
			s2 += s.charAt(i);
		}

		// return lcs(n, s, s2);
		return lcsOptimized(n, s, s2);
	}

    public static void main(String args[]){

    }
}