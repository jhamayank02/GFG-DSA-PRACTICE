import java.util.*;

class P225_Shortest_Common_Supersequence{

    // Tabulation
    // Time complexity O(n*m) || Space complexity O(n*m)
    public static void makeDpTable(int n, int m, String s1, String s2, int dp[][]){

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                
                // If match
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                // Not match
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

    }

    // Time complexity O(n) || Space complexity O(1)
    public static String reverse(String s){
        int n = s.length();

        String rev = "";
        
        for(int i=n-1; i>=0; i--){
            rev += s.charAt(i);
        }

        return rev;
    }

    // Time complexity O(n*m) || Space complexity (n+m-len(lcs))
    public static String printSuperseq(int dp[][], int n, int m, String s1, String s2){

        int i = n;
        int j = m;
        String superSeq = "";

        while(i>0 && j>0){
            
            // In DP table we are following 1-based indexing while in the strings 0-based indexing has been followed
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                superSeq += s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                superSeq += s1.charAt(i-1);
                i--;
            }
            else{
                superSeq += s2.charAt(j-1);
                j--;
            }

        }

        while(i>0){
            superSeq += s1.charAt(i-1);
            i--;
        }

        while(j>0){
            superSeq += s2.charAt(j-1);
            j--;
        }

        return reverse(superSeq);
    }

    // Time complexity O(n*m) || Space complexity (n*m)
    public static String shortestSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        int dp[][] = new int[n+1][m+1];

        makeDpTable(n, m, a, b, dp);

        return printSuperseq(dp, n, m, a, b);
    }

    public static void main(String args[]){

    }
}