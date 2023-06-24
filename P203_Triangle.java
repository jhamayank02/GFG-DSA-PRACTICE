import java.util.*;

class P203_Triangle{

      public static int solve(int r, int c, int n, int dp[][], int[][] triangle){
        // Base case
        if(r == n-1){
            return triangle[r][c];
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int down = triangle[r][c] + solve(r+1, c, n, dp, triangle);
        int diagonal = triangle[r][c] + solve(r+1, c+1, n, dp, triangle);

        return dp[r][c] = Math.min(down, diagonal);
    }
    public static int minimumPathSum(int[][] triangle, int n){
        // Memorization
        // Time complexity O(n*n) || Space complexity O(n*n)
        // int dp[][] = new int[n][n];

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // return solve(0, 0, n, dp, triangle);



        // Tabulation
        // Time complexity O(n*n) || Space complexity O(n*n)
        // int dp[][] = new int[n][n];

        // for(int i=0; i<n; i++){
        //     dp[n-1][i] = triangle[n-1][i];
        // }

        // for(int i=n-2; i>=0; i--){
        //     for(int j=i; j>=0; j--){

        //         int down = triangle[i][j] + dp[i+1][j];
        //         int diagonal = triangle[i][j] + dp[i+1][j+1];

        //         dp[i][j] = Math.min(down, diagonal);
        //     }
        // }

        // return dp[0][0];




        // Tabulation(Space Optimized)
        // Time complexity O(n*n) || Space complexity O(n)
        int prev[] = new int[n];
        for(int i=0; i<n; i++){
            prev[i] = triangle[n-1][i];
        }

        for(int i=n-2; i>=0; i--){

            int current[] = new int[n];

            for(int j=i; j>=0; j--){

                int down = triangle[i][j] + prev[j];
                int diagonal = triangle[i][j] + prev[j+1];

                current[j] = Math.min(down, diagonal);
            }

            prev = current;
        }

        return prev[0];
    }

    public static void main(String args[]){

    }
}