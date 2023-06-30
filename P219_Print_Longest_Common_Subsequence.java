import java.util.*;

class P219_Print_Longest_Common_Subsequence{

    // Tabulation
    // Time complexity O(n * m) || Space complexity O(n*m)
	public static int solveTabulation(int n, int m, String s1, String s2, int dp[][]){

		for(int j=0; j<=m; j++){
			dp[0][j] = 0;
		}
		for(int i=0; i<=n; i++){
			dp[i][0] = 0;
		}

		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){

				// If match
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				// If not match
				else{
					dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
				}

			}
		}

		return dp[n][m];
	}

    // Time complexity O(n+m) || Space complexity O(1)
    public static String printLCS(int n, int m, String s1, String s2, int dp[][]){

        int i = n;
        int j = m;
        String ans = "";

        while(i > 0 && j > 0){

            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans += s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }

        }

        String revAns = "";
        for(int k=ans.length()-1; k>=0; k--){
            revAns += ans.charAt(k);
        }

        return revAns;
    }


    public static void main(String args[]){
        String s1 = "abcde";
        String s2 = "bdgek";

        int n = s1.length();
        int m = s2.length();

		int dp[][] = new int[n+1][m+1];

        solveTabulation(n, m, s1, s2, dp);

        System.out.println(printLCS(n, m, s1, s2, dp));
    }
}