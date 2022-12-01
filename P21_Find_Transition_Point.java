public class P21_Find_Transition_Point {

    public static int transitionPoint(int arr[], int n) {
        // code here


        // APPROACH 1 : Time Complexity -> O(n)
        // for(int i=0; i<n; i++){
        //     if(arr[i]==1){
        //         return i;
        //     }
        // }

        // return -1;

        // APPROACH 2 : Time Complexity -> O(logn)
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;
        int transitionIndex = -1;

        while(start<=end){
            if(arr[mid] == 0){
                start = mid + 1;
            }
            else{
                transitionIndex = mid;
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }

        return transitionIndex;

    }

    public static void main(String[] args) {
        // int N = 5;
        // int arr[] = {0,0,0,1,1};
        // int N = 4;
        // int arr[] = {0,0,0,1};
        int N = 4;
        int arr[] = {0,0,0,0};
        // int N = 1;
        // int arr[] = {1};

        System.out.println(transitionPoint(arr, N));
    }
}
