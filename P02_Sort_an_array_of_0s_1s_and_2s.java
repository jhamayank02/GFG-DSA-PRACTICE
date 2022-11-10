import javax.swing.AbstractAction;

public class P02_Sort_an_array_of_0s_1s_and_2s {

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort012(int a[], int n)
    {
        // code here 

        int high = n-1;
        int low = 0;
        int mid = 0;
        int temp = 0;

        while(mid <= high){

        switch (a[mid]) {
            case 0:
                swap(a, low, mid);
                low++;
                mid++;
                break;

            case 1:
                mid++;
                break;

            case 2:
                swap(a, mid, high);
                high--;
                break;
        
            default:
                break;
        }

    }

        System.out.print("Array :- ");
        for(int i=0; i<n; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int arr[]= {0, 2, 1, 2, 0};

        sort012(arr, N);
        
    }
}
