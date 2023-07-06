import java.util.*;

class P237_Print_longest_increasing_subsequence{

    public static void printLIS(int arr[], int n){
        int dp[] = new int[n];
        int hash[] = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = 1;
            hash[i] = i;
        }

        int maxi = 1;
        int lastIndex = 0;
        for(int ind=0; ind<n; ind++){
            for(int prev=0; prev<ind; prev++){

                if(arr[prev] < arr[ind]){
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
                    hash[ind] = prev;
                }

            }

            if(dp[ind] > maxi){
                maxi = Math.max(maxi, dp[ind]);
                lastIndex = ind;
            }
        }

        ArrayList<Integer> LIS = new ArrayList<>();

        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            LIS.add(0, arr[lastIndex]);
        }

        System.out.println(LIS);
    }

    public static void main(String args[]){
        int arr[] = {5,4,11,1,16,8};

        printLIS(arr, arr.length);
    }
}