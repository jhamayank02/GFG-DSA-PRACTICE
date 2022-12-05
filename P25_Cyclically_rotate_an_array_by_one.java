class P25_Cyclically_rotate_an_array_by_one{

    public static void rotate(int arr[], int n)
    {
        for(int i=n-1; i>=1; i--){
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    public static void main(String[] args) {
        // int N = 5;
        // int A[] = {1, 2, 3, 4, 5};
        int N = 8;
        int A[] = {9, 8, 7, 6, 4, 2, 1, 3};

        rotate(A, N);

        for(int i=0; i<N; i++){
            System.out.print(A[i] + " ");
        }
    }

}