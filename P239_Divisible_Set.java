import java.util.*;

class P239_Divisible_Set{

    // Time complexity O(n^2) || Space complexity O(n)
    public static ArrayList<Integer> divisibleSet(int arr[]) {
        
        int n = arr.length;
        int dp[] = new int[n]; // Will contain the lengths of the largest subarrays
        int hash[] = new int[n]; // Contains the parent/prev of the elements

        Arrays.fill(dp, 1);

        Arrays.sort(arr);

        for(int ind=1; ind<n; ind++){
            hash[ind] = ind;

            for(int prev=0; prev<ind; prev++){
                if(arr[ind] % arr[prev] == 0 && 1 + dp[prev] > dp[ind]){
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
                    hash[ind] = prev;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxInd = -1;
        for(int i=0; i<n; i++){
            if(dp[i] > max){
                max = dp[i];
                maxInd = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[maxInd]);

        while(hash[maxInd] != maxInd){
            maxInd = hash[maxInd];
            ans.add(arr[maxInd]);
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String args[]){
        int arr[] = {1, 16, 7, 8, 4};

        System.out.println(divisibleSet(arr));
    }
}