public class P23_Trapping_Rain_Water {
    static long trappingWater(int arr[], int n) { 
        // Using left max and right max
        // Time complexity O(n) || Space complexity O(n)
        // long totalTrappedWater = 0;

        // int left_max[] = new int[n];
        // int right_max[] = new int[n];

        // left_max[0] = arr[0];
        // right_max[n-1] = arr[n-1];

        // for(int i=1; i<n; i++){
        //     left_max[i] = Math.max(left_max[i-1], arr[i]);
        // }

        // for(int i=n-2; i>=0; i--){
        //     right_max[i] = Math.max(right_max[i+1], arr[i]);
        // }

        // for(int i=1; i<n-1; i++){

        //     totalTrappedWater += Math.min(left_max[i], right_max[i]) - arr[i];

        // }
        
        // return totalTrappedWater;



        // Optimal Solution -> Two pointer approach
        // Time complexity O(n) || Space complexity O(1)
        int l = 0;
        int r = n-1;
        int leftMax = 0;
        int rightMax = 0;
        long trappedWater = 0;
        
        while(l <= r){
            if(arr[l] <= arr[r]){
                if(arr[l] >= leftMax){
                    leftMax = arr[l];
                }
                else{
                    trappedWater += leftMax - arr[l];
                }
                l++;
            }
            else{
                if(arr[r] >= rightMax){
                    rightMax = arr[r];
                }
                else{
                    trappedWater += rightMax - arr[r];
                }
                r--;
            }
        }
        
        return trappedWater;
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
