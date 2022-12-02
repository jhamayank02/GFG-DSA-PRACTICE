public class P23_Trapping_Rain_Water {
    static long trappingWater(int arr[], int n) { 
        // Your code here
        long totalTrappedWater = 0;

        int left_max[] = new int[n];
        int right_max[] = new int[n];

        left_max[0] = arr[0];
        right_max[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            left_max[i] = Math.max(left_max[i-1], arr[i]);
        }

        for(int i=n-2; i>=0; i--){
            right_max[i] = Math.max(right_max[i+1], arr[i]);
        }

        for(int i=1; i<n-1; i++){

            totalTrappedWater += Math.min(left_max[i], right_max[i]) - arr[i];

        }
        
        return totalTrappedWater;
    }

    public static void main(String[] args) {
        // int N = 6;
        // int arr[] = {3,0,0,2,0,4};
        int N = 3;
        int arr[] = {6,9,9};
        // int N = 4;
        // int arr[] = {7,4,0,9};
        // int N = 7;
        // int arr[] = {8, 8, 2, 4, 5, 5, 1};

        System.out.println(trappingWater(arr, N));
    }
}
