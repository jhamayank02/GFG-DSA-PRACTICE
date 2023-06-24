import java.util.*;

class P199_House_Robber_2{

    public static int solve(int ind, int lastInd, int valueInHouse[], int dp[]){
		if(ind < lastInd){
			return 0;
		}
		if(ind == lastInd){
			return valueInHouse[ind];
		}

		if(dp[ind] != -1){
			return dp[ind];
		}

		int pick = valueInHouse[ind] + solve(ind-2, lastInd, valueInHouse, dp);
		int notPick = 0 + solve(ind-1, lastInd, valueInHouse, dp);

		return dp[ind] = Math.max(pick, notPick);
	}

    public static int tabulation(int n, int last, int a[]){
		int prev1 = a[last];
		int prev2 = 0;

		for(int i=last+1; i<=n; i++){

			int pick = a[i] + prev2;

			int notPick = 0 + prev1;

			int curri = Math.max(pick, notPick);

			prev2 = prev1;
			prev1 = curri;
		}

		return prev1;
    }

	public static long houseRobber(int[] valueInHouse) {
        // Memoization
        // Time complexity O(n) || Space complexity O(n)
		// int n = valueInHouse.length;

		// if(n==1){
		// 	return valueInHouse[0];
		// }

		// int dp[] = new int[n];
		// Arrays.fill(dp, -1);

		// // 1 to n-1
		// int ans1 = solve(n-1, 1, valueInHouse, dp);

		// Arrays.fill(dp, -1);
		// // 0 to n-2
		// int ans2 = solve(n-2, 0, valueInHouse, dp);

		// return Math.max(ans1, ans2);



        // Tabulation
        // Time complexity O(n) || Space complexity O(1)
        int n = valueInHouse.length;

        if(n == 1){
            return valueInHouse[0];
        }

        int ans1 = tabulation(n-1, 1, valueInHouse);
        int ans2 = tabulation(n-2, 0, valueInHouse);

        return Math.max(ans1, ans2);
	}	

    public static void main(String args[]){

    }
}