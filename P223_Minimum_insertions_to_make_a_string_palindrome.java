import java.util.*;

class P223_Minimum_insertions_to_make_a_string_palindrome{

    // Tabulation
    // Time complexity O(n^2) || Space complexity O(n^2)
    public static int lcs(int n, String s1, String s2){
        int dp[][] = new int[n+1][n+1];

        int maxi = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){

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
    public static int minInsertion(String str) {
    	int n = str.length();

        // Reverse the string
        String str2 = "";
        for(int i=n-1; i>=0; i--){
            str2 += str.charAt(i);
        }

        // Length of longest common subsequence
        // int palindromeLen = lcs(n, str, str2);
        int palindromeLen = lcsOptimized(n, n, str, str2);


        return (n - palindromeLen);
    }

    public static void main(String args[]){

    }
}