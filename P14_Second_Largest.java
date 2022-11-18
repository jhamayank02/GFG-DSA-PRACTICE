public class P14_Second_Largest {
    
    public static int print2largest(int arr[], int n) {
        // code here

        // If the array is empty or array doesn't contain second element then return -1
        if(n == 0 || n == 1){
            return -1;
        }

        int largest = arr[0];
        int secondLargest = -1;

        // Finds the first largest element of the array
        for(int i = 1; i < n; i++){
            if(largest < arr[i]){
                largest = arr[i];
            }
        }

        // Finds the second largest element of the array
        for(int i = 0; i < n; i++){
            if(secondLargest < arr[i] && arr[i] < largest){
                secondLargest = arr[i];
            }
        }
       
        return secondLargest;
    }

    public static void main(String[] args) {
        int N = 6;
        int Arr[] = {12, 35, 1, 10, 34, 1};

        System.out.println(print2largest(Arr, N));
    }
}
