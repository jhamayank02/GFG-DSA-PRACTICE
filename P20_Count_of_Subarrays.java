public class P20_Count_of_Subarrays {
    
    public static long countSubarray(int arr[], int n, int k) {

        // code here

        // Total subarrays that can be formed with n elements
        long totalSubarrays = (n*(n+1))/2;

        // Subarrays that we don't need
        long elemLessEqThanK = 0;

        
        for(int i=0; i<n; i++){

            if(arr[i]<=k){
                elemLessEqThanK++;
            }

            // If current element is greater than k then find total no. of subarrays from elemLessThanEq as we only need continuous subarrays
            else if(arr[i] >k && elemLessEqThanK != 0){
                totalSubarrays -= (elemLessEqThanK * (elemLessEqThanK+1))/2;
                elemLessEqThanK = 0;
            }
        }

        if(elemLessEqThanK != 0){
            totalSubarrays -= (elemLessEqThanK * (elemLessEqThanK+1))/2;
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {
        int N = 3, K = 2;
        int Arr[] = {3, 2, 1};
        // int N = 4, K = 1;
        // int Arr[] = {1,2,3,4};
        // int N = 4, K = 16;
        // int Arr[] = {30, 4, 23, 6};

        System.out.println(countSubarray(Arr, N, K));
    }
}
