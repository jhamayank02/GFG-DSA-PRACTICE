import java.util.ArrayList;

public class P30_Maximum_of_all_subarrays_of_size_k {
    
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here

        // Time Complexity - O(n*2) = O(2n) - O(n)
        ArrayList<Integer> ans = new ArrayList<>(); // To store returning array
        ArrayList<Integer> temp = new ArrayList<>(); // To store subarrays

        // If size of array is less than or equal to the size of subarray
        if(k >= n){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<3; j++){
                if(arr[j]>max){
                    max = arr[j];
                }
            }
            ans.add(max);
            return ans;
        }

        int countElem = 0; // Keeps track of elements in temp array
        for(int i=0; i<n; i++){

            // If temp array is not full then keep adding elements
            if(countElem<k){

                temp.add(arr[i]);
                countElem++;
            }

            // If elements in temp array is equal to the size of the subarray then find the max value of that temp array
            if(countElem == k){
                int max = Integer.MIN_VALUE;
                for(int j=0; j<3; j++){
                    if(temp.get(j)>max){
                        max = temp.get(j);
                    }
                }
                ans.add(max);

                // Remove first element from the subarray
                temp.remove(0);
                // As one element is removed, reduce the countElem
                countElem--;
            }

        }


        return ans;
    }

    public static void main(String[] args) {
        // int N = 9, K = 3;
        // int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int N = 10, K = 4;
        int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        System.out.println(max_of_subarrays(arr, N, K));
    }
}
