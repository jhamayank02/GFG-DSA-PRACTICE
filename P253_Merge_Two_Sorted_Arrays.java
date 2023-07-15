import java.util.*;

class P253_Merge_Two_Sorted_Arrays{

    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Using an auxiliary array
        // Time complexity O(m+n) || Space complexity O(m+n)
        int ans[] = new int[m+n];

        int ptr = 0;
        int i = 0;
        int j = 0;

        while(i<m && j<n){
            if(arr1[i] <= arr2[j]){
                ans[ptr++] = arr1[i++];
            }
            else{
                ans[ptr++] = arr2[j++];
            }
        }

        while(i<m){
            ans[ptr++] = arr1[i++];
        }
        while(j<n){
            ans[ptr++] = arr2[j++];
        }

        return ans;
    }

    public static void main(String args[]){

    }
}