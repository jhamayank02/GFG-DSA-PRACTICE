import java.util.*;

class P204_Maximum_Path_Sum_in_the_matrix{

    public static int solve(int r, int c, int m, int[][] matrix, int[][] dp){
		// Base case
		if(c<0 || c>=m){
			return -(int)1e9;
		}

		if(r==0){
			return matrix[r][c];
		}

		if(dp[r][c] != -1){
			return dp[r][c];
		}

		int leftDiagonal = matrix[r][c] + solve(r-1, c-1, m, matrix, dp);
		int up = matrix[r][c] + solve(r-1, c, m, matrix, dp);
		int rightDiagonal = matrix[r][c] + solve(r-1, c+1, m, matrix, dp);

		dp[r][c] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
		return dp[r][c];
	}

	public static int getMaxPathSum(int[][] matrix) {
        // Memoization
        // Time complexity O(n*m) || Space complexity O(n*m)
		// int n = matrix.length;
		// int m = matrix[0].length;

		// int dp[][] = new int[n][m];
		// for(int i=0; i<n; i++){
		// 	for(int j=0; j<m; j++){
		// 		dp[i][j] = -1;
		// 	}
		// }

		// int maxi = Integer.MIN_VALUE;

		// for(int i=0; i<m; i++){
		// 	int result = solve(n-1, i, m, matrix, dp);
		// 	maxi = Math.max(result, maxi);
		// }

		// return maxi;


        // Tabulation
        // Time complexity O(n*m) || Space complexity O(n*m)
        // int n = matrix.length;
		// int m = matrix[0].length;

		// int dp[][] = new int[n][m];

		// for(int i=0; i<m; i++){
		// 	dp[0][i] = matrix[0][i];
		// }

		// for(int i=1; i<n; i++){
		// 	for(int j=0; j<m; j++){

		// 		int up = matrix[i][j] + dp[i-1][j];
				
		// 		int leftDiagonal= matrix[i][j];

		// 		if(j-1>=0){
		// 			leftDiagonal += dp[i-1][j-1];
		// 		}
		// 		else{
		// 			leftDiagonal += -(int)1e9;
		// 		}
				
		// 		int rightDiagonal = matrix[i][j];

		// 		if(j+1<m){
		// 			rightDiagonal += dp[i-1][j+1];
		// 		}
		// 		else{
		// 			rightDiagonal += -(int)1e9;
		// 		}
				
		// 		dp[i][j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));
		// 	}
		// }

		// int maxi = -(int)1e9;

		// for(int i=0; i<m; i++){
		// 	maxi = Math.max(maxi, dp[n-1][i]);
		// }

		// return maxi;



        // Tabulation
        // Time complexity O(n*m) || Space complexity O(m)
        int n = matrix.length;
		int m = matrix[0].length;

		int prev[] = new int[m];

		for(int i=0; i<m; i++){
			prev[i] = matrix[0][i];
		}

		for(int i=1; i<n; i++){
			int current[] = new int[m];

			for(int j=0; j<m; j++){

				int up = matrix[i][j] + prev[j];
				int leftDiagonal = matrix[i][j];
				int rightDiagonal = matrix[i][j];

				if(j-1>=0){
					leftDiagonal += prev[j-1];
				}
				else{
					leftDiagonal += -(int)1e9;
				}

				if(j+1<m){
					rightDiagonal += prev[j+1];
				}
				else{
					rightDiagonal += -(int)1e9;
				}

				current[j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
			}

			prev = current;
		}

		int maxi = -(int)1e9;

		for(int i=0; i<m; i++){
			maxi = Math.max(maxi, prev[i]);
		}

		return maxi;
	}

    public static void main(String args[]){

    }
}