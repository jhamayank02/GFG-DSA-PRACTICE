public class P08_Rotate_Array {
    
    
    public static void reverse(int arr[], int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n)
    {
        d = d%n; // Ensures that d is never greater than n
        
        // Revese the starting d-1 elements
        reverse(arr,0,d-1);

        // Reverse the last n-d elements
        reverse(arr,d,n-1);

        // Reverse the whole array
        reverse(arr,0,n-1);
    }

    public static void main(String[] args) {
        int N = 5, D = 2;
        int arr[] = {1,2,3,4,5};

        rotateArr(arr,D,N);

        System.out.print("Printing the array:- ");
        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
