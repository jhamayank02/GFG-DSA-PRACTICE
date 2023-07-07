import java.util.*;

class P240_Longest_String_Chain{

public static boolean checkPossibility(String curr, String prev){
		if(curr.length() != prev.length()+1){
			return false;
		}

		int first = 0; // Points to curr
		int second = 0; // Points to prev

		while(first < curr.length()){
			if(second < prev.length() && curr.charAt(first) == prev.charAt(second)){
				first++;
				second++;
			}
			else{
				first++;
			}
		}

		if(first == curr.length() && second == prev.length()){
			return true;
		}
		return false;
	}

    // Time complexity O(n^2 * l) || Space complexity (n)
	public static int longestStrChain(int n, String[] arr) {
		int dp[] = new int[n];
		int maxi = 1;

		Arrays.sort(arr, Comparator.comparing(s->s.length()));

		for(int ind=0; ind<n; ind++){
			dp[ind] = 1;

			for(int prev=0; prev<ind; prev++){

				if(checkPossibility(arr[ind], arr[prev]) && dp[ind] < 1 + dp[prev]){
					dp[ind] = 1 + dp[prev];
				}

			}

			maxi = Math.max(maxi, dp[ind]);
		}
		
		return maxi;
	}

    public static void main(String args[]){

    }

}