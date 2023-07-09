import java.util.*;

class P244_Cost_to_Cut_a_Chocolate{

    // Recursion
    // Time complexity Exponential || Space complexity O(m)
    public static int solveRecursive(int i, int j, ArrayList<Integer> cut){
        if(i>j){
            return 0;
        }

        int mini = Integer.MAX_VALUE;
        for(int ind=i; ind<=j; ind++){
            int cost = cut.get(j+1)-cut.get(i-1) + solveRecursive(i, ind-1, cut) + solveRecursive(ind+1, j, cut);

            mini = Math.min(cost, mini);
        }

        return mini;
    }

    // Memoization
    // Time complexity O(m^3) || Space complexity O(m^2) + O(m)
    public static int solveMemoization(int i, int j, ArrayList<Integer> cut, int dp[][]){
        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int ind=i; ind<=j; ind++){
            int cost = cut.get(j+1)-cut.get(i-1) + solveMemoization(i, ind-1, cut, dp) + solveMemoization(ind+1, j, cut, dp);

            mini = Math.min(cost, mini);
        }

        return dp[i][j] = mini;
    }

    // Tabulation
    // Time complexity O(m^3) || Space complexity O(m^2)
    public static int solveTabulation(int n, int c, ArrayList<Integer> cut){
        int dp[][] = new int[c+2][c+2];
        for(int a[] : dp){
            Arrays.fill(a, 0);
        }

        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){

                if(i>j){
                    continue;
                }
                
                int mini = Integer.MAX_VALUE;
                for(int ind=i; ind<=j; ind++){
                    int cost = cut.get(j+1)-cut.get(i-1) + dp[i][ind-1] + dp[ind+1][j];

                    mini = Math.min(cost, mini);
                }

                dp[i][j] = mini;

            }
        }

        return dp[1][c];
    }

    public static int cost(int n, int c, int cuts[]) {

        ArrayList<Integer> cut = new ArrayList<>();

        cut.add(0);
        for(int i=0; i<c; i++){
            cut.add(cuts[i]);
        }
        cut.add(n);

        Collections.sort(cut);

        // return solveRecursive(1, c, cut);

        // int dp[][] = new int[c+1][c+1];
        // for(int a[] : dp){
        //     Arrays.fill(a, -1);
        // }

        // return solveMemoization(1, c, cut, dp);

        return solveTabulation(n, c, cut);
    }

    public static void main(String args[]){

    }
}