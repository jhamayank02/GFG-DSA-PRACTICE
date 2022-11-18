public class P15_Wave_Array {
    
    public static void convertToWave(int n, int[] a) {
        // code here
        for(int i=0; i<n-1; i+=2){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
    }

    public static void main(String[] args) {
        // int n = 5;
        // int arr[] = {1,2,3,4,5};
        int n = 6;
        int arr[] = {2,4,7,8,9,10};

        convertToWave(n, arr);

        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
