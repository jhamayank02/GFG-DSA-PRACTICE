import java.util.*;

class P200_Ninjas_Training{

    public static int solve(int day, int last, int dp[][], int points[][]){
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + solve(day - 1, i, dp, points);
                maxi = Math.max(maxi, activity);
            }

        }

        return dp[day][last] = maxi;
    }

    public static int ninjaTraining(int n, int points[][]) {
        // Memoization
        // Time complexity (n * 4 * 3) || Space complexity O(n * 4)
        // int dp[][] = new int[n][4];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<4; j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // return solve(n-1, 3, dp, points);


        // Tabulation
        // Time complexity (n * 4 * 3) || Space complexity O(n * 4)
        // int dp[][] = new int[n][4];

        // dp[0][0] = Math.max(points[0][1], points[0][2]);
        // dp[0][1] = Math.max(points[0][0], points[0][2]);
        // dp[0][2] = Math.max(points[0][0], points[0][1]);
        // dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // for(int day = 1; day < n; day++){

        //     for(int last = 0; last < 4; last++){
        //         int maxi = 0;
        //          for (int task = 0; task <= 2; task++) {
        //             if (task != last) {
        //                 int point = points[day][task] + dp[day-1][task];
        //                 maxi = Math.max(maxi, point);
        //             }
        //         }
        //         dp[day][last] = maxi;
        //     }

        // }

        // return dp[n-1][3];


        // Tabulation(space Optmized)
        // Time complexity (n * 4 * 3) || Space complexity O(1)
        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {

            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;

        }

        return prev[3];
    }

    public static void main(String args[]){

    }
}