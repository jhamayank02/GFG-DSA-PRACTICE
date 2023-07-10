import java.util.*;

class P245_Mining_Diamonds{

    // Recursion
    // Time complexity O(n * 2^n) Exponential || Space complexity O(n)
    public static int solveRecursive(int i, int j, ArrayList<Integer> arr){

        // Base case
        if(i>j){
            return 0;
        }

        int maxi = Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++){
            int coins = arr.get(i-1)*arr.get(ind)*arr.get(j+1) + solveRecursive(i, ind-1, arr) + solveRecursive(ind+1, j, arr);
            maxi = Math.max(maxi, coins);
        }

        return maxi;
    }

    // Memoization
    // Time complexity O(n^2 * n) ~= O(n^3) || Space complexity O(n^2) + O(n)
    public static int solveMemoization(int i, int j, ArrayList<Integer> arr, int dp[][]){

        // Base case
        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++){
            int coins = arr.get(i-1)*arr.get(ind)*arr.get(j+1) + solveMemoization(i, ind-1, arr, dp) + solveMemoization(ind+1, j, arr, dp);
            maxi = Math.max(maxi, coins);
        }

        return dp[i][j] = maxi;
    }

    // Tabulation
    // Time complexity O(n^3) || Space complexity O(n^2)
    public static int solveTabulation(ArrayList<Integer> arr, int n){
        int dp[][] = new int[n+2][n+2];

        for(int i=n; i>=1; i--){
            for(int j=1; j<=n; j++){

                // No element in the range
                if(i>j){
                    continue;
                }

                int maxi = Integer.MIN_VALUE;
                for(int ind=i; ind<=j; ind++){
                    int coins = arr.get(i-1)*arr.get(ind)*arr.get(j+1) + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, coins);
                }

                dp[i][j] = maxi; 

            }
        }

        return dp[1][n];
    }

    public static int maxCoins(int a[]) {
        int n = a.length;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i: a){
            arr.add(i);
        }
        arr.add(1);

        // return solveRecursive(1, n, arr);

        // int dp[][] = new int[n+1][n+1];
        // for(int b[] : dp){
        //     Arrays.fill(b, -1);
        // }

        // return solveMemoization(1, n, arr, dp);

        return solveTabulation(arr, n);
    }

    public static void main(String args[]){

    }
}