import java.util.*;

class P230_Wildcard_Pattern_Matching{

    // Recursion
    // Time complexity >>O(2^n * 2^m) (Exponential) || Space complexity O(n+m)
    public static boolean solveRecursive(int i, int j, String s1, String s2){
		// Base case

		// s1 and s2 both exhausted
		if(i<0 && j<0){ return true; }

		// s1 exhausted
		if(i<0){ return false; }

		// s2 exhausted
		if(j<0){
			// Return true only if s1 only has * as * can match with any string length from 0 to n
			while(i >= 0){
				if(s1.charAt(i) != '*'){
					return false;
				}
				i--;
			}
			return true;
		}

		if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
			return solveRecursive(i-1, j-1, s1, s2);
		}
		else if(s1.charAt(i) == '*'){
			return solveRecursive(i, j-1, s1, s2) || solveRecursive(i-1, j, s1, s2);
		}
		else{
			return false;
		}
	}

    // Memoization
    // Time complexity O(n * m) || Space complexity O(n+m) + O(n*m)
	public static int solveMemoization(int i, int j, String s1, String s2, int dp[][]){

		// dp[i][j] = 0 -> false
		// dp[i][j] = 1 -> true
		// dp[i][j] = -1 -> unvisited


		// Base case

		// s1 and s2 both exhausted
		if(i<0 && j<0){ return 1; }

		// s1 exhausted
		if(i<0){ return 0; }

		// s2 exhausted
		if(j<0){
			// Return true only if s1 only has * as * can match with any string length from 0 to n
			while(i >= 0){
				if(s1.charAt(i) != '*'){
					return 0;
				}
				i--;
			}
			return 1;
		}

		if(dp[i][j] != -1){
			return dp[i][j];
		}

		if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
			return dp[i][j] = solveMemoization(i-1, j-1, s1, s2, dp);
		}
		else if(s1.charAt(i) == '*'){
			int trimS2 = solveMemoization(i, j-1, s1, s2, dp);
			int trimS1 = solveMemoization(i-1, j, s1, s2, dp);

			if(trimS1 == 1 || trimS2 == 1){
				return dp[i][j] = 1;
			}
			else{
				return dp[i][j] = 0;
			}
		}
		else{
			return dp[i][j] = 0;
		}
	}

    // Tabulation
    // Time complexity O(n * m) || Space complexity O(n*m)
	public static boolean solveTabulation(int p, int t, String s1, String s2){

		boolean dp[][] = new boolean[p+1][t+1];

		dp[0][0] = true;

		for(int i=1; i<=p; i++){
			boolean flag = true;

			for(int j=1; j<=i; j++){
				if(s1.charAt(j-1) != '*'){
					flag = false;
				}
			}

			dp[i][0] = flag;
		}

		for(int i=1; i<=t; i++){
			dp[0][i] = false;
		}

		for(int i=1; i<=p; i++){
			for(int j=1; j<=t; j++){

				if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?'){
					dp[i][j] = dp[i-1][j-1];
				}
				else if(s1.charAt(i-1) == '*'){
					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				}
				else{
					dp[i][j] = false;
				}

			}
		}

		return dp[p][t];
	}

    // Tabulation(Space optimized)
    // Time complexity O(n * m) || Space complexity O(m)
	public static boolean solveTabulationOptimized(int p, int t, String s1, String s2){

		boolean prev[] = new boolean[t+1];

		prev[0] = true;

		for(int i=1; i<=p; i++){

			boolean current[] = new boolean[t+1];

			boolean flag = true;

			for(int j=1; j<=i; j++){
				if(s1.charAt(j-1) != '*'){
					flag = false;
				}
			}

			current[0] = flag;

			for(int j=1; j<=t; j++){

				if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?'){
					current[j] = prev[j-1];
				}
				else if(s1.charAt(i-1) == '*'){
					current[j] = prev[j] || current[j-1];
				}
				else{
					current[j] = false;
				}

			}

			prev = current;
		}

		return prev[t];
	}

	public static boolean wildcardMatching(String pattern, String text) {
		int p = pattern.length();
		int t = text.length();

		// return solveRecursive(p-1, t-1, pattern, text);

		// int dp[][] = new int[p][t];
		// for(int a[] : dp){
		// 	Arrays.fill(a, -1);
		// }

		// int ans = solveMemoization(p-1, t-1, pattern, text, dp);

		// if(ans==0){ return false; }
		// else{ return true; }


		// return solveTabulation(p, t, pattern, text);
		return solveTabulationOptimized(p, t, pattern, text);
	}

    public static void main(String args[]){

    }
}