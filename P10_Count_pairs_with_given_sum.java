import java.util.Arrays;

public class P10_Count_pairs_with_given_sum {
    public static int getPairsCount(int[] arr, int n, int k) {
        // code here

        // Approach - 1 Time Complexity --> O(n*n)
        // int pairsCount = 0;

        // for(int i = 0; i < n; i++){

        //     for(int j = i+1; j < n; j++){

        //         if((arr[i] + arr[j]) == k){
        //             pairsCount++;
        //         }

        //     }

        // }

        // return pairsCount;

        // Approach - 2 Time Complexity --> O(nlogn + n)
        Arrays.sort(arr);

        int i = 0;
        int j = n-1;
        int pairsCount = 0;

        while(i<j){
            int sum = arr[i] + arr[j];

            if(sum == k){
                pairsCount++;
                i++;
            }

            else if(sum < k){
                j++;
            }

            else if(sum > k){
                j--;
            }
        }

        return pairsCount++;
    }

    public static void main(String[] args) {
        int N = 4, K = 6;
        int arr[] = {1, 5, 7, 1};

        System.out.println(getPairsCount(arr, N, K));
    }
}
