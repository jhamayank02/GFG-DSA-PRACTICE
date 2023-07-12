import java.util.*;

class P249_Count_Square_Submatrices_with_all_Ones{

    // Tabulation
    // Time complexity O(n*m) || Space complexity O(n*m)
    public static int solveTabulation(int n, int m, int arr[][]){

		int dp[][] = new int[n][m];

		int count = 0;

		for(int i=0; i<n; i++){
			dp[i][0] = arr[i][0];

			if(dp[i][0] == 1){
				count++;
			}
		}
		for(int i=1; i<m; i++){
			dp[0][i] = arr[0][i];

			if(dp[0][i] == 1){
				count++;
			}
		}

		for(int i=1; i<n; i++){
			for(int j=1; j<m; j++){

				if(arr[i][j] == 0){
					dp[i][j] = 0;
				}
				else{
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
				}
				count += dp[i][j];

			}
		}

		return count;
	}

	public static int countSquares(int n, int m, int[][] arr) {
		return solveTabulation(n, m, arr);
	}

    public static void main(String args[]){

    }
}