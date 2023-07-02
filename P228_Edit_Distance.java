import java.util.*;

class P228_Edit_Distance{

    // Recursion
    // Time complexity >>O(3^n * 3^m) -> Exponential || Space complexity O(n+m)
    public static int solveRecursive(int i, int j, String s1, String s2){

        // Base case
        if(i<0){
            // j+1 insertions required
            return j+1;
        }
        if(j<0){
            // i+1 deletions required
            return i+1;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            // If the char matches then no need to do any operations
            return 0 + solveRecursive(i-1, j-1, s1, s2);
        }
        
        // At any index we can perform insert, delete, replace. Perform every operation and return the minimal one
        int insert = 1 + solveRecursive(i, j-1, s1, s2);
        int delete = 1 + solveRecursive(i-1, j, s1, s2);
        int replace = 1 + solveRecursive(i-1, j-1, s1, s2);

        return Math.min(insert, Math.min(delete, replace));
    }

    // Memoization
    // Time complexity (n*m) || Space complexity O(n*m) + O(n+m)
    public static int solveMemoization(int i, int j, String s1, String s2, int dp[][]){

        // Base case
        if(i<0){
            // j+1 insertions required
            return j+1;
        }
        if(j<0){
            // i+1 deletions required
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            // If the char matches then no need to do any operations
            return dp[i][j] = 0 + solveMemoization(i-1, j-1, s1, s2, dp);
        }
        
        // At any index we can perform insert, delete, replace. Perform every operation and return the minimal one
        int insert = 1 + solveMemoization(i, j-1, s1, s2, dp);
        int delete = 1 + solveMemoization(i-1, j, s1, s2, dp);
        int replace = 1 + solveMemoization(i-1, j-1, s1, s2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    // Tabulation
    // Time complexity (n*m) || Space complexity O(n*m)
    public static int solveTabulation(int n, int m, String s1, String s2){

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<=m; i++){
            dp[0][i] = i;
        }
        
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // If the char matches then no need to do any operations
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    // At any index we can perform insert, delete, replace. Perform every operation and return the minimal one
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    // Tabulation(Space optimized)
    // Time complexity (n*m) || Space complexity O(m)
    public static int solveTabulationOptimized(int n, int m, String s1, String s2){

        int prev[] = new int[m+1];

        for(int i=0; i<=m; i++){
            prev[i] = i;
        }

        for(int i=1; i<=n; i++){
            int current[] = new int[m+1];
            current[0] = i;

            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // If the char matches then no need to do any operations
                    current[j] = 0 + prev[j-1];
                }
                else{
                    // At any index we can perform insert, delete, replace. Perform every operation and return the minimal one
                    int insert = 1 + prev[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + current[j-1];

                    current[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = current;
        }

        return prev[m];
    }


    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // return solveRecursive(n-1, m-1, str1, str2);

        int dp[][] = new int[n][m];
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }

        // return solveMemoization(n-1, m-1, str1, str2, dp);

        return solveTabulation(n, m, str1, str2);
    }

    public static void main(String args[]){

    }
}