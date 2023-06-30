import java.util.*;

class P220_Longest_Common_Substring{

    // Tabulation
    // Time complexity O(n * m) || Space complexity O(n * m)
    public static int solveTabulation(int n, int m, String str1, String str2){
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0; i<=m; i++){
			dp[0][i] = 0;
		}
		for(int i=0; i<=n; i++){
			dp[i][0] = 0;
		}

		int maxi = Integer.MIN_VALUE;

		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){

				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];

					maxi = Math.max(maxi, dp[i][j]);
				}
				else{
					dp[i][j] = 0;
				}

			}
		}

		if(maxi == Integer.MIN_VALUE){
			return 0;
		}

		return maxi;
	}

    // Tabulation(Space optimized)
    // Time complexity O(n * m) || Space complexity O(m)
	public static int solveTabulationOptimized(int n, int m, String str1, String str2){
		int prev[] = new int[m+1];
		
		for(int i=0; i<=m; i++){
			prev[i] = 0;
		}

		int maxi = Integer.MIN_VALUE;

		for(int i=1; i<=n; i++){
			int current[] = new int[m+1];

			for(int j=1; j<=m; j++){

				if(str1.charAt(i-1) == str2.charAt(j-1)){
					current[j] = 1 + prev[j-1];

					maxi = Math.max(maxi, current[j]);
				}
				else{
					current[j] = 0;
				}

			}

			prev = current;
		}

		if(maxi == Integer.MIN_VALUE){
			return 0;
		}

		return maxi;
	}
	
	public static int lcs(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		// return solveTabulation(n, m, str1, str2);
		return solveTabulationOptimized(n, m, str1, str2);
	}

    public static void main(String args[]){

    }
}