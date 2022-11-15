public class P09_Equilibrium_Point {
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here

        // Approach - 1 Time Complexity --> O(n*n)
        // int left_sum = 0, right_sum = 0;
        
        // for(int i = 0; i < n; i++){

        //     // Get the left_sum
        //     left_sum = 0;
        //     for(int j = 0; j < i; j++){
        //         left_sum += arr[j];
        //     }

        //     // Get the right_sum
        //     right_sum = 0;
        //     for(int j = i+1; j < n; j++){
        //         right_sum += arr[j];
        //     }

        //     if(left_sum == right_sum){
        //         return (i+1); // As question is asking for 1-based index (means index starting from 1)
        //     }

        // }

        // return -1;

        // Approach - 2 Time Complexity --> O(n)
        int left_sum = 0; int total_sum = 0;

        for(int i = 0; i < n; i++){
            total_sum += arr[i];
        }

        for(int j = 0; j < n; j++){
            total_sum -= arr[j]; // Here total_sum will work as right_sum
            
            if(left_sum == total_sum){
                return (j+1); // As question is asking for 1-based index (means index starting from 1)
            }
            
            left_sum += arr[j];
        }

        // If no equilibrium point found
        return -1;

    }

    public static void main(String[] args) {
        int n = 5; 
        long A[] = {1,3,5,2,2};
        // int n = 1; 
        // long A[] = {1};
        // int n = 30; 
        // long A[] = {20, 17, 42, 25, 32, 32, 30, 32, 37, 9, 2, 33, 31, 17, 14, 40, 9, 12, 36, 21, 8, 33, 6, 6, 10, 37, 12, 26, 21, 3};

        

        System.out.println("Equilibrium Point:- " + equilibriumPoint(A, n));
    }
}
