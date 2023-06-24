import java.util.*;

class P201_Unique_Paths{

    public static int solveRecursive(int r, int c){

		if(r==0 && c==0){
			return 1;
		}
		if(r<0 || c<0){
			return 0;
		}

		int up = solve(r-1, c, dp);
		int left = solve(r, c-1, dp);

		return up + left;
	}

    public static int solve(int r, int c, int dp[][]){

		if(r==0 && c==0){
			return 1;
		}
		if(r<0 || c<0){
			return 0;
		}

		if(dp[r][c] != -1){
			return dp[r][c];
		}

		int up = solve(r-1, c, dp);
		int left = solve(r, c-1, dp);

		return dp[r][c] = up + left;
	}

	public static int uniquePaths(int m, int n) {
        // Recursion
        // Time complexity O(2^mn) || Space complexity O((m-1)+(n-1))
        // return solveRecursive(m-1, n-1);

        // Memoization
        // Time complexity O(mn) || Space complexity O(mn)
		// int dp[][] = new int[m][n];
		// for(int i=0; i<m; i++){
		// 	for(int j=0; j<n; j++){
		// 		dp[i][j] = -1;
		// 	}
		// }

		// return solve(m-1, n-1, dp);



        // Tabulation
        // Time complexity O(mn) || Space complexity O(mn)
        // int dp[][] = new int[m][n];

		// for(int i=0; i<m; i++){
		// 	for(int j=0; j<n; j++){
		// 		if(i==0 && j==0){
		// 			dp[i][j] = 1;
		// 		}
		// 		else{
		// 			int left=0, up=0;
					
		// 			if(i>0){
		// 				up = dp[i-1][j];
		// 			}
		// 			if(j>0){
		// 				left = dp[i][j-1];
		// 			}

		// 			dp[i][j] = up + left;
		// 		}
		// 	}
		// }

		// return dp[m-1][n-1];



        // Tabulation(Space Optimized)
        // Time complexity O(mn) || Space complexity O(n)
        int prev[] = new int[n];

		for(int i=0; i<m; i++){

			int current[] = new int[n];

			for(int j=0; j<n; j++){
				if(i==0 && j==0){
					current[j] = 1;
				}
				else{
					int left=0, up=0;
					
					if(i>0){
						up = prev[j];
					}
					if(j>0){
						left = current[j-1];
					}

					current[j] = up + left;
				}
			}

			prev = current;
		}

		return prev[n-1];


	}

    public static void main(String args[]){

    }
}