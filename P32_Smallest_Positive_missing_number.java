public class P32_Smallest_Positive_missing_number {
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        int minMissingNo = 1;

        for(int i=0; i<size; i++){

            if(arr[i] < 0){
                continue;
            }

            if(arr[i] <= minMissingNo){
                minMissingNo = arr[i]+1;
            }


        }

        return minMissingNo;
    }
    
    public static void main(String[] args) {
        int N = 5;
        int arr[] = {0,-10,1,3,-20};

        // int N = 5;
        // int arr[] = {1,2,3,4,5};

        // int N = 8;
        // int arr[] = {28, 7, -36, 21, -21, -50, 9, -32};

        System.out.println(missingNumber(arr, N));
    }
}
