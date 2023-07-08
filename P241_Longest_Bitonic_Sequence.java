import java.util.*;

class P241_Longest_Bitonic_Sequence{

    // Time complexity O(n^2) || Space complexity O(n)
    public static int longestBitonicSequence(int[] arr, int n) {
        int forwardLIS[] = new int[n];
        int backwardLIS[] = new int[n];

        for(int ind=0; ind<n; ind++){
            forwardLIS[ind] = 1;
            for(int prev=0; prev<ind; prev++){

                if(arr[ind] > arr[prev] && forwardLIS[ind] < 1 + forwardLIS[prev]){
                    forwardLIS[ind] = 1 + forwardLIS[prev];
                }

            }
        }

        for(int ind=n-1; ind>=0; ind--){
            backwardLIS[ind] = 1;
            for(int prev=n-1; prev>ind; prev--){

                if(arr[ind] > arr[prev] && backwardLIS[ind] < 1 + backwardLIS[prev]){
                    backwardLIS[ind] = 1 + backwardLIS[prev];
                }

            }
        }

        int bitonic[] = new int[n];

        int maxi = 0;
        for(int ind=0; ind<n; ind++){
            bitonic[ind] = forwardLIS[ind] + backwardLIS[ind] - 1;
            maxi = Math.max(maxi, bitonic[ind]);
        }

        return maxi;
    }

    public static void main(String args[]){

    }
}