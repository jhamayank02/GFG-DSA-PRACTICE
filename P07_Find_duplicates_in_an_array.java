import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P07_Find_duplicates_in_an_array {
    
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here

        // Method - 1
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(arr); // Time Complexity - O(nlogn)
        int lastAdded = -1;

        for(int i = 1; i < n; i++){ // Time Complexity - O(n)

            if(arr[i] == arr[i-1] && arr[i] != lastAdded){
                ans.add(arr[i]);
                lastAdded = arr[i];
            }

        }

        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;

        // Resultant Time Complexitty = O(nlogn) + O(n) = O(nlogn)





        // METHOD - 2 -> Time Complexity O(nlogn)   ------> Need to correct - Adding duplicates in the resultant array more than once
        // ArrayList<Integer> ans = new ArrayList<>();

        // for(int i = 0; i < n; i++){

        //     int index = Math.abs(arr[i]);

        //     if(arr[index] < 0){
        //         ans.add(Math.abs(arr[i]));
        //     }
        //     else{
        //         arr[index] = -arr[index];
        //     }

        // }

        // Collections.sort(ans);
        // if(ans.size() == 0){
        //     ans.add(-1);
        // }
        // return ans;


        // Method - 3 -> 
        // ArrayList<Integer> ans = new ArrayList<>(n-1);

        // for(int i = 0; i < n; i++){

        //     ans.add(arr[i]-1, arr[i]++);

        // }

        // for(int i = 0; i < n; i++){

        //     if(ans.get(i-1) <= 1){
        //         ans.remove(i-1);
        //     }

        // }

        // return ans;
    }

    public static void main(String[] args) {
        
        // int N = 5;
        // int a[] = {2,3,1,2,3};

        int N = 4;
        int a[] = {0, 3, 1, 2};

        ArrayList<Integer> ans = duplicates(a, N);
        System.out.println("Result :- " + ans);
    }
}
