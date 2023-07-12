import java.util.*;

class P248_Partition_Array_for_Maximum_Sum{

    // Recursion
    // Time complexity Exponential || Space complexity O(n)
    public static int solveRecursive(int num[], int k, int ind, int n){

        // Base case
        if(ind==n){
            return 0;
        }

        int maxAns = Integer.MIN_VALUE;
        int len = 0;
        int maxElem = Integer.MIN_VALUE;

        for(int i=ind; i<Math.min(n, ind+k); i++){

            len++;
            maxElem = Math.max(maxElem, num[i]);
            int sum = len * maxElem + solveRecursive(num, k, i+1, n);

            maxAns = Math.max(maxAns, sum);
        }

        return maxAns;
    }

    // Memoization
    // Time complexity O(n*k) || Space complexity O(n) + O(n)
     public static int solveMemoization(int num[], int k, int ind, int n, int dp[]){

        // Base case
        if(ind==n){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int maxAns = Integer.MIN_VALUE;
        int len = 0;
        int maxElem = Integer.MIN_VALUE;

        for(int i=ind; i<Math.min(n, ind+k); i++){

            len++;
            maxElem = Math.max(maxElem, num[i]);
            int sum = len * maxElem + solveMemoization(num, k, i+1, n, dp);

            maxAns = Math.max(maxAns, sum);
        }

        return dp[ind] = maxAns;
    }

    // Tabulation
    // Time complexity O(n*k) || Space complexity O(n)
    public static int solveTabulation(int num[], int k, int n){
        int dp[] = new int[n+1];

        // Base case
        dp[n] = 0;

        for(int ind=n-1; ind>=0; ind--){

            int maxAns = Integer.MIN_VALUE;
            int len = 0;
            int maxElem = Integer.MIN_VALUE;

            for(int j=ind; j<Math.min(n, ind+k); j++){

                len++;
                maxElem = Math.max(maxElem, num[j]);
                int sum = len * maxElem + solveMemoization(num, k, j+1, n, dp);

                maxAns = Math.max(maxAns, sum);

            }

            dp[ind] = maxAns;
        }

        return dp[0];
    }

    public static int maximumSubarray(int num[], int k) {
        // return solveRecursive(num, k, 0, num.length);

        int n = num.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // return solveMemoization(num, k, 0, n, dp);

        return solveTabulation(num, k, n);
    }

    public static void main(String args[]){

    }
}