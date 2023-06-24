import java.util.*;

class P202_Minimum_Path_Sum{

    public static int solve(int r, int c, int dp[][], int grid[][]){

        // Base case
        if(r<0 || c<0){
            return (int)1e9;
        }
        if(r==0 && c==0){
            return grid[r][c];
        }

        if(dp[r][c] != -1 ){
            return dp[r][c];
        }

        int up = grid[r][c] + solve(r-1, c, dp, grid);
        int left = grid[r][c] + solve(r, c-1, dp, grid);

        return dp[r][c] = Math.min(up, left);
    }

    public static int minSumPath(int[][] grid) {
        // Memoization
        // Time complexity O(mn) || Space complexity O(mn)
    	// int n = grid.length;
        // int m = grid[0].length;

        // int dp[][] = new int[n][m];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // return solve(n-1, m-1, dp, grid);


        // Tabulation
        // Time complexity O(mn) || Space complexity O(mn)
        // int n = grid.length;
        // int m = grid[0].length;

        // int dp[][] = new int[n][m];

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){

        //         if(i==0 && j==0){
        //             dp[i][j] = grid[i][j];
        //         }
        //         else{
        //             int up = grid[i][j], left = grid[i][j];

        //             if(i>0){
        //                 up += dp[i-1][j];
        //             }
        //             else{
        //                 up += (int)1e9;
        //             }

        //             if(j>0){
        //                 left += dp[i][j-1];
        //             }
        //             else{
        //                 left += (int)1e9;
        //             }

        //             dp[i][j] = Math.min(left, up);
        //         }

        //     }
        // }

        // return dp[n-1][m-1];



        // Tabulation(Space optimized)
        // Time complexity O(mn) || Space complexity O(m)
        int n = grid.length;
        int m = grid[0].length;

        int prev[] = new int[m];

        for(int i=0; i<n; i++){
            int current[] = new int[m];
            for(int j=0; j<m; j++){

                if(i==0 && j==0){
                    current[j] = grid[i][j];
                }
                else{
                    int left = grid[i][j];
                    int up = grid[i][j];

                    if(i>0){
                        up += prev[j];
                    }
                    else{
                        up += (int)1e9;
                    }

                    if(j>0){
                        left += current[j-1];
                    }
                    else{
                        left += (int)1e9;
                    }

                    current[j] = Math.min(left, up);
                }
            }
            prev = current;
        }

        return prev[m-1];
    }

    public static void main(String args[]){

    }
}