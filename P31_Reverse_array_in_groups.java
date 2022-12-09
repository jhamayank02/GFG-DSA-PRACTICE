import java.util.ArrayList;
import java.util.Collections;

public class P31_Reverse_array_in_groups {
    
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {

        // If k is greater than n then make k = n
        if(k>n){
            k = n;
        }

        // Starting and ending index of the subarray to be reversed
        int start = 0;
        int end = start + k - 1;
        
        // Repeat while more than 1 element is present in the subarray to be reversed
        while(end-start > 0){

            int i = start;
            int j = end;

            // Reverse the subarray
            while(i<j){
                Collections.swap(arr, i, j);
                i++;
                j--;
            }

            // Move start to element next to the end
            start = end + 1;

            // If the element remained is less than k then set k to the last element of the subarray
            if(n-end-1 <= k){
                end = n-1;
            }
            // Else set end for reversing next k elements
            else{
                end = start + k - 1;
            }

        }



    }

    public static void main(String[] args) {
        int N = 5, K = 77;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(35);
        arr.add(56);
        arr.add(48);
        arr.add(21);
        arr.add(87);

        reverseInGroups(arr, N, K);

        System.out.println(arr);
    }
}
