import java.util.*;

class P242_Number_of_Longest_Increasing_Subsequence{
    
    // Time complexity O(n^2) || Space complexity O(n)
    public static int findNumberOfLIS(int n, int[] arr) {
		int dp[] = new int[n];
		int count[] = new int[n];

		int maxLen = 0;

		for(int ind=0; ind<n; ind++){
			dp[ind] = 1;
			count[ind] = 1;

			for(int prev=0; prev<ind; prev++){
				
				if(arr[ind] > arr[prev] && dp[ind] < 1 + dp[prev]){
					dp[ind] = 1 + dp[prev];
					count[ind] = count[prev];
				}
				else if(arr[ind] > arr[prev] && dp[ind] == 1 + dp[prev]){
					count[ind] += count[prev];
				}

			}

			maxLen = Math.max(dp[ind], maxLen);
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++){
			if(dp[i] == maxLen){
				cnt += count[i];
			}
		}

		return cnt;
	}

    public static void main(String args[]){

    }
}