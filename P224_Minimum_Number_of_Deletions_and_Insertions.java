import java.util.*;

class 224_Minimum_Number_of_Deletions_and_Insertions{

    // Tabulation
    // Time complexity O(n^2) || Space complexity O(n^2)
    public static int lcs(int n, int m, String s1, String s2){
        int dp[][] = new int[n+1][m+1];

        int maxi = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                // If match
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                // Not match
                else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);;
                }

                maxi = Math.max(maxi, dp[i][j]);
            }
        }

        return maxi;
    }

    // Tabulation(Space optimized)
    // Time complexity O(n^2) || Space complexity O(n)
    public static int lcsOptimized(int n, int m, String s1, String s2){
        int prev[] = new int[m+1];

        int maxi = 0;

        for(int i=1; i<=n; i++){
            int current[] = new int[m+1];

            for(int j=1; j<=m; j++){

                // If match
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    current[j] = 1 + prev[j-1];
                }
                // Not match
                else{
                    current[j] = 0 + Math.max(prev[j], current[j-1]);;
                }

                maxi = Math.max(maxi, current[j]);
            }

            prev = current;
        }

        return maxi;
    }

    // Time complexity O(n^2) || Space complexity O(n)
    public static int canYouMake(String str, String ptr) {
        int n = str.length();
        int m = ptr.length();

        // Length of longest common subsequence
        // int k = lcs(n, m, str, ptr);
        int k = lcsOptimized(n, m, str, ptr);

        int deletions = n - k;
        int insertions = m - k;

        return deletions + insertions;
    }

    public static void main(String args[]){

    }
}