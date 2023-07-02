import java.util.*;

class P227_Subsequence_Counting{

    static int mod = (int)(Math.pow(10,9)+7);

    // Recursion
    // Time complexity >> O(2^n * 2^m) -> Exponential || Space complexity O(n + m)
    public static int solveRecursive(int n, int m, String s1, String s2){

        // Base case
        if(m < 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(s1.charAt(n) == s2.charAt(m)){
            int take = solveRecursive(n-1, m-1, s1, s2);
            int notTake = solveRecursive(n-1, m, s1, s2);

            return (take + notTake) % mod;
        }
        else{
            return solveRecursive(n-1, m, s1, s2) % mod;
        }
    }

    // Memoization
    // Time complexity (n*m) || Space complexity O(n+m) + O(n*m)
    public static int solveMemoization(int n, int m, String s1, String s2, int dp[][]){

        // Base case
        if(m < 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)){
            int take = solveMemoization(n-1, m-1, s1, s2, dp);
            int notTake = solveMemoization(n-1, m, s1, s2, dp);

            return dp[n][m] = (take + notTake) % mod;
        }
        else{
            return dp[n][m] = solveMemoization(n-1, m, s1, s2, dp) % mod;
        }
    }

    // Tabulation
    // Time complexity (n*m) || Space complexity O(n*m)
    public static int solveTabulation(int n, int m, String s1, String s2){

        int dp[][] = new int[n+1][m+1];

        // Put 1 in 0th col
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        
        // // Put 0 in 0th row
        for(int i=1; i<=m; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    int take = dp[i-1][j-1];
                    int notTake = dp[i-1][j];

                    dp[i][j] = (take + notTake) % mod;
                }
                else{
                    dp[i][j] = dp[i-1][j] % mod;
                }

            }
        }

        return dp[n][m];
    }

// Tabulation(Space optimized)
// Time complexity (n*m) || Space complexity O(m)
public static int solveTabulationOptimized(int n, int m, String s1, String s2){

        int prev[] = new int[m+1];

        prev[0] = 1;
        
        for(int i=1; i<=m; i++){
            prev[i] = 0;
        }

        // **************************** Using 2 1-d array ****************************
        // for(int i=1; i<=n; i++){
        //     int current[] = new int[m+1];
        //     current[0] = 1;

        //     for(int j=1; j<=m; j++){

        //         if(s1.charAt(i-1) == s2.charAt(j-1)){
        //             int take = prev[j-1];
        //             int notTake = prev[j];

        //             current[j] = (take + notTake) % mod;
        //         }
        //         else{
        //             current[j] = prev[j] % mod;
        //         }

        //     }

        //     prev = current;
        // }

        // **************************** Using 1 1-d array ****************************
        for(int i=1; i<=n; i++){
            for(int j=m; j>=1; j--){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    int take = prev[j-1];
                    int notTake = prev[j];

                    prev[j] = (take + notTake) % mod;
                }
                else{
                    prev[j] = prev[j] % mod;
                }

            }
        }


        return prev[m];
    }

    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        
        // return solveRecursive(lt-1, ls-1, t, s);

        // int dp[][] = new int[lt][ls];

        // for(int a[] : dp){
        //     Arrays.fill(a, -1);
        // }

        // return solveMemoization(lt-1, ls-1, t, s, dp);

        // return solveTabulation(lt, ls, t, s);
        return solveTabulationOptimized(lt, ls, t, s);
    }

    public static void main(String args[]){

    }
}