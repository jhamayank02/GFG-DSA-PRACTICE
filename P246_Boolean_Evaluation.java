import java.util.*;

class P246_Boolean_Evaluation{

    public static int mod = 1000000007;

    // Recursion
    // Time complexity O(n*4^n)Exponential || Space complexity O(n)
    public static int solveRecursive(int i, int j, int isTrue, String exp){
        // Base case
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue == 1){
                return exp.charAt(i)=='T' ? 1:0;
            }
            else{
                return exp.charAt(i)=='F' ? 1:0;
            }
        }

        int ways = 0;
        for(int ind=i+1; ind<j; ind+=2){
            int LT = solveRecursive(i, ind-1, 1, exp);
            int LF = solveRecursive(i, ind-1, 0, exp);
            int RT = solveRecursive(ind+1, j, 1, exp);
            int RF = solveRecursive(ind+1, j, 0, exp);

            if(exp.charAt(ind) == '&'){
                if(isTrue == 1){
                    ways = (ways + (LT * RT)%mod)%mod;
                }
                else{
                    ways = (ways + (LT * RF)%mod + (LF * RT)%mod + (LF * RF)%mod )%mod;
                }
            }
            else if(exp.charAt(ind) == '|'){
                if(isTrue == 1){
                    ways = (ways + (LT * RF)%mod + (LF * RT)%mod + (LT * RT)%mod )%mod;
                }
                else{
                    ways = (ways + (LF * RF)%mod)%mod;
                }
            }
            else{
                if(isTrue == 1){
                    ways = (ways + (LT * RF)%mod + (LF * RT)%mod)%mod;
                }
                else{
                    ways = (ways + (LF * RF)%mod + (LT * RT)%mod)%mod;
                }
            }

        }

        return ways;
    }

     // Memoization
     // Time complexity O(n*n*2*n) ~= O(n^3) || Space complexity O(n*n*2) + O(n)
    public static long solveMemoization(int i, int j, int isTrue, String exp, long dp[][][]){
        // Base case
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue == 1){
                return exp.charAt(i)=='T' ? 1:0;
            }
            else{
                return exp.charAt(i)=='F' ? 1:0;
            }
        }

        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for(int ind=i+1; ind<j; ind+=2){
            long LT = solveMemoization(i, ind-1, 1, exp, dp);
            long LF = solveMemoization(i, ind-1, 0, exp, dp);
            long RT = solveMemoization(ind+1, j, 1, exp, dp);
            long RF = solveMemoization(ind+1, j, 0, exp, dp);

            if(exp.charAt(ind) == '&'){
                if(isTrue == 1){
                    ways = (ways + (LT * RT)%mod)%mod;
                }
                else{
                    ways = (ways + (LT * RF)%mod + (LF * RT)%mod + (LF * RF)%mod )%mod;
                }
            }
            else if(exp.charAt(ind) == '|'){
                if(isTrue == 1){
                    ways = (ways + (LT * RF)%mod + (LF * RT)%mod + (LT * RT)%mod )%mod;
                }
                else{
                    ways = (ways + (LF * RF)%mod)%mod;
                }
            }
            else{
                if(isTrue == 1){
                    ways = (ways + (LT * RF)%mod + (LF * RT)%mod)%mod;
                }
                else{
                    ways = (ways + (LF * RF)%mod + (LT * RT)%mod)%mod;
                }
            }

        }

        return dp[i][j][isTrue] = ways;
    }   



    public static int evaluateExp(String exp) {
        int n = exp.length();
        // return solveRecursive(0, n-1, 1, exp);

        long dp[][][] = new long[n][n][2];
        for(long a[][] : dp){
            for(long b[] : a){
                Arrays.fill(b, -1);
            }
        }

        return (int)solveMemoization(0, n-1, 1, exp, dp);
    }

    public static void main(String args[]){

    }
}