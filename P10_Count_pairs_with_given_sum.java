import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // Arrays.sort(arr);

        // int i = 0;
        // int j = n-1;
        // int pairsCount = 0;

        // while(i<j){
        //     int sum = arr[i] + arr[j];

        //     if(sum == k){
        //         pairsCount++;
        //         i++;
        //     }

        //     else if(sum < k){
        //         j++;
        //     }

        //     else if(sum > k){
        //         j--;
        //     }
        // }

        // return pairsCount++;



        // Approach - 3 -> Time complexity --> O(n)  Space Complexity --> O(n)

        HashMap<Integer, Integer> arrMap = new HashMap<>(); // Stores key-value pairs
        int pairsCount = 0;

        for(int i = 0; i < n; i++){

            // Only go inside if the element is less than the given sum as the question is asking for the sum of two numbers which results equals to the given number
            if(arr[i]<k){

                int element = k - arr[i]; // We have to check for this value in the map

                if(arrMap.containsKey(element)){
                    pairsCount += arrMap.get(element); // If the element is present in the map then add the frequency of the element to the pairsCount
                }

                if(arrMap.get(arr[i]) == null){
                    arrMap.put(arr[i], 0); // If value is not present then set it to 0
                }

                arrMap.put(arr[i], arrMap.get(arr[i]) + 1); // Now increase the frequency by 1

            }
        }

        return pairsCount;

    }

    public static void main(String[] args) {
        int N = 4, K = 6;
        int arr[] = {1, 5, 7, 1};

        System.out.println(getPairsCount(arr, N, K));
    }
}