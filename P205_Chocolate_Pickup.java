import java.util.*;

class P205_Chocolate_Pickup{

    static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int)(Math.pow(-10, 9));
        }

        if (i == n - 1) {
            if (j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                if (j1 == j2){
                    ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
                }
                else{
                    ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj,n,m, grid, dp);
                }
                maxi = Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2] = maxi;
  }
	public static int maximumChocolates(int r, int c, int[][] grid) {
        // Memoization
        // Time complexity O(3^n * 3^n) || Space complexity O(n) + O(n*m*m)
		// int dp[][][] = new int[r][c][c];

		// for(int i=0; i<r; i++){
		// 	for(int j=0; j<c; j++){
		// 		for(int k=0; k<c; k++){
		// 			dp[i][j][k] = -1;
		// 		}
		// 	}	
		// }
		// // for (int row1[][]: dp) {
		// // 	for (int row2[]: row1) {
		// // 		Arrays.fill(row2, -1);
		// // 	}
    	// // }

		// return maxChocoUtil(0, 0, c-1, r, c, grid, dp);



        // Tabulation
        // Time complexity O(n * m * m) * 9 || Space complexity O(n * m * m)
        // int dp[][][] = new int[r][c][c];


		// for(int j1=0; j1<c; j1++){
		// 	for(int j2=0; j2<c; j2++){

		// 		if(j1 == j2){
		// 			dp[r-1][j1][j2] = grid[r-1][j1];
		// 		}
		// 		else{
		// 			dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
		// 		}
		// 	}
		// }

		// for(int i=r-2; i>=0; i--){
		// 	for(int j1=0; j1<c; j1++){
		// 		for(int j2=0; j2<c; j2++){

		// 			int maxi = -(int)1e9;

		// 			for (int di = -1; di <= 1; di++) {
		// 				for (int dj = -1; dj <= 1; dj++) {
		// 					int ans = 0;
		// 					if (j1 == j2){
		// 						ans = grid[i][j1]; 
		// 					}
		// 					else{
		// 						ans = grid[i][j1] + grid[i][j2];
		// 					}
							
		// 					if(j1+di>=0 && j1+di<c && j2+dj>=0 && j2+dj<c){
		// 						ans += dp[i+1][j1+di][j2+dj];
		// 					}
		// 					else{
		// 						ans += -(int)1e9;
		// 					}

		// 					maxi = Math.max(maxi, ans);
		// 				}
		// 			}
		// 			dp[i][j1][j2] = maxi;
		// 		}
		// 	}
		// }

		// return dp[0][0][c-1];




        // Tabulation(Space optimized)
        // Time complexity O(n * m * m) * 9 || Space complexity O(m * m)
        int prev[][] = new int[c][c];


		for(int j1=0; j1<c; j1++){
			for(int j2=0; j2<c; j2++){

				if(j1 == j2){
					prev[j1][j2] = grid[r-1][j1];
				}
				else{
					prev[j1][j2] = grid[r-1][j1] + grid[r-1][j2];
				}
			}
		}

		for(int i=r-2; i>=0; i--){
			int current[][] = new int[c][c];

			for(int j1=0; j1<c; j1++){
				for(int j2=0; j2<c; j2++){

					int maxi = -(int)1e9;

					for (int di = -1; di <= 1; di++) {
						for (int dj = -1; dj <= 1; dj++) {
							int ans = 0;
							if (j1 == j2){
								ans = grid[i][j1]; 
							}
							else{
								ans = grid[i][j1] + grid[i][j2];
							}
							
							if(j1+di>=0 && j1+di<c && j2+dj>=0 && j2+dj<c){
								ans += prev[j1+di][j2+dj];
							}
							else{
								ans += -(int)1e9;
							}

							maxi = Math.max(maxi, ans);
						}
					}
					current[j1][j2] = maxi;
				}
			}

			prev = current;
		}

		return prev[0][c-1];
	}

    public static void main(String args[]){

    }
}